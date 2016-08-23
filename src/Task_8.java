import java.util.Scanner;

// water is '~', hit is 'x', miss is 'o', 

public class Task_8 {

	/********************************************
	********* Creating class of each ship *******
	********************************************/	
	public static class Ship {
		public char shipType;
		public int shipLength;
		public int shipHealth;
		public int shipPos[] = new int[2];
		public int shipHeading;
	}
	
	public class PatrolBoat extends Ship {{ //silly error when only 1 curly, so 2
		shipType = 'p';
		shipLength = 2;
		shipHealth = shipLength;
	}}
	public class Battleship extends Ship {{
		shipType = 'b';
		shipLength = 3;
		shipHealth = shipLength;
	}}
	public class Submarine extends Ship {{
		shipType = 's';
		shipLength = 3;
		shipHealth = shipLength;
	}}
	public class Destroyer extends Ship {{
		shipType = 'd';
		shipLength = 4;
		shipHealth = shipLength;
	}}
	public class Carrier extends Ship {{
		shipType = 'c';
		shipLength = 5;
		shipHealth = shipLength;
	}}
	
	
	/****************************************** 
	********* Main code goes here *************
	******************************************/	
	public static void main(String[] args) {
		int boardWidth = 3;
		int boardHeight = boardWidth;
		char position[][] = new char[boardWidth][boardHeight];
		Scanner read = new Scanner(System.in); 
		int i,j,posX,posY; 
		boolean success = false;
		String s;
		for (i=0;i<position.length;i++) {
			for (j=0;j<position[0].length;j++) {
				position[i][j]='~';
			}
		}
		
		playerboard(position);
		
		// Place Patrol Boat
		while(!success) {
			System.out.println("\nPick a location for a Patrol boat(letter,number): ");
			s = read.nextLine();
			String[] split = s.split(",");
			posY = letterToNumber(split[0]);
			posX = Integer.parseInt(split[1]);
			if(s.length()>4) {
				System.out.println("Sorry, that's not a valid location");
			}
			boolean[] temp = canPlace(position,posX,posY,2);
			for (i=0;i<temp.length;i++) {
				success=false;
				if (temp[i]) {
					switch (i) {
						case 0:	System.out.println("You can place North");
								success=true;
								break;
						case 1:	System.out.println("You can place East");
								success=true;
								break;
						case 2:	System.out.println("You can place South");
								success=true;
								break;
						case 3:	System.out.println("You can place West");
								success=true;
								break;
					}
					
				}
			}
			
		}
	}
	
	
	/****************************************** 
	** Prints out the player board to screen **
	******************************************/	
	public static void playerboard(char [][]position) {
		System.out.println("  A  B  C");
		int i,j;
		for (i=0;i<position.length;i++) {
			System.out.print(i);
			for (j=0;j<position[i].length;j++) {
				System.out.print("[" +position[i][j]+ "]");
			}
			System.out.println();
		}
		return;
	}
		
	
	/*********************************************** 
	**** Converts letter to a number(a/1,b/2... ****
	***********************************************/
	public static int letterToNumber(String s) {
		int i;
		s=s.toLowerCase();
		switch(s) {
			case "a":	i = 0;
						break;
			case "b":	i = 1;
						break;
			case "c":	i = 2;
						break;
			case "d":	i = 3;
						break;
			case "e":	i = 4;
						break;
			case "f":	i = 5;
						break;
			case "g":	i = 6;
						break;
			case "h":	i = 7;
						break;
			case "i":	i = 8;
						break;
			case "j":	i = 9;
						break;
			case "k":	i = 10;
						break;
			case "l":	i = 11;
						break;
			default :   i = 0;
						break;
		}
		return i;
	}
	
	/*********************************************** 
	**** Converts letter to a number(a/1,b/2... ****
	***********************************************/
	public static boolean[] canPlace(char[][] position, int positionX, int positionY, int shipLength) {
		boolean[] dir = new boolean[4]; //[North][East][South][West]
		boolean success;
		
		//Test okay for North
		success = true;
		for(int i = 0; i<shipLength; i++) {
			try {
				if (position[positionY-shipLength][positionX]=='~'); // do nothing
				else success = false;
			} catch (ArrayIndexOutOfBoundsException e){
				success = false;
			}
		} if (success) dir[0]=true;
		
		//Test okay for East
		success = true;
		for(int i = 0; i<shipLength; i++) {	
			try {
				if (position[positionY][positionX+shipLength]=='~'); // do nothing
				else success = false;
			} catch (ArrayIndexOutOfBoundsException e){
				success = false;
			}
		} if (success) dir[1]=true;

		//Test okay for South
		success = true;
		for(int i = 0; i<shipLength; i++) {
			try {
				if (position[positionY+shipLength][positionX]=='~'); // do nothing
				else success = false;
			} catch (ArrayIndexOutOfBoundsException e ){
				success = false;
			}
		} if (success) dir[2]=true;
		
		//Test okay for West
		success = true;
		for(int i = 0; i<shipLength; i++) {	
			try {
				if (position[positionY][positionX-shipLength]=='~'); // do nothing
				else success = false;
			} catch (ArrayIndexOutOfBoundsException e){
				success = false;
			}
		} if (success) dir[3]=true;		
			
		return dir;
	}

}
