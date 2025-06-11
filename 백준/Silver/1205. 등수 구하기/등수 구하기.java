import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int newScore = sc.nextInt();
        int P = sc.nextInt();

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(sc.nextInt());
        }

        int rank = 1;

        // 랭킹이 비어있을 경우
        if (N == 0) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > newScore) {
                rank++;
            } else {
                break;
            }
        }

        // 랭킹이 가득 찼고, 마지막 점수보다 새 점수가 작거나 같으면 못 올라감
        if (N == P && scores.get(P - 1) >= newScore) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
