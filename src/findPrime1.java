import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class findPrime1 {
	
	private static final int MAX = 1000000000;
	private static final int SQRT_MAX = (int) Math.sqrt(MAX) + 1;
	private static final int MEMORY_SIZE = (int) (MAX / 2);
	private static boolean[] array = new boolean[MEMORY_SIZE];
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
		System.out.println("Start");
		for (int i = 3; i < SQRT_MAX; i += 2) {
			  if (!array[(i)]) {
			    int j = i*2;
			    while (j < MEMORY_SIZE) {
			      array[j] = true;
			      writer.println(j);
			      j += i;
			    }
			  }
			}
		writer.close();
		System.out.println("finished");

	}

}
