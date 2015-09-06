//class contains all the different possible scenarios along with the respective probabilities.
public class Scenario extends TravelGame {

	//sets the initial scenario
	public static void Start(int opt) {
		switch (opt){
		case 1: 
			scene.setText("You're at home and you get a phone call from the hospital."
					+ "\nYour only cousin is in labor. Your mission, should you choose"
					+ "\nto accept, is to see that childs birth.\n\n");
			break;
		case 2:
			scene.setText("In the city of Townsville, there is a hurricane heading towards"
					+ "\nthe city. You need to make it to the shelter before everything you"
					+ "\nknow ceases to exist.\n\n");
			break;
		case 3:
			scene.setText("You thought finals were over and partied so hard that you passed"
					+ "\nout.You wake up the next day, sometime in the afternoon, to realize"
					+ "\nyour CSC330 final starts soon. You have to get to class on time"
					+ "\nbecause Professor Iacona does not mess around.\n\n");
		}
	}

	public static void bus() {
		double rate = 2.5;
		char[] cases = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
		int[] prob =   {7,   15,   8,   6,   8,   5,   5,  15,   9,   9,  13};
		char opt = Randomizer.probability(cases, prob);

		switch (opt) {
		case 'A': 
			setParam(time-20,money-0,dist-0);
			scene.append("You just missed the bus because you were talking to that cute girl."
					+ "\nAt least you got here number ;-)\n\n");
			break;
		case 'B':
			setParam(time-20,money-rate,dist-.8);
			scene.append("While riding the bus, you got stuck in traffic.\n\n");
			break;
		case 'C':
			setParam(time-30,money-rate,dist-.8);
			scene.append("As you were riding the bus, the bus driver had to pull over"
					+ "\nbecause a pregnant woman gave birth to triplets!\n\n");
			break;
		case 'D':
			setParam(time-10,money-rate,dist-.4);
			scene.append("While riding the bus, you got into a fight with an old man."
					+ "\nAfter you got beat up, you were also kicked off the bus.\n\n");
			break;
		case 'E':
			setParam(time-20,money-rate-15,dist-.8);
			scene.append("While riding the bus, an armed assailant swiped cash from everyone.\n\n");
			break;
		case 'F': 
			setParam(time-9000,money-9000,dist-9000);
			scene.append("Your bus was involved in an accident with two semi trucks."
					+ "\nYou've become forever incapacitated.\n\n");
			break;
		case 'G':
			setParam(time-20,money-rate,dist-3);
			scene.append("The bus you were on had an explosive which would detonate if"
					+ "\nthe bus went below 60 mph. After 20 minutes, SWAT diffused the"
					+ "\nbomb and everyone got off the bus safely.\n\n");
			break;
		case 'H':
			setParam(time-10,money-rate-10,dist-.5);
			scene.append("You were hungry so you got off the bus early to get a bite to eat.\n\n");
			break;
		case 'I':
			setParam(time-15,money-money,dist-1);
			scene.append("You forgot your wallet on the bus.\n\n");
			break;
		case 'J':
			setParam(time-15,money+10,dist-.8);
			scene.append("You found $10 wedged inbetween the seats.\n\n");
			break;
		case 'K':
			setParam(time-20,money-rate,dist-1.5);
			scene.append("You got off 10 stops away.\n\n");				
		}
		Status.statusCheck();
	}


