
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 2일차 - 4 (실버4)
    // https://www.acmicpc.net/problem/10845
    // 알고리즘 분류 -> 자료구조 & 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int            n  = Integer.parseInt(br.readLine());
        // Queue를 위한 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();

        StringBuilder output = new StringBuilder(); // 결과 출력을 위한 StringBuilder

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Order  order;

            // push 명령인 경우 추가적인 값을 명확하게 표현
            // push ab -> NumberFormatException 발생
            // push -> ArrayIndexOutOfBoundsException / NullPointterException 발생
            if (input.startsWith("push")) order = Order.PUSH;
            else order = Order.callOrder(input);

            switch (order) {
                // 정수 X를 큐에 넣는 연산이다.
                case PUSH:
                    // String[] parts = input.split(" ");
                    // int x = Integer.parseInt(parts[1]);

                    StringTokenizer tokenizer = new StringTokenizer(input);
                    tokenizer.nextToken(); // -> push
                    int x = Integer.parseInt(tokenizer.nextToken()); // -> 정수 X

                    queue.offer(x);
                    break;
                // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.만약 큐에 들어있는 정수가 없는 경우에는 -1 을 출력한다
                case POP:
                    if (queue.isEmpty()) output.append(-1).append('\n');
                    else output.append(queue.poll()).append('\n');
                    break;
                // 큐에 들어있는 정수의 개수를 출력한다.
                case SIZE:
                    output.append(queue.size()).append('\n');
                    break;
                // 큐가 비어있으면 1, 아니면 0을 출력한다.
                case EMPTY:
                    // 큐가 비어있으면 1, 아니면 0
                    output.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;
                // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case FRONT:
                    if (queue.isEmpty()) output.append(-1).append('\n');
                        // 큐의 가장 앞 정수 출력
                    else output.append(queue.peek()).append('\n');
                    break;
                // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case BACK:
                    if (queue.isEmpty()) output.append(-1).append('\n');
                    else {
                        // 큐의 가장 뒤 정수를 출력하기 위해서 큐를 ArrayList로 변환
                        Integer backNumber = null;
                        // 다르게 처리 가능? 생각 중
                        for (Integer element : queue) {
                            backNumber = element;
                        }
                        output.append(backNumber).append('\n'); // 큐의 가장 뒤 정수 출력
                    }
                    break;
            }
        }
        // 결과 출력
        System.out.print(output.toString());
    }
}

enum Order {
    PUSH, POP, SIZE, EMPTY, FRONT, BACK;

    public static Order callOrder(String ord) {
        switch (ord) {
            case "push":
                return PUSH;
            case "pop":
                return POP;
            case "size":
                return SIZE;
            case "empty":
                return EMPTY;
            case "front":
                return FRONT;
            case "back":
                return BACK;
            default:
                throw new IllegalArgumentException(ord + "은 수행할 수 없는 명령입니다: ");
        }
    }

}
