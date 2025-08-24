import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        Pattern p = Pattern.compile("^(100+1+|01)+$");
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String s = br.readLine().trim();
            if (p.matcher(s).matches()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}
