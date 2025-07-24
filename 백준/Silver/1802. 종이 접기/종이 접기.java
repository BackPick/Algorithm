import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String line = sc.nextLine();
            if (isValid(line.toCharArray(), 0, line.length() - 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isValid(char[] arr, int start, int end) {
        if (start >= end) return true;
        int mid = (start + end) / 2;
        for (int i = 1; i <= (end - start) / 2; i++) {
            if (arr[mid - i] == arr[mid + i]) return false;
        }
        return isValid(arr, start, mid - 1) && isValid(arr, mid + 1, end);
    }
}
