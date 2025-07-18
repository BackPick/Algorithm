import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 수열의 길이를 입력 받음
        int N = sc.nextInt();
        int[] arr = new int[N];

        // 수열 원소들을 입력 받음
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 등차수열일 경우: 두 번째 수 - 첫 번째 수 = 등차(d)
        int diff = arr[1] - arr[0];

        // 등비수열일 경우: 두 번째 수 / 첫 번째 수 = 등비(r)
        // 등비는 정수 조건이므로, 나눠떨어지는지 확인 필요
        boolean isArithmetic = (arr[2] - arr[1] == diff);
        boolean isGeometric = false;

        // 등비 계산은 0 나눔 방지 및 나눠떨어지는 경우에만
        if (arr[0] != 0 && arr[1] % arr[0] == 0 && arr[2] % arr[1] == 0) {
            int ratio = arr[1] / arr[0];
            if (arr[2] / arr[1] == ratio) {
                isGeometric = true;
            }
        }

        // 마지막 수열 값을 가져옴
        int last = arr[N - 1];

        // 다음 수를 구함
        if (isArithmetic) {
            System.out.println(last + diff);
        } else if (isGeometric) {
            int ratio = arr[1] / arr[0];
            System.out.println(last * ratio);
        } else {
            // 문제 조건상 항상 등차나 등비 중 하나이므로 이 경우는 안 나옴
            System.out.println("Invalid sequence");
        }

        sc.close();
    }
}
