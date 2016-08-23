import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


public class Task_6VFINAL {

	public static void main(String[] args) throws IOException {
		long max= 3000000000L;
		int lessMax = (int)Math.sqrt(max+1);
		long primesFound = 0;
		boolean[] isPrime = new boolean[lessMax];
		Arrays.fill(isPrime, true);
		PrintWriter writer = new PrintWriter(new FileWriter("primes.txt",true));
		System.out.println("Start");
			
		// Find origional primes in first delta
		for (int i = 4; i<lessMax; i+=2) isPrime[i]=false;
		for (int i = 3; i*i<lessMax;i+=2) {
			if(isPrime[i]) {
				for (int j = i*i; j<lessMax; j+=i) {
					isPrime[j]=false;
				}
			} 
		}
		for(int i = 2; i <lessMax; i++) {
			//if (isPrime[i]==true) writer.print(i+",");
			if (isPrime[i]==true) primesFound++;
		}
		
		// Find primes in rest of delta's
		for (long i = lessMax, j = 2*lessMax+1; i<max; i+=lessMax, j+=lessMax) {
			primesFound+=findPrimes(i,j,isPrime);
			System.out.println(primesFound+ " prime numbers found");
			clear();
		}
		System.out.println("Finished, ");
		System.out.println(primesFound+ " prime numbers found between 0 and " +max);
		writer.close();
	}
	
	
	/********************************************
	 ***** find's primes between two limits *****
	 *******************************************/
	public static int findPrimes (long lower, long upper, boolean[] isPrime) throws IOException {
		@SuppressWarnings("resource")
		PrintWriter writer = new PrintWriter(new FileWriter("primes.txt",true));
		boolean[] tempPrime = new boolean[(int)(upper-lower)];
		Arrays.fill(tempPrime, true);
		long temp = lower;
		int primesFound = 0;
		for (int i = 2; i<upper-lower; i+=2) tempPrime[i]=false;
		for (long i = 3; i<(upper-lower); i+=2) {
			if (isPrime[(int)(i)]) {
				temp = lower;
				temp = temp/i;
				temp *= i;
				temp += i;
				for (long j = temp; j<upper; j+=i) {
					//System.err.println("j:"+j);
					tempPrime[(int)(j-lower)]=false;
				}
			}
		}
		for(int i = 0; i <tempPrime.length; i++) {
			//if (tempPrime[i]==true) writer.print(lower+i+",");
			if (tempPrime[i]==true) primesFound++;
		}
		return primesFound;
	}
	
	public static void clear() throws IOException {
		Runtime.getRuntime().exec("clear");
	}
}
