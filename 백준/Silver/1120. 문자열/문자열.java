import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int minDiff = Integer.MAX_VALUE;

        // B에서 A의 길이만큼 슬라이딩하면서 비교
        for (int i = 0; i <= B.length() - A.length(); i++) {
            int diff = 0;

            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(i + j)) {
                    diff++;
                }
            }

            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
    }
}
