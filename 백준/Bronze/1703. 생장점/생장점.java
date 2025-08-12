import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int age = sc.nextInt();
            
            if (age == 0) {
                break;
            }
            
            int leaves = 1;
            
            for (int i = 0; i < age; i++) {
                int splittingFactor = sc.nextInt();
                int prunedBranches = sc.nextInt();
                leaves = leaves * splittingFactor - prunedBranches;
            }
            
            System.out.println(leaves);
        }
        
        sc.close();
    }
}
