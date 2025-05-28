

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int             n         = Integer.parseInt(firstLine.nextToken());
        int             m         = Integer.parseInt(firstLine.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer nLine = new StringTokenizer(br.readLine());
            nLine.nextToken();
            String songName  = nLine.nextToken();
            String pitchName = String.join("", nLine.nextToken(), nLine.nextToken(), nLine.nextToken());

            if (map.containsKey(pitchName)) {
                map.put(pitchName, "?");
            } else {
                map.put(pitchName, songName);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer mLine      = new StringTokenizer(br.readLine());
            String          resultName = String.join("", mLine.nextToken(), mLine.nextToken(), mLine.nextToken());

            if (!map.containsKey(resultName)) {
                sb.append("!\n");
            } else {
                sb.append(map.get(resultName))
                        .append("\n");
            }


        }
        bw.write(sb.toString());
        bw.flush();
    }
}
