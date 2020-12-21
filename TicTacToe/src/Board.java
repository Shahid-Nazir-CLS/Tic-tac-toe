import javax.swing.*;
import java.awt.*;

class Board extends JFrame{

	JButton[] btn_cell = new JButton[10];

	JButton btnNew;
	JButton btnExit;
	JButton btnStats;

	JLabel lblTurn;
	JLabel lblP1Choice;
	JLabel lblP2Choice;

	public Board(){
		// Name of Game Window
		super("TicTacToe");

		// Size of window
		setSize(800,700);

		// Exit Game on Closing Window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Location of window on Screen
		setLocation(400,100);

		// Window cannot be resized i.e. window size is fixed
		setResizable(false);


		// Panel for status of game
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Panel for game button cells
        GridLayout gridLayoutMiddle = new GridLayout(3,3);
        JPanel middlePanel = new JPanel(gridLayoutMiddle);

        // Panel for new game and exit buttons
        GridLayout gridLayoutFooter = new GridLayout(1,2);
        JPanel footerPanel = new JPanel(gridLayoutFooter);

        // Adding buttons in the middle panel
        for(int i = 1; i < 10; i++){
		 	btn_cell[i] = new JButton();
		 	btn_cell[i].setPreferredSize(new Dimension(150, 150));

		 	// disable buttons initially
		 	btn_cell[i].setEnabled(false);

		 	btn_cell[i].setText("Press new Game!");

		 	// add buttons to middle panel
		 	middlePanel.add(btn_cell[i]);


		}

		// Adding new game and exit buttons to footer panel
		//New game button 
		btnNew = new JButton("New Game");
		btnNew.setPreferredSize(new Dimension(100, 50));
		footerPanel.add(btnNew);

		// Stats button
		btnStats = new JButton("Show Stats");
		btnStats.setPreferredSize(new Dimension(100, 50));
		footerPanel.add(btnStats);

		// Exit game button
		btnExit = new JButton("Exit Game");
		btnExit.setPreferredSize(new Dimension(100, 50));
		footerPanel.add(btnExit);


		// Adding status labels to the header
		lblTurn = new JLabel();
		lblP1Choice = new JLabel();
		lblP2Choice = new JLabel();

		// Label size set
		lblTurn.setPreferredSize(new Dimension(280, 50));
		lblP1Choice.setPreferredSize(new Dimension(220, 50));
		lblP2Choice.setPreferredSize(new Dimension(200, 50));

		// label font size setup
		lblTurn.setFont(new Font("Serif", Font.BOLD, 18));
		lblP1Choice.setFont(new Font("Serif", Font.BOLD, 18));
		lblP2Choice.setFont(new Font("Serif", Font.BOLD, 18));

		headerPanel.add(lblTurn);
		headerPanel.add(lblP1Choice);
		headerPanel.add(lblP2Choice);


        // Adding panels to the main window
        add(headerPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
        // pack();

        // Visibility of window
        setVisible(true);

			
	}
}