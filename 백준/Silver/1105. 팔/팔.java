import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String L = sc.next();
        String R = sc.next();
        sc.close();

        int count = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) == R.charAt(i)) {
                    if (L.charAt(i) == '8') count++;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
