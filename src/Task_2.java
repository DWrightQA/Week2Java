import java.util.Scanner;

public class Task_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("enter a number to print lines of *'s: ");
		String c = "";
		for (int i=1, x = in.nextInt();i<=x;i++) System.out.println( c+='*');
	}
}
