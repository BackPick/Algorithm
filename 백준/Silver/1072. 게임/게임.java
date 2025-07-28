public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long X = scanner.nextLong();
        long Y = scanner.nextLong();
        scanner.close();

        long Z = (Y * 100) / X;

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 1;
        long high = 2000000000L;
        long answer = -1;

        while (low <= high) {
            long mid = (low + high) / 2;
            long newZ = ((Y + mid) * 100) / (X + mid);

            if (newZ > Z) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
