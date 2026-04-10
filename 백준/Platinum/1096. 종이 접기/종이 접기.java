import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    static class State {
        int[] arr;
        int hash;

        State(int[] arr) {
            this.arr = arr;
            this.hash = Arrays.hashCode(arr);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(arr, state.arr);
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }

    static Set<Integer> getValidMasks(int L) {
        Set<Integer> validMasks = new HashSet<>();
        Set<State> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        int[] initial = new int[L];
        for (int i = 0; i < L; i++) {
            initial[i] = 1 << i;
        }

        queue.add(initial);
        visited.add(new State(initial));

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int mask : curr) {
                validMasks.add(mask);
            }

            if (curr.length == 1) continue;

            for (int i = 0; i < curr.length - 1; i++) {
                int newLen = Math.max(i + 1, curr.length - 1 - i);
                int[] nextState = new int[newLen];

                for (int k = 0; k < newLen; k++) {
                    int leftIdx = i - k;
                    int rightIdx = i + 1 + k;
                    int val = 0;
                    if (leftIdx >= 0) val |= curr[leftIdx];
                    if (rightIdx < curr.length) val |= curr[rightIdx];
                    nextState[k] = val;
                }

                int[] normalized = normalize(nextState);
                State stateObj = new State(normalized);

                if (!visited.contains(stateObj)) {
                    visited.add(stateObj);
                    queue.add(normalized);
                }
            }
        }
        return validMasks;
    }

    static int[] normalize(int[] arr) {
        boolean reverseIsSmaller = false;
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[arr.length - 1 - i] < arr[i]) {
                reverseIsSmaller = true;
                break;
            } else if (arr[arr.length - 1 - i] > arr[i]) {
                break;
            }
        }

        if (reverseIsSmaller) {
            int[] rev = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                rev[i] = arr[arr.length - 1 - i];
            }
            return rev;
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Set<Integer> validRowMasks = getValidMasks(N);
        Set<Integer> validColMasks = getValidMasks(M);

        int maxSum = Integer.MIN_VALUE;

        for (int r : validRowMasks) {
            int[] colSums = new int[M];
            for (int i = 0; i < N; i++) {
                if ((r & (1 << i)) != 0) {
                    for (int j = 0; j < M; j++) {
                        colSums[j] += A[i][j];
                    }
                }
            }

            for (int c : validColMasks) {
                int sum = 0;
                for (int j = 0; j < M; j++) {
                    if ((c & (1 << j)) != 0) {
                        sum += colSums[j];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }
}