import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("black", 0);
        valueMap.put("brown", 1);
        valueMap.put("red", 2);
        valueMap.put("orange", 3);
        valueMap.put("yellow", 4);
        valueMap.put("green", 5);
        valueMap.put("blue", 6);
        valueMap.put("violet", 7);
        valueMap.put("grey", 8);
        valueMap.put("white", 9);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String color1 = br.readLine().trim();
        String color2 = br.readLine().trim();
        String color3 = br.readLine().trim();

        int firstDigit = valueMap.get(color1);
        int secondDigit = valueMap.get(color2);
        int multiplier = (int)Math.pow(10, valueMap.get(color3));

        long resistanceValue = (firstDigit * 10L + secondDigit) * multiplier;
        System.out.println(resistanceValue);
    }
}
