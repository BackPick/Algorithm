import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        int candidate = 1;
        while (true) {
            int count = 0;
            for (int num : nums) {
                if (candidate % num == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(candidate);
                break;
            }
            candidate++;
        }
    }
}
