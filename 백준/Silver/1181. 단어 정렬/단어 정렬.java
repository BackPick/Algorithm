import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int         N       = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }
        List<Word> wordList = new ArrayList<>();
        for (String s : wordSet) {
            wordList.add(new Word(s, s.length(), s.charAt(0)));
        }
        Collections.sort(wordList, (o1, o2) -> {
            if (o1.getLength() != o2.getLength()) {
                return Integer.compare(o1.getLength(), o2.getLength());
            }
            return o1.getWord()
                    .compareTo(o2.getWord());
        });

        for (Word word : wordList) {
            bw.write(word.getWord() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Word {
        private String    word;
        private int       length;
        private Character firstWord;

        public Word(String word, int length, Character firstWord) {
            this.word      = word;
            this.length    = length;
            this.firstWord = firstWord;
        }

        public String getWord() {
            return word;
        }

        public int getLength() {
            return length;
        }

        public Character getFirstWord() {
            return firstWord;
        }


    }
}
