import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int pulse = m;
        int time = 0;
        int exercise = 0;

        while (exercise < N) {
            if (pulse + T <= M) {
                pulse += T;
                exercise++;
            } else {
                pulse -= R;
                if (pulse < m) pulse = m;
            }
            time++;
        }

        System.out.println(time);
    }
}
