import java.util.Scanner;
public class Task_5 {
	
	static class Paint {	//creates the class paint
		public float amount;
		public double price;
		public int eff;
		public float percan;
		
		public Paint() {
			this.amount=0;
			this.price=0;
			this.eff=0;
			this.percan = 0;
		}
		public Paint(float amount,double price,int eff) {
			this.amount=amount;
			this.price=price;
			this.eff=eff;
			this.percan =amount*eff;
		}
	}
	
	public static void main(String[] args) {
		
		// creates the three types of paint
		float sizeOfRoom = 0;
		Paint CheapoMax = new Paint(20,19.99,10);
		Paint AverageJoes = new Paint(15,17.99,11);
		Paint DuluxourousPaints = new Paint(10,25,20);	
		
		// Getting Size of room and variable initilization
		Scanner read = new Scanner(System.in);
		System.out.println("Put in a surface area in m^2: ");
		String temp = read.nextLine();
		sizeOfRoom = Float.parseFloat(temp);
		float hold;
		System.out.println("Size of room: " +sizeOfRoom+ "m^2");
		int numOfCans;
		float waste;
		float bestprice;
		int bestpricechoice = 1;
		float bestwaste;
		int bestwastechoice = 1;
		
		// CheapoMax Calc
		hold = sizeOfRoom;
		numOfCans=0;
		while(hold>CheapoMax.percan) {
			hold -= CheapoMax.percan;
			numOfCans++;
		}
		numOfCans++;
		hold -= CheapoMax.percan;
		waste = hold;
		if (waste<0) waste*=-1;	// forces positive value of waste
		System.out.print("CheapoMax, num of cans: " +numOfCans);
		System.out.printf(", cost: £%.2f",(float)(numOfCans*CheapoMax.price));
		System.out.println(", waste: " +waste+ " litres");
		bestprice = (float)(numOfCans*CheapoMax.price);
		bestwaste = waste;
		
		
		// AverageJoes Calc
		hold = sizeOfRoom;
		numOfCans=0;
		while(hold>AverageJoes.percan) {
			hold -= AverageJoes.percan;
			numOfCans++;
		}
		numOfCans++;
		hold -= AverageJoes.percan;
		waste = hold;
		if (waste<0) waste*=-1;	// forces positive value of waste
		System.out.print("AverageJoes, num of cans: " +numOfCans);
		System.out.printf(", cost: £%.2f",(float)(numOfCans*AverageJoes.price));
		System.out.println(", waste: " +waste+ " litres");
		if (bestprice>((float)(numOfCans*AverageJoes.price))) {  // if better price then sets best price to this
			bestprice=(float)(numOfCans*AverageJoes.price);
			bestpricechoice = 2;
		}
		if (bestwaste>waste) { // if better waste amount then sets best waste amount to this
			bestwaste=waste;
			bestwastechoice = 2;
		}
		
		// DuluxourousPaints  Calc
		hold = sizeOfRoom;
		numOfCans=0;
		while(hold>DuluxourousPaints .percan) {
		hold -= DuluxourousPaints .percan;
			numOfCans++;
		}
		numOfCans++;
		hold -= DuluxourousPaints .percan;
		waste = hold;
		if (waste<0) waste*=-1;	// forces positive value of waste
		System.out.print("DuluxourousPaints, num of cans: " +numOfCans);
		System.out.printf(", cost: £%.2f",(float)(numOfCans*DuluxourousPaints.price));
		System.out.println(", waste: " +waste+ " litres");
		if (bestprice>((float)(numOfCans*DuluxourousPaints.price))) { // if better price then sets best price to this
			bestprice=(float)(numOfCans*DuluxourousPaints.price);
			bestpricechoice = 3;
		}
		if (bestwaste>waste) { // if better waste amount then sets best waste amount to this
			bestwaste=waste;
			bestwastechoice = 3;
		}
		
		//Works out which is best
		System.out.println("");
		switch(bestpricechoice) {
			case 1: System.out.println("CheapoMax is the cheapest at £" + bestprice);
					break;
			case 2: System.out.println("AverageJoes is the cheapest at £" + bestprice);
					break;
			case 3: System.out.println("DuluxourousPaints is the cheapest at £" + bestprice);
					break;
		}
		switch(bestwastechoice) {
			case 1: System.out.println("CheapoMax is the least waste at " +bestwaste+ " litres");
					break;
			case 2: System.out.println("AverageJoes is the least waste at " +bestwaste+ " litres");
					break;
			case 3: System.out.println("DuluxourousPaints is the least waste at " +bestwaste+ " litres");
					break;
		}
		
	}

}
