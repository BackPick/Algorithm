import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 선수 수
        sc.nextLine(); // 줄바꿈 처리

        int[] alphabetCount = new int[26]; // 알파벳 a~z 카운트 배열

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            char firstChar = name.charAt(0);
            alphabetCount[firstChar - 'a']++; // 첫 글자 세기
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] >= 5) {
                result.append((char) (i + 'a'));
            }
        }

        if (result.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(result.toString());
        }
    }
}
