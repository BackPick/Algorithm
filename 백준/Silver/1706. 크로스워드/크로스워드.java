import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != '#' && (j == 0 || grid[i][j - 1] == '#')) {
                    StringBuilder sb = new StringBuilder();
                    int k = j;
                    while (k < C && grid[i][k] != '#') {
                        sb.append(grid[i][k]);
                        k++;
                    }
                    String word = sb.toString();
                    if (word.length() >= 2) {
                        words.add(word);
                    }
                }
            }
        }

        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (grid[i][j] != '#' && (i == 0 || grid[i - 1][j] == '#')) {
                    StringBuilder sb = new StringBuilder();
                    int k = i;
                    while (k < R && grid[k][j] != '#') {
                        sb.append(grid[k][j]);
                        k++;
                    }
                    String word = sb.toString();
                    if (word.length() >= 2) {
                        words.add(word);
                    }
                }
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
