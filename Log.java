import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//displays the users winning details
public class Log extends TravelGame {

	public static void userStats() {
		String nameText = name.getText();
		if (name.getText().contentEquals("Type Your Name"))
			nameText = "Winner";

		String moneyText = moneyField.getText();
		String timeText = timeField.getText();

		// Create a database connection
		String dbUrl = "jdbc:mysql://localhost:3306/travelgame";
		String user = "root";
		String pass = "root";

		try {
			// 1. Get a connection to database
			Connection myConn = DriverManager.getConnection(dbUrl, user, pass);

			// 2.Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			String sql = String.format("insert into winners"
					+ " values ('%s', '%s', '%s')", nameText, moneyText,
					timeText);

			myStmt.executeUpdate(sql);

			// 4. Print winners from database.
			ResultSet myRs = myStmt.executeQuery("select * from winners");
			
			System.out.println("---------------WINNERS---------------");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("name") + "\t"
						+ myRs.getString("moneyleft") + "\t"
						+ myRs.getString("timeleft"));
			}

		} catch (Exception e) {
			System.out.println("Unable to coonnect to database.");
		}
	}
}
