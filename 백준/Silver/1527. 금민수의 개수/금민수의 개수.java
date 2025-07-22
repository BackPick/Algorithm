import java.util.*;

public class Main {
    static List<Long> goldNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        generateGoldNumbers(0, 0);
        int count = 0;
        for (long num : goldNumbers) {
            if (num >= A && num <= B) {
                count++;
            }
        }
        System.out.println(count);
    }

    static void generateGoldNumbers(long current, int depth) {
        if (current > 0) {
            goldNumbers.add(current);
        }
        if (depth == 10) {
            return;
        }
        generateGoldNumbers(current * 10 + 4, depth + 1);
        generateGoldNumbers(current * 10 + 7, depth + 1);
    }
}
