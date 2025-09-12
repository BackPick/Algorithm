import java.io.*;
import java.util.*;

public class Main {
    // 각 숫자가 사용하는 7세그먼트 선분의 개수
    static int[] seg = {6,2,5,5,4,5,6,3,7,5};

    static int N;                 // 입력 숫자의 길이
    static int[] lowerDigits;     // DP에서 사용할 하한값(자릿수 배열)
    static final String NO = "~NO~"; 
    static HashMap<String, String> memo;

    // DP 함수
    // pos   : 현재 자릿수 위치
    // tight : 하한값과 일치하는 상태인지 여부
    // rem   : 남은 선분 수
    static String dp(int pos, int tight, int rem) {
        if (pos == N) return (rem == 0 ? "" : NO);

        String key = pos + "," + tight + "," + rem;
        if (memo.containsKey(key)) return memo.get(key);

        int start = (tight == 1 ? lowerDigits[pos] : 0);
        for (int d = start; d <= 9; d++) {
            int cost = seg[d];
            if (cost > rem) continue;

            int newTight = (tight == 1 && d == lowerDigits[pos]) ? 1 : 0;
            String suffix = dp(pos + 1, newTight, rem - cost);
            if (!suffix.equals(NO)) {
                String res = d + suffix;
                memo.put(key, res);
                return res;
            }
        }
        memo.put(key, NO);
        return NO;
    }

    // 문자열 → 자릿수 배열
    static int[] toDigits(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }

    // long → N자리 문자열 (앞에 0 채움)
    static String formatWithLeadingZeros(long value, int length) {
        String s = Long.toString(value);
        while (s.length() < length) s = "0" + s;
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currStr = br.readLine().trim();
        N = currStr.length();

        long curr = Long.parseLong(currStr);

        // 현재 숫자의 총 선분 개수
        int T = 0;
        for (int i = 0; i < N; i++) {
            T += seg[currStr.charAt(i) - '0'];
        }

        // 카운터가 순환하는 범위: 10^N
        long m = 1;
        for (int i = 0; i < N; i++) m *= 10;

        long nextCandidateVal = -1;

        // 현재 값 다음부터 탐색
        if (curr + 1 < m) {
            String lowBound = formatWithLeadingZeros(curr + 1, N);
            lowerDigits = toDigits(lowBound);
            memo = new HashMap<>();
            String candidateStr = dp(0, 1, T);
            if (!candidateStr.equals(NO)) {
                nextCandidateVal = Long.parseLong(candidateStr);
            }
        }

        long seconds;
        if (nextCandidateVal != -1) {
            // wrap-around 없이 찾은 경우
            seconds = nextCandidateVal - curr;
        } else {
            // wrap-around 발생: 0부터 다시 탐색
            String lowBound = "0".repeat(N);
            lowerDigits = toDigits(lowBound);
            memo = new HashMap<>();
            String candidateStr = dp(0, 1, T);
            long candidateVal = Long.parseLong(candidateStr);
            seconds = (m - curr) + candidateVal;
        }

        System.out.println(seconds);
    }
}
