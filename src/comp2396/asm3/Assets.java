package comp2396.asm3;
import javax.swing.ImageIcon;

/**
 * The Assets class provides the card images and card back image required for a card game.
 * 
 * @author Chan Yat Fu
 * @version 1.0
 * @since 2023-04-18
 */
public final class Assets {
	
	private ImageIcon[][] cards;
	private ImageIcon card_back;
	
	/**
	 * Constructs an Assets object and initializes the card images and card back image.
	 */
	public Assets()
	{
		this.cards = new ImageIcon[4][14];
		this.card_back = new ImageIcon("assets/card_back.gif");
		
		// Clubs
		this.cards[0][1]  = new ImageIcon("assets/card_11.gif");
		this.cards[0][2]  = new ImageIcon("assets/card_12.gif");
		this.cards[0][3]  = new ImageIcon("assets/card_13.gif");
		this.cards[0][4]  = new ImageIcon("assets/card_14.gif");
		this.cards[0][5]  = new ImageIcon("assets/card_15.gif");
		this.cards[0][6]  = new ImageIcon("assets/card_16.gif");
		this.cards[0][7]  = new ImageIcon("assets/card_17.gif");
		this.cards[0][8]  = new ImageIcon("assets/card_18.gif");
		this.cards[0][9]  = new ImageIcon("assets/card_19.gif");
		this.cards[0][10]  = new ImageIcon("assets/card_110.gif");
		this.cards[0][11] = new ImageIcon("assets/card_111.gif");
		this.cards[0][12] = new ImageIcon("assets/card_112.gif");
		this.cards[0][13] = new ImageIcon("assets/card_113.gif");
		
		// Diamonds
		this.cards[1][1]  = new ImageIcon("assets/card_31.gif");
		this.cards[1][2]  = new ImageIcon("assets/card_32.gif");
		this.cards[1][3]  = new ImageIcon("assets/card_33.gif");
		this.cards[1][4]  = new ImageIcon("assets/card_34.gif");
		this.cards[1][5]  = new ImageIcon("assets/card_35.gif");
		this.cards[1][6]  = new ImageIcon("assets/card_36.gif");
		this.cards[1][7]  = new ImageIcon("assets/card_37.gif");
		this.cards[1][8]  = new ImageIcon("assets/card_38.gif");
		this.cards[1][9]  = new ImageIcon("assets/card_39.gif");
		this.cards[1][10]  = new ImageIcon("assets/card_310.gif");
		this.cards[1][11] = new ImageIcon("assets/card_311.gif");
		this.cards[1][12] = new ImageIcon("assets/card_312.gif");
		this.cards[1][13] = new ImageIcon("assets/card_313.gif");
		
		// Hearts
		this.cards[2][1]  = new ImageIcon("assets/card_41.gif");
		this.cards[2][2]  = new ImageIcon("assets/card_42.gif");
		this.cards[2][3]  = new ImageIcon("assets/card_43.gif");
		this.cards[2][4]  = new ImageIcon("assets/card_44.gif");
		this.cards[2][5]  = new ImageIcon("assets/card_45.gif");
		this.cards[2][6]  = new ImageIcon("assets/card_46.gif");
		this.cards[2][7]  = new ImageIcon("assets/card_47.gif");
		this.cards[2][8]  = new ImageIcon("assets/card_48.gif");
		this.cards[2][9]  = new ImageIcon("assets/card_49.gif");
		this.cards[2][10]  = new ImageIcon("assets/card_410.gif");
		this.cards[2][11] = new ImageIcon("assets/card_411.gif");
		this.cards[2][12] = new ImageIcon("assets/card_412.gif");
		this.cards[2][13] = new ImageIcon("assets/card_413.gif");
		
		// Spades
		this.cards[3][1]  = new ImageIcon("assets/card_21.gif");
		this.cards[3][2]  = new ImageIcon("assets/card_22.gif");
		this.cards[3][3]  = new ImageIcon("assets/card_23.gif");
		this.cards[3][4]  = new ImageIcon("assets/card_24.gif");
		this.cards[3][5]  = new ImageIcon("assets/card_25.gif");
		this.cards[3][6]  = new ImageIcon("assets/card_26.gif");
		this.cards[3][7]  = new ImageIcon("assets/card_27.gif");
		this.cards[3][8]  = new ImageIcon("assets/card_28.gif");
		this.cards[3][9]  = new ImageIcon("assets/card_29.gif");
		this.cards[3][10]  = new ImageIcon("assets/card_210.gif");
		this.cards[3][11] = new ImageIcon("assets/card_211.gif");
		this.cards[3][12] = new ImageIcon("assets/card_212.gif");
		this.cards[3][13] = new ImageIcon("assets/card_213.gif");
	}
	
	/**
	 * Returns the ImageIcon representing a card with the specified suit
	 * and face value from the deck of cards.
	 * 
	 * @param suit the suit of the card to get (0-3, where 0=Spades, 1=Hearts,
	 * 2=Clubs, and 3=Diamonds)
	 * @param faceValue the face value of the card to get (0-12, where 0=Ace,
	 * 1=2, 2=3, ..., 9=10, 10=Jack, 11=Queen, and 12=King)
	 * @return the ImageIcon representing the card with the specified suit and face value
	 */
	public ImageIcon getCard(int suit, int faceValue)
	{
		return this.cards[suit][faceValue];
	}
	
	
	/**
	 * Returns the ImageIcon representing the back of a card.
	 * @return the ImageIcon representing the back of a card
	 */
	public ImageIcon getCardBack()
	{
		return this.card_back;
	}

}
