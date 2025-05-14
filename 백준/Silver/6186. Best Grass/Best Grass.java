
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] fieldCheck = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader  br          = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st          = new StringTokenizer(br.readLine());
        int             Y           = Integer.parseInt(st.nextToken());
        int             X           = Integer.parseInt(st.nextToken());
        int             resultCount = 0;
        int[][]         field       = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            String line = br.readLine();
            for (int j = 0; j < X; j++) {
                field[i][j] = line.charAt(j) == '#' ? 1 : 0;
            }
        }

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (field[i][j] == 1 && !fieldCheck[i][j]) {
                    resultCount++;
                    draw(i, j, field);

                }

            }
        }
        System.out.println(resultCount);

    }

    private static void draw(int i, int j, int[][] field) {
        if (field[i][j] == 1 && !fieldCheck[i][j]) {

            fieldCheck[i][j] = true;
            // 상
            if (i - 1 > 0 && check(i - 1, j, field)) {
                draw(i - 1, j, field);
            }
            // 하
            if (i + 1 < field.length && check(i + 1, j, field)) {
                draw(i + 1, j, field);
            }
            // 좌
            if (j - 1 > 0 && check(i, j - 1, field)) {
                draw(i, j - 1, field);
            }
            // 우
            if (j + 1 < field[0].length && check(i, j + 1, field)) {
                draw(i, j + 1, field);
            }
        }

    }

    private static boolean check(int i, int j, int[][] field) {
        return field[i][j] == 1;
    }

}