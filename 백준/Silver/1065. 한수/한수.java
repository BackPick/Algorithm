import java.util.Scanner;

public class Main {

    // 한수인지 판별하는 메소드
    public static boolean isHansu(int number) {
        // 100 미만은 무조건 한수
        if (number < 100) return true;

        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;

        // 등차수열 조건 확인
        return (hundreds - tens) == (tens - units);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (isHansu(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
