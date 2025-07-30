import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 손님 수
        boolean[] seats = new boolean[101]; // 자리 상태 (1~100번), 인덱스 0은 안 씀
        int rejected = 0;

        for (int i = 0; i < n; i++) {
            int seat = sc.nextInt();
            if (seats[seat]) {
                rejected++; // 이미 누가 앉아있으면 거절
            } else {
                seats[seat] = true; // 빈 자리면 앉힘
            }
        }

        System.out.println(rejected);
    }
}
