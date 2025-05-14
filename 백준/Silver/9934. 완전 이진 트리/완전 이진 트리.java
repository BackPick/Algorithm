import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int            K;                  // 트리의 깊이
    static int[]          arr;              // 입력 배열
    static StringBuffer[] ans;     // 결과를 저장할 배열

    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        // 트리의 노드 수 만큼 배열 크기 설정
        arr = new int[(int) Math.pow(2, K) - 1];
        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 저장을 위한 StringBuffer 배열 초기화
        ans = new StringBuffer[K];
        for (int i = 0; i < K; i++) {
            ans[i] = new StringBuffer();
        }

        // 재귀적으로 트리의 값을 계산
        solve(0, arr.length - 1, 0);

        // 결과 출력
        for (int i = 0; i < K; i++) {
            bw.write(ans[i].toString()
                    .trim() + "\n"); // 공백 제거 후 출력
        }

        // BufferedWriter 닫기
        bw.flush();
        bw.close();
    }

    // 재귀적으로 트리의 값을 계산하는 메소드
    public static void solve(int s, int e, int floor) {
        if (floor == K) return; // 깊이가 K에 도달하면 종료

        int m = (s + e) / 2; // 중간 인덱스 계산
        ans[floor].append(arr[m])
                .append(" "); // 중간 값 추가

        // 왼쪽과 오른쪽 자식 노드 재귀 호출
        solve(s, m - 1, floor + 1);
        solve(m + 1, e, floor + 1);
    }
}
