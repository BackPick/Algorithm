import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> list = new ArrayList<>();

		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			list.add(list.size()-arr[i],i+1);
		}

		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.print(list.remove(0) + " ");
		}
	}
}