import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int            n   = Integer.parseInt(br.readLine());
        Map<String, Integer> bookCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            bookCount.put(title, bookCount.getOrDefault(title, 0) + 1);
        }

        String bestSeller = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : bookCount.entrySet()) {
            String title = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                bestSeller = title;
            } else if (count == maxCount) {
                if (title.compareTo(bestSeller) < 0) {
                    bestSeller = title;
                }
            }
        }

        System.out.println(bestSeller);
    }
}
