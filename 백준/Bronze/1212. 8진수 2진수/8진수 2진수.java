import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        String octal = br.readLine();

        if (octal.equals("0")) {
            bw.write("0\n");
        } else {
            StringBuilder binary = new StringBuilder();
            for (int i = 0; i < octal.length(); i++) {
                int digit = octal.charAt(i) - '0';
                String bin = String.format("%03d", Integer.parseInt(Integer.toBinaryString(digit)));
                binary.append(bin);
            }

            int startIndex = 0;
            while (startIndex < binary.length() && binary.charAt(startIndex) == '0') {
                startIndex++;
            }

            bw.write(binary.substring(startIndex) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
