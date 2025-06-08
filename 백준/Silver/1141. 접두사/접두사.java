import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리
        
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            wordSet.add(sc.nextLine());
        }
        
        List<String> words = new ArrayList<>(wordSet);
        Collections.sort(words, (a, b) -> b.length() - a.length());
        
        List<String> selected = new ArrayList<>();
        for (String word : words) {
            boolean isPrefix = false;
            for (String s : selected) {
                if (s.startsWith(word)) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                selected.add(word);
            }
        }
        
        System.out.println(selected.size());
    }
}