import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;



public class Task_6 {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		long max= 3000000000L;
		int lessMax = (int)Math.sqrt(max);
		boolean[] isPrime = new boolean[lessMax];
		boolean[] tempPrime = new boolean[lessMax];
		Arrays.fill(isPrime, true);
		PrintWriter writer = new PrintWriter("primes.txt", "UTF-8");
		writer.println("2");
		
		
		for (int i = 2; i<max; i+=2) isPrime[i]=false;
		for (int i = 3; i*i<max;i+=2) {
			if(isPrime[i]) {
				for (int j = i*i; j<max; j+=i) {
					isPrime[j]=false;
				}
			} 
		}
		for(int i = 2; i <max; i++) {
			if (isPrime[i]==true) writer.println(i);
		}
		writer.close();
		System.out.println("finished");
	}
}
