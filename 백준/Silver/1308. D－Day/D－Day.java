import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 오늘 날짜 입력
        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();

        // D-Day 날짜 입력
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        // LocalDate 객체로 변환
        LocalDate today = LocalDate.of(y1, m1, d1);
        LocalDate dDay = LocalDate.of(y2, m2, d2);

        // 천년 후 날짜 계산
        LocalDate thousandYearsLater = today.plusYears(1000);

        // 조건에 따라 출력
        if (!dDay.isBefore(thousandYearsLater)) {
            System.out.println("gg");
        } else {
            long daysBetween = ChronoUnit.DAYS.between(today, dDay);
            System.out.println("D-" + daysBetween);
        }
    }
}
