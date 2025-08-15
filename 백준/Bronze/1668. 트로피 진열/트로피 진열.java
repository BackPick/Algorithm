import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int leftCount = 0, rightCount = 0, maxLeft = 0, maxRight = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int i = 0; i < n; i++) if (arr[i] > maxLeft) { leftCount++; maxLeft = arr[i]; }
        for (int i = n - 1; i >= 0; i--) if (arr[i] > maxRight) { rightCount++; maxRight = arr[i]; }
        System.out.println(leftCount);
        System.out.println(rightCount);
    }
}
