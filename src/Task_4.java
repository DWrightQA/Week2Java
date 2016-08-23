import java.util.Scanner;

public class Task_4 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in); 
		System.out.println("Write anything :)  ");
		String s = read.nextLine();
		StringBuffer test = new StringBuffer(s);
		System.out.println(test.reverse());
	}
}

