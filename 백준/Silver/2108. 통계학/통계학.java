
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int            n  = Integer.parseInt(br.readLine());

        int   minNum  = Integer.MAX_VALUE;
        int   maxNum  = Integer.MIN_VALUE;
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < minNum) minNum = num;
            if (num > maxNum) maxNum = num;
            numbers[i] = num;
        }

        // 산술 평균
        double average = Arrays.stream(numbers)
                .average()
                .orElse(0);
        int averageResult = (int) Math.round(average);
        System.out.println(averageResult);

        // 중앙값
        Arrays.sort(numbers);
        int midResult = numbers[n / 2]; // N은 홀수
        System.out.println(midResult);

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 최빈값 찾기
        List<Map.Entry<Integer, Integer>> sortedFrequencies = new ArrayList<>(map.entrySet());
        sortedFrequencies.sort((a, b) -> {
            if (b.getValue()
                    .equals(a.getValue())) {
                return Integer.compare(a.getKey(), b.getKey());
            }
            return Integer.compare(b.getValue(), a.getValue());
        });

        // 두 번째로 작은 최빈값
        int mode;
        if (sortedFrequencies.size() == 1) {
            mode = sortedFrequencies.get(0)
                    .getKey();
        } else {
            int maxFrequency = sortedFrequencies.get(0)
                    .getValue();
            List<Integer> modes = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : sortedFrequencies) {
                if (entry.getValue() == maxFrequency) {
                    modes.add(entry.getKey());
                }
            }
            Collections.sort(modes);
            mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        }
        System.out.println(mode);

        // 범위
        int range = maxNum - minNum;
        System.out.println(range);
    }
}
