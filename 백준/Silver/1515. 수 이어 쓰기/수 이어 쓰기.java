import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int index = 0;
        int n = 1;

        while (true) {
            String s = Integer.toString(n);
            for (int i = 0; i < s.length() && index < target.length(); i++) {
                if (s.charAt(i) == target.charAt(index)) {
                    index++;
                }
            }
            if (index == target.length()) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }
}
