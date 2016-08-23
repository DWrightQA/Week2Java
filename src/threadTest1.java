import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;


public class threadTest1 implements Runnable{

	long i;
	long bignum;
	
	public threadTest1(long i, long bignum) {
		this.i=i;
		this.bignum=bignum;
		
	}
	public static void main(String[] args) {
		System.out.println("2\n3\n5");
		new Thread(new threadTest1(1,1000000000)).start();
		new Thread(new threadTest1(10000000001,2000000000)).start();
		new Thread(new threadTest1(20000000001,3000000000)).start();
	}
	@Override
	public void run() {
		int x = 3;	
		while (i<bignum) {
			while(true) {
				if (x%5==0) {
					x+=2;
					continue;
				}
				if(x*x>i) {
					break;
				}
				if(i%x==0) {
					break;
				} else {					
					x+=2;
				}
			}
			x = 3;
			i+=2;
			if(i%5==0) {
				i+=2;
			}
		}
		System.out.println("finished");
	}
}
