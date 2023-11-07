package Assignment2;

//Question 3


public class CardPicker {
   public static void main (String[] args) {
	   
	   System.out.println("The picked card is: ");
	   //generate a random card based on a number from 0 to 52
	   int randomNumber = (int)((Math.random()*52)+1);
	   
	   //how to calculate the rank and suit
	   int rankIndex = randomNumber % 13;
	   int suitIndex = randomNumber / 13;
	   
	   //print out the suit
	   System.out.print("The suit of the card is ");
	   switch (suitIndex) {
	   case 0:
		   System.out.println("Clubs");
		   break;
	   case 1:
		   System.out.println("Diamonds");
		   break;
	   case 2:
		   System.out.println("Hearts");
		   break;
	   case 3:
		   System.out.println("Spades");
		   break;
		   
	   }
	
	   //print out the rank
	   System.out.print("The rank of the card is ");
	   switch (rankIndex) {
	   case 0:
		   System.out.println("Ace");
		   break;
	   case 1:
		   System.out.println("2");
		   break;
	   case 2:
		   System.out.println("3");
		   break;
	   case 3:
		   System.out.println("4");
		   break;
	   case 4:
		   System.out.println("5");
		   break;
	   case 5:
		   System.out.println("6");
		   break;
	   case 6:
		   System.out.println("7");
		   break;
	   case 7:
		   System.out.println("8");
		   break;
	   case 8:
		   System.out.println("9");
		   break;
	   case 9:
		   System.out.println("10");
		   break;
	   case 10:
		   System.out.println("Jack");
		   break;
	   case 11:
		   System.out.println("Queen");
		   break;
	   case 12:
		   System.out.println("King");
		   break;
	   
	   }
	   
	   
	   

	   
	   

	   
	   
   }
	
	
}
