package comp2396.asm3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The MainFrame class represents the graphical user interface for the card game.
 * 
 * It extends JFrame and contains JLabels, JButtons,
 * JTextFields, JMenuItems, and a JMenuBar.
 * 
 * @author Chan Yat Fu
 * @version 1.0
 * @since 2023-04-18
 */
public final class MainFrame extends JFrame {
	
	private final boolean debug = false;
	Assets assets = new Assets();
	private static final long serialVersionUID = 1L;
	private JLabel dealerCardImage[] = new JLabel[3];
	private JLabel playerCardImage[] = new JLabel[3];
	private JButton replaceCardButton[] = new JButton[3];;
	private JButton startButton;
	private JButton resultButton;
	private JMenuItem exitItem;
	private JTextField betAmount;
	private JLabel infoLabel;
	
	private Integer moneyHave;
	private Deck deck;
	
	
	/**
	 * Constructs a MainFrame object.
	 * Initializes the GUI and initializes variables.
	 */
	public MainFrame()
	{
		
		moneyHave = 100;
		
		this.setTitle("GUI Card Game");
		this.setSize(440,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.add(mainPanel);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu controlMenu = new JMenu("Control");
		exitItem = new JMenuItem("Exit");
		this.setJMenuBar(menuBar);
		menuBar.add(controlMenu);
		controlMenu.add(exitItem);
		
		
		JPanel dealerPanel = new JPanel();
		dealerPanel.setPreferredSize(new Dimension(this.getWidth(), 40));
		dealerPanel.setBackground(Color.GREEN);
		dealerCardImage[0] = new JLabel(assets.getCardBack());
		dealerCardImage[1] = new JLabel(assets.getCardBack());
		dealerCardImage[2] = new JLabel(assets.getCardBack());
		mainPanel.add(dealerPanel);
		dealerPanel.add(dealerCardImage[0]);
		dealerPanel.add(dealerCardImage[1]);
		dealerPanel.add(dealerCardImage[2]);
		
		
		JPanel playerPanel = new JPanel();
		playerPanel.setPreferredSize(new Dimension(this.getWidth(), 40));
		playerPanel.setBackground(Color.GREEN);
		playerCardImage[0] = new JLabel(assets.getCardBack());
		playerCardImage[1] = new JLabel(assets.getCardBack());
		playerCardImage[2] = new JLabel(assets.getCardBack());
		mainPanel.add(playerPanel);
		playerPanel.add(playerCardImage[0]);
		playerPanel.add(playerCardImage[1]);
		playerPanel.add(playerCardImage[2]);
		
		
		JPanel replaceCardButtonPanel = new JPanel();
		playerPanel.setPreferredSize(new Dimension(this.getWidth(), 40));
		replaceCardButtonPanel.setBackground(Color.GREEN);
		replaceCardButton[0] = new JButton("Replace Card 1");
		replaceCardButton[1] = new JButton("Replace Card 2");
		replaceCardButton[2] = new JButton("Replace Card 3");
		replaceCardButton[0].setEnabled(false);
		replaceCardButton[1].setEnabled(false);
		replaceCardButton[2].setEnabled(false);
		mainPanel.add(replaceCardButtonPanel);
		replaceCardButtonPanel.add(replaceCardButton[0]);
		replaceCardButtonPanel.add(replaceCardButton[1]);
		replaceCardButtonPanel.add(replaceCardButton[2]);
		
		
		JPanel betPanel = new JPanel();
		betPanel.setPreferredSize(new Dimension(this.getWidth(), 20));
		JLabel bet = new JLabel("Bet: $");
        betAmount = new JTextField(10);
		
		startButton = new JButton("Start");
		resultButton = new JButton("Result");
		resultButton.setEnabled(false);
		mainPanel.add(betPanel);
		betPanel.add(bet);
		betPanel.add(betAmount);
		betPanel.add(startButton);
		betPanel.add(resultButton);
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(this.getWidth(), 20));
		infoLabel = new JLabel();
		final String yourBet = "Please place your bet! ";
		final String moneyYouHave = "Amount of Money you have: $";
		infoLabel.setText(yourBet + moneyYouHave + moneyHave);
		mainPanel.add(infoPanel);
		infoPanel.add(infoLabel);
		
		replaceCardButton[0].addActionListener(new ReplaceCardButtonListener(0));
		replaceCardButton[1].addActionListener(new ReplaceCardButtonListener(1));
		replaceCardButton[2].addActionListener(new ReplaceCardButtonListener(2));
		startButton.addActionListener(new StartButtonListener());
		resultButton.addActionListener(new ResultButtonListener());
		exitItem.addActionListener(new ExitItemListener());
		
	}
	
	
	/**
	 * Returns the amount of money the player currently has.
	 * @return the amount of money the player currently has
	 */
	public Integer getMoneyHave()
	{
		return this.moneyHave;
	}
	
	
	/**
	 * Sets the image of the specified card for the dealer or player.
	 * @param dealerPlayer an enum representing whether the card belongs to
	 * the dealer or player
	 * @param cardNum the index of the card in the player or dealer's hand
	 */
	private void setCardImage(DealerPlayer dealerPlayer, Integer cardNum, Integer[] cardVal)
	{
		try {
			if (dealerPlayer == DealerPlayer.DEALER) {
				this.dealerCardImage[cardNum].setIcon(assets.getCard(cardVal[0], cardVal[1]));
			} else if (dealerPlayer == DealerPlayer.PLAYER) {
				this.playerCardImage[cardNum].setIcon(assets.getCard(cardVal[0], cardVal[1]));
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Sets the card image of the given dealer player and card number to a card back image.
	 * @param dealerPlayer The dealer or player whose card image is to be set.
	 * @param cardNum The number of the card whose image is to be set.
	 * @param zero This parameter is not used in this method.
	 * @throws IllegalArgumentException If the value of zero is not equal to 0 or dealerPlayer is neither Dealer nor Player.
	 */
	private void setCardImage(DealerPlayer dealerPlayer, Integer cardNum, Integer zero)
	{
		try {
			if (zero == 0) {
				if (dealerPlayer == DealerPlayer.DEALER) {
					this.dealerCardImage[cardNum].setIcon(assets.getCardBack());
				}
				 else if (dealerPlayer == DealerPlayer.PLAYER) {
					 this.playerCardImage[cardNum].setIcon(assets.getCardBack());
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Private inner class for handling the replace card button actions.
	 */
	private class ReplaceCardButtonListener implements ActionListener
	{
		/**
		 * Constructs a new ReplaceCardButtonListener object with the given card number.
		 * @param cardNumber the number of the card button to replace
		 */
	    public ReplaceCardButtonListener(int cardNumber)
	    {
	    	
	    }
	    
	    
	    /**
	     * Performs the necessary action when a replace card button is clicked.
	     * @param e the ActionEvent object associated with the button click
	     */
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        if (e.getSource() == replaceCardButton[0]) {
	        	actionPerformedHelp(0);
	        } else if (e.getSource() == replaceCardButton[1]) {
	        	actionPerformedHelp(1);
	        } else if (e.getSource() == replaceCardButton[2]) {
	        	actionPerformedHelp(2);
	        }
	    }
	    
	    
	    /**
	     * Performs the necessary action for replacing the corresponding card.
	     * @param buttonNum the number of the card button to replace
	     */
	    private void actionPerformedHelp(Integer buttonNum)
	    {
        	deck.addReplacedCount();
        	Integer replacedCount = deck.getReplacedCount();
	    	if (replacedCount == 1) {
	    		deck.replacePlayerCard(buttonNum);
	    		setCardImage(DealerPlayer.PLAYER, buttonNum, deck.getPlayerCard(buttonNum));
	    		replaceCardButton[buttonNum].setEnabled(false);
	    	} else if (replacedCount == 2) {
	    		deck.replacePlayerCard(buttonNum);
	    		setCardImage(DealerPlayer.PLAYER, buttonNum, deck.getPlayerCard(buttonNum));
	    		replaceCardButton[0].setEnabled(false);
	    		replaceCardButton[1].setEnabled(false);
	    		replaceCardButton[2].setEnabled(false);
	    	} else {
	    		System.out.println("BIG TROUBLE!!!!!!!!!!!!!!!!!!!!");
	    	}
	    	
	    	if (debug) {
	    		System.out.println("(replaceCardButton[" + buttonNum + "]) clicked");
	    		System.out.println("(replaceCardButton[" + buttonNum + "]) replacedCount: " + replacedCount);
	    	}
	    }
	}
	
	
	/**
	 * This class implements ActionListener interface to handle the action events
	 * performed on the startButton.
	 */
	private class StartButtonListener implements ActionListener
	{
		/**
		 * Constructor of the StartButtonListener class.
		 */
	    public StartButtonListener()
	    {
	        
	    }
	    
	    
	    /**
	     * This method is called when an action event is generated by startButton.
	     * It validates the bet entered by the player and sets the initial cards and
	     * button states. It also enables the action events for replace and result buttons.
	     * @param e the action event generated by the startButton
	     */
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        if (debug) System.out.println("[startButton] clicked");
	        if (betAmount.getText().length() == 0) {
	        	if (debug) System.out.println("(betTextField) No text entered.");
	        	JOptionPane.showMessageDialog(
	        			null,
	        			"Please enter bet.",
	        			"Warning",
	        			JOptionPane.WARNING_MESSAGE);
	        } else if (!betAmount.getText().matches("\\d+")) {
	        	if (debug) System.out.println("(betTextField) non-number entered.");
	        	JOptionPane.showMessageDialog(
	        			null,
	        			"Please enter number only.",
	        			"Warning",
	        			JOptionPane.WARNING_MESSAGE);
	        } else if (Integer.parseInt(betAmount.getText()) > MainFrame.this.getMoneyHave()) {
	        	if (debug) System.out.println("(betTextField) Not enough money.");
	        	JOptionPane.showMessageDialog(
	        			null,
	        			"Not enough money.",
	        			"Warning",
	        			JOptionPane.WARNING_MESSAGE);
	        } else {
	        	if (debug) System.out.println("(betTextField) All checking passed.");
	        	replaceCardButton[0].setEnabled(true);
	        	replaceCardButton[1].setEnabled(true);
	        	replaceCardButton[2].setEnabled(true);
	        	resultButton.setEnabled(true);
	        	startButton.setEnabled(false);
	        	betAmount.setEnabled(false);
	        	deck = new Deck();
	        	setCardImage(DealerPlayer.DEALER, 0, 0);
	        	setCardImage(DealerPlayer.DEALER, 1, 0);
	        	setCardImage(DealerPlayer.DEALER, 2, 0);
	        	setCardImage(DealerPlayer.PLAYER, 0, deck.getPlayerCard(0));
	        	setCardImage(DealerPlayer.PLAYER, 1, deck.getPlayerCard(1));
	        	setCardImage(DealerPlayer.PLAYER, 2, deck.getPlayerCard(2));
	        	infoLabel.setText("You current bet is: $" + betAmount.getText()
	        			+ " Amount of money you have: $" + moneyHave);
	        }
	    }
	}
	
	
	/**
	 * Private class implementing ActionListener interface to handle
	 * the result button click event.
	 */
	private class ResultButtonListener implements ActionListener
	{
		/*
		 * Constructs a ResultButtonListener object.
		 */
	    public ResultButtonListener()
	    {
	        
	    }
	    
	    
	    /**
	     * Invoked when the result button is clicked. Performs the necessary action to
	     * show the result of the game.
	     * 
	     * Checks the player's card value and displays the corresponding message if they
	     * win or lose.
	     * Enables the start button and bet text field for the next round, and updates
	     * the amount of money the player has.
	     * If the player has no money left, disables the start button and bet text field
	     * and displays a game over message.
	     * 
	     * @param e the ActionEvent object representing the result button click event
	     */
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        if (debug) {
	        	System.out.println("(resultButton) clicked");
	        	System.out.println("Dealer card:"
	        			+ deck.cardToString(DealerPlayer.DEALER, 0) + "; "
	        			+ deck.cardToString(DealerPlayer.DEALER, 1) + "; "
	        			+ deck.cardToString(DealerPlayer.DEALER, 2) + "\n");
	        	System.out.println("Player card:"
	        			+ deck.cardToString(DealerPlayer.PLAYER, 0) + "; "
	        			+ deck.cardToString(DealerPlayer.PLAYER, 1) + "; "
	        			+ deck.cardToString(DealerPlayer.PLAYER, 2) + "\n");
	        }
        	replaceCardButton[0].setEnabled(false);
        	replaceCardButton[1].setEnabled(false);
        	replaceCardButton[2].setEnabled(false);
	        resultButton.setEnabled(false);
        	setCardImage(DealerPlayer.DEALER, 0, deck.getDealerCard(0));
        	setCardImage(DealerPlayer.DEALER, 1, deck.getDealerCard(1));
        	setCardImage(DealerPlayer.DEALER, 2, deck.getDealerCard(2));
	        Integer bet = Integer.parseInt(betAmount.getText());
	        if (deck.checkPlayerCardValueWin()) {
	        	moneyHave += bet;
	        	startButton.setEnabled(true);
	        	betAmount.setEnabled(true);
	        	infoLabel.setText("Please place your bet! "
	        			+ "Amount of money you have: $" + moneyHave);
	        	JOptionPane.showMessageDialog(
	        			null,
	        			"Congrauations! You win this round!",
	        			"Warning",
	        			JOptionPane.WARNING_MESSAGE);
	        } else {
	        	if (moneyHave > bet) {
		        	moneyHave -= bet;
		        	startButton.setEnabled(true);
		        	betAmount.setEnabled(true);
		        	infoLabel.setText("Please place your bet! "
		        			+ "Amount of money you have: $" + moneyHave);
		        	JOptionPane.showMessageDialog(
		        			null,
		        			"Sorry! The dealer wins this round!",
		        			"Warning",
		        			JOptionPane.WARNING_MESSAGE);
	        	} else {
	        		moneyHave = 0;
	        		infoLabel.setText("You have no more money! Please start a new game!");
		        	JOptionPane.showMessageDialog(
		        			null,
		        			"Game over!\n"
		        			+ "You have no more money!\n"
		        			+ "Please start a new game!",
		        			"Warning",
		        			JOptionPane.WARNING_MESSAGE);
	        	}
	        }
	    }
	}
	
	
	/**
	 * ActionListener for the "Exit" menu item.
	 * Terminates the application when the "Exit" menu item is clicked.
	 */
	private class ExitItemListener implements ActionListener
	{ 
		/*
		 * Constructs a new ExitItemListener object.
		 */
	    public ExitItemListener()
	    {
	        
	    }
	    
	    
	    /**
	     * Invoked when an action occurs.
	     * Terminates the application when the "Exit" menu item is clicked.
	     * @param e the action event that occurred
	     */
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        if (debug) System.out.println("(exitItem) clicked");
	        System.exit(0);
	    }
	}
	
}
