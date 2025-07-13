import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        String[] parts = time.split(":");

        int count = 0;

        // 3개의 숫자 조합을 순열로 만든다
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && j != k && k != i) {
                        int hour = Integer.parseInt(parts[i]);
                        int minute = Integer.parseInt(parts[j]);
                        int second = Integer.parseInt(parts[k]);

                        if (isValid(hour, minute, second)) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static boolean isValid(int hour, int minute, int second) {
        return (1 <= hour && hour <= 12) &&
               (0 <= minute && minute <= 59) &&
               (0 <= second && second <= 59);
    }
}
