import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 큐의 크기
        int M = sc.nextInt(); // 뽑을 숫자의 개수

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();

            int index = deque.indexOf(target); // 현재 타겟의 위치
            int mid = deque.size() / 2;

            if (index <= mid) {
                // 왼쪽으로 이동
                while (deque.getFirst() != target) {
                    deque.addLast(deque.removeFirst());
                    count++;
                }
            } else {
                // 오른쪽으로 이동
                while (deque.getFirst() != target) {
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }

            // 맨 앞의 원소 제거
            deque.removeFirst();
        }

        System.out.println(count);
    }
}
