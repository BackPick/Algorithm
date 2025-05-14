import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        // 아케인스톤 3 , 활성화 한 아케인스톤 2개
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int quest      = Integer.parseInt(st.nextToken());
        int totalStone = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < quest; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int        activeStone = 0;
        BigInteger totalExp    = BigInteger.ZERO; // BigInteger로 초기화

        for (int i = 0; i < quest; i++) {
            if (activeStone < totalStone) {
                activeStone++;
                totalExp = totalExp.subtract(BigInteger.valueOf(pq.peek())); // 총 경험치에서 현재 최솟값을 빼줌
            }
            totalExp = totalExp.add(BigInteger.valueOf(pq.poll())
                    .multiply(BigInteger.valueOf(activeStone))); // 경험치 누적
        }
        bw.write(totalExp + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}