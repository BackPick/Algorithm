import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner를 사용하여 사용자로부터 입력을 받음
        Scanner sc = new Scanner(System.in);
        // 점 A, B, C의 좌표를 입력받음
        int xA = sc.nextInt();
        int yA = sc.nextInt();
        int xB = sc.nextInt();
        int yB = sc.nextInt();
        int xC = sc.nextInt();
        int yC = sc.nextInt();
        sc.close();
        
        // 삼각형의 넓이가 0이면 세 점은 한 직선 상에 있음
        // 벡터의 외적(cross product)를 이용하여 판별: (B-A) x (C-A) = 0 인 경우
        long cross = (long)(xB - xA) * (yC - yA) - (long)(yB - yA) * (xC - xA);
        if(cross == 0) {
            // 세 점이 collinear인 경우 평행사변형을 만들 수 없음.
            System.out.println(-1.0);
            return;
        }
        
        // 두 점 사이의 거리를 계산하는 메서드 없이 Math.sqrt를 직접 사용해 거리 계산
        // dAB: A와 B 사이의 거리
        double dAB = distance(xA, yA, xB, yB);
        // dAC: A와 C 사이의 거리
        double dAC = distance(xA, yA, xC, yC);
        // dBC: B와 C 사이의 거리
        double dBC = distance(xB, yB, xC, yC);

        // 세 가지 평행사변형 후보의 둘레 계산
        // 후보 1: A를 기준점으로 하는 경우, D = B + C - A, 인접 변은 AB와 AC
        double p1 = 2.0 * (dAB + dAC);
        // 후보 2: B를 기준점으로 하는 경우, D = A + C - B, 인접 변은 BA와 BC (BA = AB)
        double p2 = 2.0 * (dAB + dBC);
        // 후보 3: C를 기준점으로 하는 경우, D = A + B - C, 인접 변은 CA와 CB (CA = AC, CB = BC)
        double p3 = 2.0 * (dAC + dBC);
        
        // 최대 둘레와 최소 둘레를 구함
        double maxPerimeter = Math.max(p1, Math.max(p2, p3));
        double minPerimeter = Math.min(p1, Math.min(p2, p3));
        // 결과는 최대 둘레와 최소 둘레의 차이
        double result = maxPerimeter - minPerimeter;
        
        // 결과 출력 (정도 10^-9까지 허용)
        System.out.println(result);
    }
    
    // 두 점 (x1, y1)과 (x2, y2) 사이의 거리를 계산하는 메서드
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (double)(x2 - x1) + (y2 - y1) * (double)(y2 - y1));
    }
}
