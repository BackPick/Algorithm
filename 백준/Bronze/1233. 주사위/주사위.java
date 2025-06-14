import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 주사위의 면 개수 입력
        int S1 = sc.nextInt();
        int S2 = sc.nextInt();
        int S3 = sc.nextInt();
        
        // 주사위 합의 빈도를 기록할 맵
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 세 주사위의 모든 합을 구해 빈도 계산
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int sum = i + j + k;
                    frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
                }
            }
        }
        
        // 가장 높은 빈도와 그에 해당하는 합 구하기
        int maxFrequency = 0;
        int result = Integer.MAX_VALUE;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int sum = entry.getKey();
            int frequency = entry.getValue();
            
            if (frequency > maxFrequency || (frequency == maxFrequency && sum < result)) {
                maxFrequency = frequency;
                result = sum;
            }
        }
        
        // 결과 출력
        System.out.println(result);
    }
}
