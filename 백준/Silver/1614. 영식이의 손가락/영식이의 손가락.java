import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int broken = sc.nextInt();
        long k = sc.nextLong();
        
        if (k == 0) {
            if (broken == 1) System.out.println(0);
            else if (broken == 5) System.out.println(4);
            else System.out.println(broken - 1);
            return;
        }
        
        long left = 0;
        long right = 8 * k + 100;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid, broken);
            
            if (count <= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(right);
    }
    
    static long getCount(long x, int broken) {
        long full = x / 8;
        int rem = (int)(x % 8);
        
        switch (broken) {
            case 1:
                return full + (rem >= 1 ? 1 : 0);
            case 2:
                return full * 2 + (rem >= 2 ? 1 : 0);
            case 3:
                long res3 = full * 2;
                if (rem >= 3) res3++;
                if (rem >= 7) res3++;
                return res3;
            case 4:
                long res4 = full * 2;
                if (rem >= 4) res4++;
                if (rem >= 6) res4++;
                return res4;
            case 5:
                return full + (rem >= 5 ? 1 : 0);
            default:
                return 0;
        }
    }
}