import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner                sc      = new Scanner(System.in);
        int                    n       = sc.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int                    cnt     = n * n;
        for (int i = 0; i < cnt; i++) {
            int num = sc.nextInt();
            if (minHeap.size() < n) {
                minHeap.offer(num);
            } else if (minHeap.peek() < num) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        sc.close();
        System.out.println(minHeap.peek());
    }
}