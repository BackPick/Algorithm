import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
        // 세 참가자 중 성씨를 영문으로 표기했을 때의 첫 글자를 백준 온라인 저지에서 해결한 문제가 많은 사람부터 차례대로 나열한 문자열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[]                   birthArr     = new int[3];
        int[]                   bojArr       = new int[3];
        Map<Integer, Character> firstNameMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int boj = Integer.parseInt(st.nextToken()) / 100;
            int birth = Integer.parseInt(st.nextToken()
                    .substring(2, 4));
            char firstName = st.nextToken()
                    .charAt(0);

            birthArr[i] = birth;
            bojArr[i]   = boj;
            firstNameMap.putIfAbsent(boj, firstName);
        }
        // 생일 Logic
        birthSort(birthArr);
        // 백준 점수 Logic
        bojSort(bojArr, 0, bojArr.length - 1);

        for (int i = 0; i < birthArr.length; i++) {
            System.out.print(birthArr[i]);
        }
        System.out.println();
        for (int i : bojArr) {
            System.out.print(firstNameMap.get(i));
        }
    }

    private static void birthSort(int[] birthArr) {
        Arrays.sort(birthArr);
    }

    // 퀵 정렬 메서드
    private static void bojSort(int[] arr, int start, int finish) {
        // 종료 조건: 시작 인덱스가 끝 인덱스보다 크거나 같으면 종료
        if (start >= finish) {
            return;
        }

        // 배열을 파티션하고 피벗의 최종 위치 인덱스를 반환
        int pivotIndex = partition(arr, start, finish);

        // 피벗을 기준으로 왼쪽과 오른쪽 서브 배열 정렬
        bojSort(arr, start, pivotIndex - 1);
        bojSort(arr, pivotIndex + 1, finish);
    }

    // 배열을 파티셔닝하고 피벗의 위치를 정하는 메서드
    private static int partition(int[] arr, int start, int finish) {
        int pivot = arr[start]; // 피벗 값 저장
        int left  = start + 1; // 왼쪽 포인터 초기화
        int right = finish;     // 오른쪽 포인터 초기화

        // 왼쪽 포인터가 오른쪽 포인터를 넘지 않을 때까지 반복
        while (left <= right) {
            // 왼쪽 포인터 이동: 피벗보다 큰 값을 찾음
            while (left <= finish && arr[left] >= pivot) {
                left++;
            }
            // 오른쪽 포인터 이동: 피벗보다 작은 값을 찾음
            while (right > start && arr[right] <= pivot) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left]  = arr[right];
                arr[right] = temp;
            }
        }
        // 피벗을 오른쪽 포인터의 위치로 이동
        arr[start] = arr[right];
        arr[right] = pivot;

        // 피벗의 최종 위치 반환
        return right;
    }


}