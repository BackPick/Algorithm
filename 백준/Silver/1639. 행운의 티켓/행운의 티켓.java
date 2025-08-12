public class Main {
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String S = br.readLine().trim();
        int n = S.length();

        if (n < 2) {
            System.out.println(0);
            return;
        }

        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            int digit = S.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i] + digit;
        }

        int maxEvenLength = (n % 2 == 0) ? n : n - 1;
        for (int L = maxEvenLength; L >= 2; L -= 2) {
            for (int i = 0; i <= n - L; i++) {
                int mid = i + L / 2;
                int leftSum = prefixSum[mid] - prefixSum[i];
                int rightSum = prefixSum[i + L] - prefixSum[mid];
                if (leftSum == rightSum) {
                    System.out.println(L);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
