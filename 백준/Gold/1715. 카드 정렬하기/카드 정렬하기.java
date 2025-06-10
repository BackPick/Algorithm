
import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cardSort = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(br.readLine());
            cardSort.offer(card);
        }

        int sum = 0;
        while (cardSort.size() > 1) {
            int card1   = cardSort.poll();
            int card2   = cardSort.poll();
            int cardSum = card1 + card2;
            sum += cardSum;
            cardSort.offer(cardSum);
        }
        bw.write(String.valueOf(sum));
        bw.flush();


    }
}