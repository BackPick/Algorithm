
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int            n  = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String testWord = br.readLine();
            count = 0;
            int result = isPalindrome(testWord, count);
            bw.write(result + " " + count + "\n");
        }
        bw.close();
    }

    private static int isPalindrome(String testWord, int count) {
        return recursion(testWord, 0, testWord.length() - 1);
    }

    private static int recursion(String testWord, int j, int k) {
        count++;
        if (j >= k) {
            return 1;
        } else if (testWord.charAt(j) != testWord.charAt(k)) {
            return 0;
        } else {
            return recursion(testWord, j + 1, k - 1);
        }
    }
}
