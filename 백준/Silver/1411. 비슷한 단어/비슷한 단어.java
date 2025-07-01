import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if (isSimilar(words[i], words[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static boolean isSimilar(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Character> mapAB = new HashMap<>();
        Map<Character, Character> mapBA = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);

            if (mapAB.containsKey(ca)) {
                if (mapAB.get(ca) != cb) return false;
            } else {
                mapAB.put(ca, cb);
            }

            if (mapBA.containsKey(cb)) {
                if (mapBA.get(cb) != ca) return false;
            } else {
                mapBA.put(cb, ca);
            }
        }

        return true;
    }
}
