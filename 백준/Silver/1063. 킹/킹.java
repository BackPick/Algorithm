import java.util.*;
import java.io.*;

public class Main {
    static int kingX, kingY, stoneX, stoneY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingPos = st.nextToken();
        String stonePos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        kingX = kingPos.charAt(1) - '1';
        kingY = kingPos.charAt(0) - 'A';
        stoneX = stonePos.charAt(1) - '1';
        stoneY = stonePos.charAt(0) - 'A';

        // 방향 매핑
        Map<String, int[]> moves = new HashMap<>();
        moves.put("R",  new int[]{0, 1});
        moves.put("L",  new int[]{0, -1});
        moves.put("B",  new int[]{-1, 0});
        moves.put("T",  new int[]{1, 0});
        moves.put("RT", new int[]{1, 1});
        moves.put("LT", new int[]{1, -1});
        moves.put("RB", new int[]{-1, 1});
        moves.put("LB", new int[]{-1, -1});

        // 2. 명령 처리
        for (int i = 0; i < N; i++) {
            String dir = br.readLine();
            int[] move = moves.get(dir);

            int nextKingX = kingX + move[0];
            int nextKingY = kingY + move[1];

            // 킹이 보드 안에 있는지 확인
            if (isInBoard(nextKingX, nextKingY)) {
                // 돌과 같은 위치라면 돌도 이동
                if (nextKingX == stoneX && nextKingY == stoneY) {
                    int nextStoneX = stoneX + move[0];
                    int nextStoneY = stoneY + move[1];

                    if (isInBoard(nextStoneX, nextStoneY)) {
                        stoneX = nextStoneX;
                        stoneY = nextStoneY;
                        kingX = nextKingX;
                        kingY = nextKingY;
                    }
                    // 돌이 못 가면 이동 무시
                } else {
                    kingX = nextKingX;
                    kingY = nextKingY;
                }
            }
        }

        // 3. 결과 출력
        System.out.println(posToString(kingX, kingY));
        System.out.println(posToString(stoneX, stoneY));
    }

    // 위치가 체스판 안인지 확인
    public static boolean isInBoard(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    // (x,y)를 "A1" 형식으로 변환
    public static String posToString(int x, int y) {
        char col = (char) (y + 'A');
        char row = (char) (x + '1');
        return "" + col + row;
    }
}
