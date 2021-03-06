import java.util.Scanner;

// water is '~', hit is 'x', miss is 'o', 

public class Task_8V2 {

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
			success = true;
			System.out.print("\nPick a location for a Patrol boat(letter,number): ");
			s = read.nextLine();
			String[] split = s.split(",");
			posX = letterToNumber(split[0]);
			posY = Integer.parseInt(split[1]);
			boolean[] temp = canPlace(position,posX,posY,2);
			for (i=0;i<temp.length;i++) {
				if (temp[i]) {
					switch (i) {
						case 0:	System.out.println("You can place North");
								break;
						case 1:	System.out.println("You can place East");
								break;
						case 2:	System.out.println("You can place South");
								break;
						case 3:	System.out.println("You can place West");
								break;
					}
				}
			}
			if (!temp[0] && !temp[1] && !temp[2] && !temp[3]) {
				System.out.println("You can't place anywhere, try another point");
				success = false;
				continue;
			}
			System.out.print("Which direction would you like to put the ship(North,East,South,West)?: ");
			s = read.nextLine();
			s = s.toLowerCase();
			switch (s) {
				case "north": if (temp[0]) j = 1;
							  else {
								  System.out.println("Can't place a ship there! Pick another point.");
								  success = false;
								  continue;
							  }
							  break;
				case "east":  if (temp[1]) j = 2;
							  else {
								  System.out.println("Can't place a ship there! Pick another point.");
								  success = false;
								  continue;
							  }
							  break;
				case "south": if (temp[2]) j = 3;
							  else {
								  System.out.println("Can't place a ship there! Pick another point.");
								  success = false;
								  continue;
							  }
				  			  break;
				case "west":  if (temp[3]) j = 4;
							  else {
								  System.out.println("Can't place a ship there! Pick another point.");
								  success = false;
								  continue;
							  }
							  break;
				default: 	  continue;
			}
			position = placeShip(position,posX,posY,2,j);
			playerboard(position);
			
		}
	}
	
	
	/****************************************** 
	** Prints out the player board to screen **
	******************************************/	
	public static void playerboard(char [][]position) {
		System.out.println("\n\n    A  B  C");
		int i,j;
		for (i=0;i<position.length;i++) {
			System.out.print("  " +i);
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
	
	/************************************************************* 
	**** Checks if a ship can be placed and in what direction ****
	*************************************************************/
	public static boolean[] canPlace(char[][] position, int posX, int posY, int shipLength) {
		boolean[] dir = new boolean[4]; //[North][East][South][West]
		for (int i = 0; i<dir.length;i++) {
			dir[i]=false;
		}
		boolean success;
		int i;
		
		// only tests if within board
		if (posX<position.length && posY<position.length ) {
			
			//Test okay for North
			success = true;
			for(i = 0; i<shipLength; i++) {
				try {
					if (position[posY][posX-i]=='~'); // do nothing
					else success = false;
				} catch (ArrayIndexOutOfBoundsException e){
					success = false;
				}
			} if (success) dir[0]=true;
			
			//Test okay for East
			success = true;
			for(i = 0; i<shipLength; i++) {	
				try {
					if (position[posY+i][posX]=='~'); // do nothing
					else success = false;
				} catch (ArrayIndexOutOfBoundsException e){
					success = false;
				}
			} if (success) dir[1]=true;
	
			//Test okay for South
			success = true;
			for(i = 0; i<shipLength; i++) {
				try {
					if (position[posY][posX+i]=='~'); // do nothing
					else success = false;
				} catch (ArrayIndexOutOfBoundsException e ){
					success = false;
				}
			} if (success) dir[2]=true;
			
			//Test okay for West
			success = true;
			for(i = 0; i<shipLength; i++) {	
				try {
					if (position[posY-i][posX]=='~'); // do nothing
					else success = false;
				} catch (ArrayIndexOutOfBoundsException e){
					success = false;
				}
			} if (success) dir[3]=true;		
		}
		return dir;
	}
	
	/**************************************************************** 
	**** Places a ship in specified direction, no error checking ****
	****************************************************************/
	public static char[][] placeShip(char [][]position,int posX, int posY, int shipLength, int direction) {
		int i;
		if (direction==1) {
			for (i=0;i<shipLength;i++) position[posX-i][posY]='p';
		} else if (direction==2) {
			for (i=0;i<shipLength;i++) position[posX][posY+i]='p';
		} else if (direction==3) {
			for (i=0;i<shipLength;i++) position[posX+i][posY]='p';
		} else if (direction==4) {
			for (i=0;i<shipLength;i++) position[posX][posY-i]='p';
		}
		return position;
	}

}
