import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        
        long[] P = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            P[i] = Long.parseLong(st.nextToken());
        }
        
        long[] V = new long[N];
        st = new StringTokenizer(br.readLine().trim());
        long totalV = 0;
        for (int i = 0; i < N; i++) {
            V[i] = Long.parseLong(st.nextToken());
            totalV += V[i];
        }
        
        long K = Long.parseLong(br.readLine().trim());
        
        int M = Integer.parseInt(br.readLine().trim());
        long currentP = 0;
        if (M > 0) {
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < M; i++) {
                int idx = Integer.parseInt(st.nextToken());
                currentP += P[idx];
            }
        }
        
        if (totalV < K) {
            System.out.println("-1");
            return;
        }
        
        int nL = N / 2;
        int nR = N - nL;
        
        int sizeR = 1 << nR;
        long[] right = new long[sizeR];
        
        for (int i = 0; i < sizeR; i++) {
            long sumV = 0;
            long sumP = 0;
            for (int j = 0; j < nR; j++) {
                if ((i & (1 << j)) != 0) {
                    sumV += V[nL + j];
                    sumP += P[nL + j];
                }
            }
            right[i] = (sumV << 32) | sumP;
        }
        
        Arrays.sort(right);
        
        long[] minP = new long[sizeR];
        minP[sizeR - 1] = right[sizeR - 1] & 0xFFFFFFFFL;
        for (int i = sizeR - 2; i >= 0; i--) {
            minP[i] = Math.min(right[i] & 0xFFFFFFFFL, minP[i + 1]);
        }
        
        int sizeL = 1 << nL;
        long ans = Long.MAX_VALUE;
        
        for (int i = 0; i < sizeL; i++) {
            long sumV = 0;
            long sumP = 0;
            for (int j = 0; j < nL; j++) {
                if ((i & (1 << j)) != 0) {
                    sumV += V[j];
                    sumP += P[j];
                }
            }
            
            long targetV = K - sumV;
            
            if (targetV <= 0) {
                ans = Math.min(ans, sumP);
            } else {
                int low = 0;
                int high = sizeR - 1;
                int idx = sizeR;
                
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    long midV = right[mid] >>> 32;
                    
                    if (midV >= targetV) {
                        idx = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                
                if (idx < sizeR) {
                    ans = Math.min(ans, sumP + minP[idx]);
                }
            }
        }
        
        long result = ans - currentP;
        if (result < 0) {
            result = 0;
        }
        
        System.out.println(result);
    }
}