	public static void walk() {
		char[] cases = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
		int [] prob=   {10,   8,   9,   13,  7,   10, 10,   9,   6,  13,   5};

		char opt = Randomizer.probability (cases, prob);

		switch (opt) {
		case 'A':
			scene.append("Took a brisk walk.\n\n");
			setParam(time-10,money-0,dist-.5);
			break;  
		case 'B':
			scene.append("You were walking down the street and suddenly got robbed by an"
					+ "\nold lady.\n\n");   	
			setParam(time-10,money-25,dist-.7);
			break;
		case 'C':
			scene.append("You got hungry along the way and bought a hot dog.\n\n");
			setParam(time-10,money-3,dist-.5);
			break;
		case 'D':
			scene.append("Along the way you gave $10 to a homeless man.\n\n");
			setParam(time-12,money-10,dist-.8);
			break;
		case 'E':
			scene.append("You took a short cut through a park and saved some time.\n\n");
			setParam(time-7,money-0,dist-1);
			break;
		case 'F':    	 	 
			scene.append("Lucky you!!!, Along the way you found ten dollars on the floor.\n\n");
			setParam(time-6,money+10,dist-.7);
			break;
		case 'G':
			scene.append("Over an argument, you got into a fight with a drunk hobo.\n\n");
			setParam(time-20,money-0,dist-.5);
			break;
		case 'H':
			scene.append("You took a very long bathroom break.\n\n");
			setParam(time-15,money-0,dist-.4);
			break;
		case 'I':
			scene.append("You bought an energy drink for $5 and decided to sprint for a bit.\n\n"); 
			setParam(time-5,money-5,dist-1.2);
			break;
		case 'J':
			scene.append("You turn a corner and find that a parade blocks your way.\n\n");
			setParam(time-20,money-0,dist-.7);
			break;
		case 'K':
			scene.append("By some unfortunate event your leg is broken, your cellphone is "
					+ "\nout of battery and no ones around to hear or help you.\n\n");
			setParam(time-1000,money-1000,dist-1000);
			break;	
		}
		Status.statusCheck();
	}

	public static void cab() {
		double rate= 14.50;

		char [] cases={'A','B','C','D','E','F','G','H','I','J','K'};

		int [] prob=  {20,  5,  10, 5,  10, 5,  10, 10, 10 ,5, 10};

		char opt = Randomizer.probability(cases, prob);

		switch (opt) {
		case 'A': 
			setParam(time-30, money-0, dist-0);
			scene.append("You spent about a good half hour trying to catch a taxi, and failed.\n\n");
			break;
		case 'B':	
			setParam(time-5,money-rate-10,dist-.10);
			scene.append("Your cab hit a pot hole and got a flat tire.\n\n");
			break;
		case 'C': 	
			setParam(time-30,  money-rate,dist-1);
			scene.append("The cab driver was distracted wooing at some girls and crashed.\n\n");
			break;
		case 'D':
			setParam(time-30, money-0, dist+.25);
			scene.append("In a rush, you get in a cab that looks like a cab, but"
					+ "\nis actually a prop for a taxi parade.\n\n");
			break;
		case 'E': 
			setParam(time-20, money-rate-6, dist-.50);
			scene.append("You get in the cab and drive a couple of blocks up to get lunch.\n\n");
			break;
		case 'F':
			setParam(time-40, money-rate, dist- .70);
			scene.append("You're in the cab and you get stuck in traffic.\n\n");
			break;
		case 'G': 	
			setParam(time-25, money-0,dist-.30);
			scene.append("Your cab driver fights with the truck driver who's blocking the way."
					+ "\nYou sneak out without paying.\n\n");
			break;
		case 'H':
			setParam(time-10,money-0,dist-0);
			scene.append("You approach a cab but someone pushes you out of the way and"
					+ "\ntakes it from you!\n\n");
			break;
		case 'I':		
			setParam(time-30, money-rate+20, dist-.9);
			scene.append("You get in the cab to find out there was $20 squished in between"
					+ "\nthe seats.\n\n ");
			break;
		case 'J':
			setParam(time-10000, money-10000,dist-0);				
			scene.append("Your cab driver's pet snake came out of the trunk and bit you"
					+ "\nright on your neck. Within seconds the venom causes cardiac arrest"
					+ "\nand you don't survive.\n\n");
			break;
		case 'K': 	
			setParam(time-30,money-rate,dist-1.3);							
			scene.append("The cab driver gets pulled over by the cops for speeding.\n\n");

		}
		Status.statusCheck();
	}
}



