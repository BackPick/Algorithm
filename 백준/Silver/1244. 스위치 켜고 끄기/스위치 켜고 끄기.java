import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] switches = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }

        int studentCount = sc.nextInt();
        for (int i = 0; i < studentCount; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();

            if (gender == 1) {
                for (int j = num; j <= n; j += num) {
                    switches[j] ^= 1;
                }
            } else {
                switches[num] ^= 1;
                int left = num - 1;
                int right = num + 1;
                while (left >= 1 && right <= n && switches[left] == switches[right]) {
                    switches[left] ^= 1;
                    switches[right] ^= 1;
                    left--;
                    right++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
