//Class checks the status of the player
public class Status extends TravelGame{
	
	public static void statusCheck() {
		//checks if you lose if time or money is less than 0
		if(time <= 0 || money < 0) {
			youLose();
		}

		//checks if you win if the distance is less than or equal to 0
		else if (dist <= 0) {
			Log.userStats();
			youWin();
		}

		//checks if user can afford the bus option and disables it and the cab if not
		else if (money < 2.50) {
			bus.setEnabled(false);
			cab.setEnabled(false);
		}
		
		//checks if user can afford the cab option and disables it if not
		else if (money < 14.50) {
			cab.setEnabled(false);
		}
	}

	//displays the losing message and disables most of the options
	public static void youLose() {
		scene.append("\n\nYOU HAVE FAILED THIS CITY!\n"
				+ "You get shot in the face with an arrow.");
		bus.setEnabled(false);
		cab.setEnabled(false);
		walk.setEnabled(false);
		start.setEnabled(true);
		name.setEditable(true);

		scene.append("\n\nPress Start to play again.");
	}

	//displays the winning option and disables most of the options
	public static void youWin() {
		scene.append("\n\n********** YOU WIN! CLAIM YOUR $1 **********");
		scene.append("\n\nPress Start to play again.");

		bus.setEnabled(false);
		cab.setEnabled(false);
		walk.setEnabled(false);
		start.setEnabled(true);
		
		name.setVisible(true);
		name.setEditable(true);
	}
}


