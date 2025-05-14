import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인서, 준석, 정우, 진우, 영기
        int[][] workDifficulty  = new int[5][5];
        int[][] workProcessTime = new int[5][5];


        // 일의 난이도 배열
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                workDifficulty[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 일의 처리시간 배열
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                workProcessTime[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 계산
        int[][] work = new int[5][5];
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                int sum = 0;
                for (int i = 0; i < 5; i++) {
                    sum += workDifficulty[x][i] * workProcessTime[i][y];
                }
                work[x][y] = sum;
            }
        }

        // 총 일량 계산
        int[] total = new int[5];
        for (int person = 0; person < 5; person++) {
            for (int task = 0; task < 5; task++) {
                total[person] = total[person] + work[person][task];
            }
        }

        // 최소값 찾기
        int      minValue = Integer.MAX_VALUE;
        int      minIdex  = 4;
        String[] names    = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
        for (int i = 4; i >= 0; i--) {
            if (total[i] < minValue) {
                minValue = total[i];
                minIdex  = i;
            }
        }
        System.out.println(names[minIdex]);


    }
}