import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br        = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw        = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int             N         = Integer.parseInt(br.readLine());
        int[]           topArr    = new int[N];
        int[]           botArr    = new int[N];
        int             resultSum = 0;

        // A 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            topArr[i] = Integer.parseInt(st.nextToken());
        }

        // A는 오름차순으로 정렬
        topAscArr(topArr);
        // B 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            botArr[i] = Integer.parseInt(st.nextToken());
        }

        // B는 내림차순으로 정렬
        botDescArr(botArr);

        //연산
        for (int i = 0; i < N; i++) {
            int topVal = topArr[i];
            int botVal = botArr[i];
            resultSum += (topVal * botVal);
        }
        System.out.println(resultSum);


    }

    private static void topAscArr(int[] topArr) {
        for (int i = 0; i < topArr.length; i++) {
            int index = i;
            for (int j = index; j < topArr.length; j++) {
                if (topArr[index] > topArr[j]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = topArr[i];
                topArr[i]     = topArr[index];
                topArr[index] = temp;
            }

        }

    }

    private static void botDescArr(int[] botArr) {
        for (int i = 0; i < botArr.length; i++) {
            int index = i;
            for (int j = i; j < botArr.length; j++) {
                if (botArr[index] < botArr[j]) {
                    index = j;
                }

            }
            if (i != index) {
                int temp = botArr[i];
                botArr[i]     = botArr[index];
                botArr[index] = temp;
            }

        }


    }
}