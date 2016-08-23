import java.util.Arrays;


public class findPrime{

	private static final int MAX = 100000000;
	private static boolean[] array = new boolean[MAX];
	
	public static void main(String[] args) {
	
		for (int i = 2; i < MAX; i++) {
		  if (!array[i]) {
		    int j = i + i;
		    while (j < MAX) {
		      array[j] = true;
		      j += i;
		    }
		  }
		}

	}

}
