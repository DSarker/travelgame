import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TravelGame extends JFrame {

	public static int time; // save time
	public static Double money; // save money
	public static Double dist; // save distance

	public static JTextArea scene; // display scenarios
	public static JTextField name; // display name
	private JPanel options; // hold buttons
	public static JTextField timeField; // display time
	public static JTextField moneyField; // display money
	public static JTextField distField; // display distance

	public static JButton bus; // bus button
	public static JButton walk; // walk button
	public static JButton cab; // car button
	public static JButton start; // start button

	public TravelGame() {
		createGame();
	}

	// updates values for time, money, and distance
	public static void setParam(int t, double m, double d) {
		time = t;
		money = m;
		dist = d;
		timeField.setText("Time: " + Integer.toString(time) + " min");
		moneyField.setText("Money: $" + String.format("%.2f", money));
		distField
				.setText("Distance: " + String.format("%.2f", dist) + " miles");
	}

	// sets the defaults for the JFrame
	private void createGame() {
		Container screenContents = getContentPane();
		screenContents.setLayout(null);

		// create a scene area in the Window
		scene = new JTextArea(10, 11);
		scene.setEditable(false);
		scene.setBorder(new LineBorder(Color.BLUE));
		scene.setText("Travel Game! Try to make the \"journey\" in one piece before you run"
				+ "\nout of time and money. "
				+ "\n\nPlease type your name in the box so that if you win you"
				+ "\nwill be immortalized in the game database!"
				+ "\n\nWhen you're ready press Start to begin!");
		screenContents.add(scene);

		// scroll bar
		JScrollPane scrollBar = new JScrollPane(scene,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JFrame frame = new JFrame("AddScrollBarToJFrame");
		frame.add(scrollBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 250);
		frame.setVisible(true);
		frame.hide();

		screenContents.add(scrollBar);
		scrollBar
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// Options
		options = new JPanel();
		options.setBounds(20, 20, 600, 300);
		options.setBorder(null);
		options.setLayout(null);
		screenContents.add(options);

		// create input box for user name
		name = new JTextField();
		name.setBounds(440, 250, 125, 20);
		name.setVisible(true);
		name.setEditable(true);
		name.setBorder(new LineBorder(Color.RED));
		name.setHorizontalAlignment(JTextField.CENTER);
		name.setText("Type Your Name");
		options.add(name);

		// sets time display defaults
		timeField = new JTextField();
		timeField.setBounds(440, 10, 135, 42);
		timeField.setText("Time");
		timeField.setHorizontalAlignment(JTextField.CENTER);
		timeField.setEditable(false);
		timeField.setBorder(new LineBorder(Color.CYAN));
		Font font = new Font("Verdana", Font.BOLD, 14);
		timeField.setFont(font);
		options.add(timeField);

		// sets money display defaults
		moneyField = new JTextField();
		moneyField.setBounds(440, 60, 135, 42);
		moneyField.setText("Money");
		moneyField.setHorizontalAlignment(JTextField.CENTER);
		moneyField.setEditable(false);
		moneyField.setBorder(new LineBorder(Color.GREEN));
		font = new Font("Comic Sans MS", Font.BOLD, 14);
		moneyField.setFont(font);
		options.add(moneyField);

		// sets distance display defaults
		distField = new JTextField();
		distField.setBounds(440, 110, 135, 42);
		distField.setText("Distance");
		distField.setHorizontalAlignment(JTextField.CENTER);
		distField.setEditable(false);
		distField.setBorder(new LineBorder(Color.MAGENTA));
		font = new Font("Comic Sans MS", Font.BOLD, 12);
		distField.setFont(font);
		options.add(distField);

		// sets up Buttons with Bus, Cab, and Walk
		bus = new JButton();
		bus.setBounds(0, 250, 95, 24);
		bus.setText("Take Bus");
		bus.setEnabled(false);
		options.add(bus);
		bus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pressed) {
				BusAction(pressed);
			}
		});

		// walk button
		walk = new JButton();
		walk.setBounds(130, 250, 95, 24);
		walk.setText("Walk It");
		walk.setEnabled(false);
		options.add(walk);
		walk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pressed) {
				WalkAction(pressed);
			}
		});

		// cab button
		cab = new JButton();
		cab.setBounds(260, 250, 130, 24);
		cab.setText("Take Cab");
		cab.setEnabled(false);
		options.add(cab);
		cab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pressed) {
				CarAction(pressed);
			}
		});

		// start button
		start = new JButton();
		start.setBounds(440, 190, 130, 24);
		start.setText("Start!");
		options.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent pressed) {
				StartAction(pressed);
			}
		});

		// title
		setTitle("Travel Game!"); // set title bar string
		setSize(650, 370); // set window size
		setVisible(true); // display window

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	// sets the action for bus button
	private void BusAction(ActionEvent event) {
		Scenario.bus();
	}

	// sets the action for walk button
	private void WalkAction(ActionEvent event) {
		Scenario.walk();
	}

	// sets the action for the car button
	private void CarAction(ActionEvent event) {
		Scenario.cab();
	}

	// sets the action for the start button
	private void StartAction(ActionEvent event) {
		bus.setEnabled(true);
		cab.setEnabled(true);
		walk.setEnabled(true);
		name.setEditable(false);

		// sets random defaults for time, money, and distance
		int randT = Randomizer.randInt(120, 150); // Time
		int randM = Randomizer.randInt(70, 100); // Money
		int randD = Randomizer.randInt(5, 7); // Distance

		setParam(randT, randM, randD);
		// scene.setText("");
		Scenario.Start(Randomizer.randInt(1, 3));
		start.setEnabled(false);
	}

	public static void main(String args[]) {
		TravelGame Game = new TravelGame();
	}
}
