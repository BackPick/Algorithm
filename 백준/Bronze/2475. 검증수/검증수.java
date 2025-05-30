import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine()
                .split(" ");

        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num) * Integer.parseInt(num);
        }

        System.out.println(sum % 10);
    }
}