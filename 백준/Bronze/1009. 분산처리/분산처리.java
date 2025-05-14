import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 각 숫자(0~9)에 대한 주기 리스트 초기화
        List<List<Integer>> cycles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cycles.add(new ArrayList<>());
        }
        cycles.get(0).add(0);
        cycles.get(1).add(1);
        cycles.get(2).addAll(Arrays.asList(2, 4, 8, 6));
        cycles.get(3).addAll(Arrays.asList(3, 9, 7, 1));
        cycles.get(4).addAll(Arrays.asList(4, 6));
        cycles.get(5).add(5);
        cycles.get(6).add(6);
        cycles.get(7).addAll(Arrays.asList(7, 9, 3, 1));
        cycles.get(8).addAll(Arrays.asList(8, 4, 2, 6));
        cycles.get(9).addAll(Arrays.asList(9, 1));
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int digit = a % 10;
            if (digit == 0) {
                sb.append("10\n");
                continue;
            }
            
            List<Integer> cycle = cycles.get(digit);
            int len = cycle.size();
            int exponent = b % len;
            if (exponent == 0) {
                exponent = len;
            }
            int index = exponent - 1;
            int result = cycle.get(index);
            sb.append(result == 0 ? 10 : result).append("\n");
        }
        System.out.print(sb);
    }
}