import java.util.Random;

public class Randomizer {
	
	/*
	 * Takes in two integers (minimum, maximum)
	 * and returns an integer that is between the 
	 * min, max arguments. 
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		
		int randomNum = rand.nextInt((max-min)+1)+min;
		
		return randomNum;
	}
	
	/*
	 * Takes in two arrays. Char array: letter corresponds to a specific event
	 * Int array: integer that corresponds to the chance of the of a specific event occurring
	 * ex: char [A, B, C]  int [25, 25, 50] ('A' has a 25%, 'B' = 25%, 'C' = 50%)
	 * If the random number is 32, event 'B' is triggered.
	 * Like a number line A from 0-24, B from 25-49, and C from 50-99 
	 */
	public static char probability(char [] cases, int [] prob) {
		char opt='d';
		int r = randInt(0,99);
		int cdf = 0;

		for(int i=0; i <cases.length;i++) {
			cdf += prob[i];
			if( r <cdf) {
				opt=cases[i]; 
				break;
			}     
		}	
		return opt;
	}
}

