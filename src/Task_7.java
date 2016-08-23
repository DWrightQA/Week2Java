

public class Task_7 {

	public static void main(String[] args) {
		long i = 11;
		long x = 3;
		long bignum = 3000000;
		int test;
		long a,r,d;
		long temp;
		System.out.println("2\n3\n5");
		while (i<bignum) {
			while(true) {
				test = 0;
				a = 0;
				r = 0;
				while (test<3) {
					temp = i-1;
					if(temp%2==0) {
						r++;
						temp/=2;
					}
					d = temp;
					a = (int)(Math.random()*(i-2)+2);
					temp = (long)(Math.pow(a,d)%i);
					if (temp!=1) {
						break;
					}
					while(r>1) {
						if((temp*temp%i)%i==1) {
							break;
						} if ((temp*temp%i)%i==(i-1)) {
							// do nothing
						} else break;						
					}
				}
				if(x>(Math.sqrt(i))) {
					System.out.println(i);
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
		}
	}
}

		