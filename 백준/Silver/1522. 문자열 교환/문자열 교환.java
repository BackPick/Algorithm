import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                k++;
            }
        }
        
        if (k == 0 || k == n) {
            System.out.println(0);
            return;
        }
        
        String s2 = s + s;
        int len = s2.length();
        
        int[] prefix = new int[len];
        prefix[0] = (s2.charAt(0) == 'a') ? 1 : 0;
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + (s2.charAt(i) == 'a' ? 1 : 0);
        }
        
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int j = i + k - 1;
            int countA = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
            maxCount = Math.max(maxCount, countA);
        }
        
        int result = k - maxCount;
        System.out.println(result);
    }
}
