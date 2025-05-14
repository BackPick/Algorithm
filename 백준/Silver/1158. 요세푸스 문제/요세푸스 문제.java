import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> people = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            people.offer(i);
        }

        Queue<Integer> result = new LinkedList<>();
        int            count  = 1;
        while (!people.isEmpty()) {
            if (count == k) {
                result.offer(people.poll());
                count = 1;
            } else {
                people.offer(people.poll());
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.poll());
            if (!result.isEmpty()) {
                sb.append(", ");
            }
        }
        System.out.print("<" + sb.toString() + ">");

    }
}