import java.util.*;

class Point {
    long x, y;
    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class VectorKey {
    int dx, dy;
    VectorKey(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VectorKey)) return false;
        VectorKey other = (VectorKey) o;
        return this.dx == other.dx && this.dy == other.dy;
    }

    @Override
    public int hashCode() {
        return 31 * dx + dy;
    }

    public int compareTo(VectorKey other) {
        if (this.dx != other.dx) {
            return Integer.compare(this.dx, other.dx);
        }
        return Integer.compare(this.dy, other.dy);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            points[i] = new Point(x, y);
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            HashMap<VectorKey, Long> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long dx = points[j].x - points[i].x;
                long dy = points[j].y - points[i].y;
                VectorKey key = normalize((int)dx, (int)dy);
                map.put(key, map.getOrDefault(key, 0L) + 1);
            }

            for (Map.Entry<VectorKey, Long> entry : map.entrySet()) {
                VectorKey v = entry.getKey();
                long countV = entry.getValue();
                VectorKey perp = normalize(v.dy, -v.dx);
                if (v.compareTo(perp) < 0 && map.containsKey(perp)) {
                    long countPerp = map.get(perp);
                    result += countV * countPerp;
                }
            }
        }

        System.out.println(result);
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static VectorKey normalize(int dx, int dy) {
        if (dx == 0 && dy == 0) return new VectorKey(0, 0);
        int g = gcd(dx, dy);
        if (g != 0) {
            dx /= g;
            dy /= g;
        }
        if (dx < 0 || (dx == 0 && dy < 0)) {
            dx = -dx;
            dy = -dy;
        }
        return new VectorKey(dx, dy);
    }
}
