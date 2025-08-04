import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double max = 0;
        double sum = 0;
        double[] scores = new double[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextDouble();
            if (scores[i] > max) max = scores[i];
        }

        for (int i = 0; i < N; i++) {
            sum += scores[i] / max * 100;
        }

        System.out.println(sum / N);
    }
}
