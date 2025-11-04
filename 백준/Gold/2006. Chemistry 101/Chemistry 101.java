import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int equationCounter = 1;

        while (!(line = br.readLine()).equals("#")) {
            processEquation(line, equationCounter, bw);
            equationCounter++;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void processEquation(String line, int eqnNum, BufferedWriter bw) throws IOException {
        String[] sides = line.split("=");
        Map<String, Integer> leftMap = parseSide(sides[0]);
        Map<String, Integer> rightMap = parseSide(sides[1]);

        Set<String> allElements = new TreeSet<>(leftMap.keySet());
        allElements.addAll(rightMap.keySet());

        List<String> discrepancies = new ArrayList<>();

        for (String element : allElements) {
            int leftCount = leftMap.getOrDefault(element, 0);
            int rightCount = rightMap.getOrDefault(element, 0);
            int diff = rightCount - leftCount;

            if (diff > 0) {
                discrepancies.add(formatMessage("created", diff, element));
            } else if (diff < 0) {
                discrepancies.add(formatMessage("destroyed", -diff, element));
            }
        }

        if (discrepancies.isEmpty()) {
            bw.write("Equation " + eqnNum + " is balanced.\n");
        } else {
            bw.write("Equation " + eqnNum + " is unbalanced.\n");
            for (String msg : discrepancies) {
                bw.write(msg + "\n");
            }
            bw.write("\n");
        }
    }

    private static String formatMessage(String action, int m, String element) {
        String atomStr = (m == 1) ? "atom" : "atoms";
        return "You have " + action + " " + m + " " + atomStr + " of " + element + ".";
    }

    private static Map<String, Integer> parseSide(String side) {
        TreeMap<String, Integer> sideMap = new TreeMap<>();
        String[] compounds = side.split("\\+");

        for (String compound : compounds) {
            compound = compound.trim();
            if (compound.isEmpty()) continue;

            int compoundMultiplier = 1;
            int i = 0;

            while (i < compound.length() && Character.isDigit(compound.charAt(i))) {
                i++;
            }

            if (i > 0) {
                compoundMultiplier = Integer.parseInt(compound.substring(0, i));
            }

            String moleculeStr = compound.substring(i);
            Map<String, Integer> moleculeMap = parseMolecule(moleculeStr);

            int finalMultiplier = compoundMultiplier;
            moleculeMap.forEach((element, count) -> {
                sideMap.merge(element, count * finalMultiplier, Integer::sum);
            });
        }
        return sideMap;
    }

    private static Map<String, Integer> parseMolecule(String moleculeStr) {
        Map<String, Integer> atomMap = new HashMap<>();
        int i = 0;
        int n = moleculeStr.length();

        while (i < n) {
            char c1 = moleculeStr.charAt(i);
            String element;

            if (i + 1 < n && Character.isLowerCase(moleculeStr.charAt(i + 1))) {
                element = moleculeStr.substring(i, i + 2);
                i += 2;
            } else {
                element = moleculeStr.substring(i, i + 1);
                i += 1;
            }

            int atomCount = 1;
            int startOfDigits = i;

            while (i < n && Character.isDigit(moleculeStr.charAt(i))) {
                i++;
            }

            if (i > startOfDigits) {
                atomCount = Integer.parseInt(moleculeStr.substring(startOfDigits, i));
            }

            atomMap.merge(element, atomCount, Integer::sum);
        }
        return atomMap;
    }
}