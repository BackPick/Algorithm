import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    // DSU (Disjoint Set Union) 클래스 정의
    static class UnionFind {
        int[] parent;   // 각 원소의 부모를 저장하는 배열
        int[] rank;     // 트리의 높이(또는 랭크)를 저장하는 배열

        // DSU 생성자 (n 크기의 집합을 초기화)
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 각 원소는 자기 자신을 부모로 초기화
                rank[i] = 0;   // 초기 랭크는 0으로 설정
            }
        }

        // find 메서드: 원소 i의 루트를 찾으며 경로 압축 수행
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]); // 경로 압축
            }
            return parent[i];
        }

        // union 메서드: 두 원소 i와 j를 합침
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) return; // 이미 같은 집합인 경우 종료

            // 랭크를 비교하여 낮은 트리를 높은 트리에 붙임
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++; // 랭크가 같으면 하나 증가
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int caseNum = 1;
        
        // 테스트 케이스 루프
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue; // 빈 줄 건너뛰기
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // n과 m이 0이면 종료
            if (n == 0 && m == 0) break;
            
            // DSU 초기화
            UnionFind uf = new UnionFind(n);
            
            // m개의 쌍에 대해 union 연산 수행 (1-index 입력 -> 0-index로 변환)
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int i1 = Integer.parseInt(st.nextToken()) - 1;
                int j1 = Integer.parseInt(st.nextToken()) - 1;
                uf.union(i1, j1);
            }
            
            // 서로 다른 집합의 수를 계산 (각 집합은 하나의 종교를 의미)
            HashSet<Integer> religions = new HashSet<>();
            for (int i = 0; i < n; i++) {
                religions.add(uf.find(i));
            }
            
            // 결과 출력
            System.out.println("Case " + caseNum + ": " + religions.size());
            caseNum++;
        }
    }
}
