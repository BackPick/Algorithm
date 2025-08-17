import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("#")) break;
            String[] parts = line.split(" ");
            String target = parts[0], guess = parts[1];
            int n = target.length();
            boolean[] targetMatched = new boolean[n], guessMatched = new boolean[n];
            int black = 0, grey = 0, white = 0;

            for (int i = 0; i < n; i++) 
                if (target.charAt(i) == guess.charAt(i)) {
                    black++;
                    targetMatched[i] = guessMatched[i] = true;
                }

            for (int i = 0; i < n; i++) if (!guessMatched[i]) {
                if (i - 1 >= 0 && !targetMatched[i - 1] && guess.charAt(i) == target.charAt(i - 1)) {
                    grey++; guessMatched[i] = targetMatched[i - 1] = true;
                } else if (i + 1 < n && !targetMatched[i + 1] && guess.charAt(i) == target.charAt(i + 1)) {
                    grey++; guessMatched[i] = targetMatched[i + 1] = true;
                }
            }

            for (int i = 0; i < n; i++) if (!guessMatched[i]) 
                for (int j = 0; j < n; j++) 
                    if (!targetMatched[j] && guess.charAt(i) == target.charAt(j) && Math.abs(i - j) >= 2) {
                        white++; guessMatched[i] = targetMatched[j] = true; break;
                    }

            System.out.println(guess + ": " + black + " black, " + grey + " grey, " + white + " white");
        }
    }
}
