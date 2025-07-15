import java.util.Scanner;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int num) {
        if (num > N) return;
        if (num != 0 && isLucky(num)) {
            max = Math.max(max, num);
        }
        dfs(num * 10 + 4);
        dfs(num * 10 + 7);
    }

    static boolean isLucky(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit != 4 && digit != 7) return false;
            num /= 10;
        }
        return true;
    }
}
