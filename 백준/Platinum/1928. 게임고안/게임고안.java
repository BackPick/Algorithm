import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // probs[u][v][la][ld]: 공격u명 vs 수비v명 싸웠을 때, 공격la명, 수비ld명 죽을 확률
    static double[][][][] probs = new double[4][4][4][4];
    static int[] diceA = new int[3];
    static int[] diceB = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // 1. 전투 결과 확률 미리 계산 (Precomputation)
        precomputeProbabilities();

        // 2. DP 수행
        // dp[a][d]: 공격팀 a명, 수비팀 d명 남았을 때 공격팀 승리 확률
        // N이 1000이므로 A는 그보다 좀 더 클 것임. 넉넉하게 잡거나 동적으로 확장.
        // 경험적으로 4*N 정도면 충분함.
        int maxA = 5000; 
        double[][] dp = new double[maxA + 1][N + 1];

        // 초기값 설정: 수비팀이 0명이면 공격팀 승리 (확률 1.0)
        for (int a = 1; a <= maxA; a++) {
            dp[a][0] = 1.0;
        }
        // 공격팀이 1명이면 공격 불가 -> 수비팀 승리 (확률 0.0), 자바 배열 기본값이 0.0이므로 생략 가능

        // a를 늘려가며 dp 테이블 채우기
        for (int a = 2; a <= maxA; a++) {
            // 이번 a에 대해 d를 1부터 N까지 계산
            for (int d = 1; d <= N; d++) {
                int sendA = Math.min(3, a - 1); // 공격팀: 최소 1명 남겨야 함
                int sendD = Math.min(3, d);     // 수비팀: 다 나갈 수 있음

                double winProb = 0.0;
                
                // 가능한 모든 전투 결과(la:공격사망수, ld:수비사망수)에 대해 가중 합
                // 싸우는 쌍의 수는 min(sendA, sendD)
                int battles = Math.min(sendA, sendD);
                
                // la + ld는 항상 battles와 같아야 함 (각 쌍마다 한 명은 죽으므로)
                for (int la = 0; la <= battles; la++) {
                    int ld = battles - la;
                    double p = probs[sendA][sendD][la][ld];
                    
                    if (p > 0) {
                        winProb += p * dp[a - la][d - ld];
                    }
                }
                dp[a][d] = winProb;
            }

            // 만약 현재 a명으로 수비 N명을 이길 확률이 50% 넘으면 정답 출력 후 종료
            if (dp[a][N] > 0.5) {
                System.out.println(a);
                return;
            }
        }
    }

    // 모든 u(1~3), v(1~3) 조합에 대해 확률 계산
    private static void precomputeProbabilities() {
        for (int u = 1; u <= 3; u++) {
            for (int v = 1; v <= 3; v++) {
                simulate(u, v);
            }
        }
    }

    // u명 vs v명 시뮬레이션 (모든 주사위 경우의 수 탐색)
    private static void simulate(int u, int v) {
        int totalCases = 1;
        for (int i = 0; i < u + v; i++) totalCases *= 6;

        int[] outcomes = new int[u + v]; // 주사위 굴리기용 임시 배열
        dfs(0, u, v, outcomes);
    }

    private static void dfs(int depth, int u, int v, int[] outcomes) {
        if (depth == u + v) {
            // 주사위 눈 결정됨, 전투 판정
            // outcomes 앞 u개는 A팀, 뒤 v개는 B팀
            for(int i=0; i<u; i++) diceA[i] = outcomes[i];
            for(int i=0; i<v; i++) diceB[i] = outcomes[u+i];

            // 정렬 (오름차순이므로 뒤에서부터 비교)
            Arrays.sort(diceA, 0, u);
            Arrays.sort(diceB, 0, v);

            int la = 0;
            int ld = 0;
            int pairs = Math.min(u, v);

            for (int i = 0; i < pairs; i++) {
                // 가장 높은 눈: diceA[u-1], diceB[v-1]
                int valA = diceA[u - 1 - i];
                int valB = diceB[v - 1 - i];

                if (valA > valB) {
                    ld++; // 수비 죽음
                } else {
                    la++; // 공격 죽음 (같거나 작으면)
                }
            }
            
            // 경우의 수 누적 (나중에 전체 경우의 수로 나눠서 확률화)
            // 여기서는 확률을 바로 더하기 위해 전체 경우의 수 역수를 더함
            double probUnit = 1.0 / Math.pow(6, u + v);
            probs[u][v][la][ld] += probUnit;
            return;
        }

        for (int val = 1; val <= 6; val++) {
            outcomes[depth] = val;
            dfs(depth + 1, u, v, outcomes);
        }
    }
}