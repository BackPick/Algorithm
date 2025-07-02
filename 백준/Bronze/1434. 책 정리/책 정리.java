import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] boxes = new int[N];
        int[] books = new int[M];
        
        for (int i = 0; i < N; i++) {
            boxes[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            books[i] = sc.nextInt();
        }
        
        int[] used = new int[N]; // 각 박스에 들어간 책 크기의 합
        int boxIndex = 0;
        int bookIndex = 0;
        
        while (bookIndex < M) {
            if (boxIndex < N && used[boxIndex] + books[bookIndex] <= boxes[boxIndex]) {
                used[boxIndex] += books[bookIndex];
                bookIndex++;
            } else {
                boxIndex++;
            }
        }
        
        int totalWaste = 0;
        for (int i = 0; i < N; i++) {
            totalWaste += boxes[i] - used[i];
        }
        
        System.out.println(totalWaste);
    }
}