import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count0 = 0;
        int count1 = 0;

        char prev = s.charAt(0);
        if (prev == '0') count0++;
        else count1++;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                if (s.charAt(i) == '0') count0++;
                else count1++;
                prev = s.charAt(i);
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
