
import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int             A, B;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            A  = Integer.parseInt(st.nextToken());
            B  = Integer.parseInt(st.nextToken());

            // A와 B의 공통 조상 계산
            // 공통 조상 ? 이진 트리에서 두 노드의 가장 가까운 공통 분모 노드
            while (A != B) {
                if (B > A) {
                    B = B / 2;
                } else {
                    A = A / 2;
                }
            }
            bw.write((A * 10) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    // 시간 복잡도 -> O(T*log(M)) M= 두 숫자 중 큰 수
    // 공간 복잡도 -> O(1) 고정된 변수 사용
}