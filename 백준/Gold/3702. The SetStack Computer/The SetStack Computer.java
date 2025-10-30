import java.io.*;
import java.util.*;

public class Main {
    static Map<List<Integer>, Integer> idMap = new HashMap<>();
    static ArrayList<HashSet<Integer>> sets = new ArrayList<>();
    static int getId(HashSet<Integer> s) {
        List<Integer> key = new ArrayList<>(s);
        Collections.sort(key);
        Integer id = idMap.get(key);
        if (id != null) return id;
        int nid = sets.size();
        sets.add(new HashSet<>(s));
        idMap.put(key, nid);
        return nid;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            idMap.clear();
            sets.clear();
            HashSet<Integer> empty = new HashSet<>();
            int emptyId = getId(empty);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            String cmd;
            for (int i = 0; i < N; i++) {
                cmd = br.readLine().trim();
                if ("PUSH".equals(cmd)) {
                    stack.push(emptyId);
                } else if ("DUP".equals(cmd)) {
                    int a = stack.pop();
                    stack.push(a);
                    stack.push(a);
                } else if ("UNION".equals(cmd)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    HashSet<Integer> sa = sets.get(a);
                    HashSet<Integer> sb = sets.get(b);
                    HashSet<Integer> nu = new HashSet<>(sa);
                    nu.addAll(sb);
                    int id = getId(nu);
                    stack.push(id);
                } else if ("INTERSECT".equals(cmd)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    HashSet<Integer> sa = sets.get(a);
                    HashSet<Integer> sb = sets.get(b);
                    HashSet<Integer> ni = new HashSet<>();
                    if (sa.size() < sb.size()) {
                        for (int x : sa) if (sb.contains(x)) ni.add(x);
                    } else {
                        for (int x : sb) if (sa.contains(x)) ni.add(x);
                    }
                    int id = getId(ni);
                    stack.push(id);
                } else if ("ADD".equals(cmd)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    HashSet<Integer> sb = new HashSet<>(sets.get(b));
                    sb.add(a);
                    int id = getId(sb);
                    stack.push(id);
                }
                int top = stack.peek();
                bw.write(String.valueOf(sets.get(top).size()));
                bw.newLine();
            }
            bw.write("***");
            bw.newLine();
        }
        bw.flush();
    }
}
