import java.util.*;

// 클래스 이름: Main - 자바 프로그램의 진입점
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: 입력 받기
        // 집합 S의 크기 L을 입력받음
        int L = sc.nextInt();
        int[] S = new int[L];
        // 집합 S에 포함된 정수들을 입력받음
        for (int i = 0; i < L; i++) {
            S[i] = sc.nextInt();
        }
        // n 정수를 입력받음
        int n = sc.nextInt();

        // Step 2: n이 집합 S에 있는 경우 처리 (좋은 구간이 존재하지 않음)
        for (int i = 0; i < L; i++) {
            if (S[i] == n) {
                System.out.println(0);
                return;
            }
        }

        // Step 3: 집합 S를 오름차순으로 정렬하여 양쪽 경계를 찾기 쉽게 함
        Arrays.sort(S);

        // Step 4: n의 좌측 경계(leftBoundary)와 우측 경계(rightBoundary)를 찾기
        // n보다 작은 값 중 가장 큰 수, 없으면 0으로 설정
        int leftBoundary = 0;
        // n보다 큰 값 중 가장 작은 수, 문제 조건 상 항상 존재함
        int rightBoundary = Integer.MAX_VALUE;
        for (int i = 0; i < L; i++) {
            if (S[i] < n) {
                leftBoundary = S[i];
            } else if (S[i] > n) {
                rightBoundary = S[i];
                break;  // 첫번째로 만난 S[i]가 n보다 큰 최소 값
            }
        }

        // Step 5: 좋은 구간의 개수 계산
        // A는 (leftBoundary+1)부터 n까지 선택할 수 있음 => countA = n - leftBoundary
        int countA = n - leftBoundary;
        // B는 n부터 (rightBoundary-1)까지 선택할 수 있음 => countB = rightBoundary - n
        int countB = rightBoundary - n;
        // 단, A < B 조건 때문에 (A, B) 쌍 중 A==B인 경우 1개는 제외해야 함
        int result = countA * countB - 1;

        // Step 6: 결과 출력
        System.out.println(result);
    }
}
