
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br          = new BufferedReader(new InputStreamReader(System.in));
        int             T           = Integer.parseInt(br.readLine());
        StringTokenizer st          = new StringTokenizer(br.readLine());
        int[]           soldTickets = new int[T];
        int             soldCount   = 1;

        for (int i = 0; i < T; i++) {
            int A = Integer.parseInt(st.nextToken());
            soldTickets[i] = A;
        }
        Arrays.sort(soldTickets);
        for (int ticket : soldTickets) {
            if (ticket == soldCount) {
                soldCount++;
            } else if (ticket > soldCount) {
                break;
            }
        }
        System.out.println(soldCount);

    }
}