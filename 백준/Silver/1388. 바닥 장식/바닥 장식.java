
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br             = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st             = new StringTokenizer(br.readLine());
        int             N              = Integer.parseInt(st.nextToken());
        int             M              = Integer.parseInt(st.nextToken());
        char[][]        room           = new char[N][M];
        boolean[][]     roomCheck      = new boolean[N][M];
        int             woodPlankCount = 0;

        // 방의 바닥 장식 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        // ' - ' 의 판자 수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == '-' && !roomCheck[i][j]) {
                    woodPlankCount++;
                    while (j < M && room[i][j] == '-') {
                        roomCheck[i][j] = true;
                        j++;
                    }
                }
            }
        }

        // ' | ' 의 판자 수 세기
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '|' && !roomCheck[i][j]) {
                    woodPlankCount++;
                    while (i < N && room[i][j] == '|') {
                        roomCheck[i][j] = true;
                        i++;
                    }
                }
            }
        }
        System.out.println(woodPlankCount);
    }
}
