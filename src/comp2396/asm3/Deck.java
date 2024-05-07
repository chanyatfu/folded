package comp2396.asm3;
import java.util.*;

/**
 * Represents a deck of cards.
 * 
 * @author	Chan Yat Fu
 * @version	1.0
 * @since	2023-04-18
 */
public final class Deck
{
	private Boolean drawn[][] = new Boolean[4][14];
	private Integer dealerCards[][] = new Integer[3][2];
	private Integer playerCards[][] = new Integer[3][2];
	private int replacedCount = 0;


	/**
	 * Constructor for Deck class.
	 * Initializes the deck with 3 cards for both player and dealer.
	 * Keeps track of drawn cards.
	 */
	public Deck()
	{
		for(int i = 0; i < drawn.length; i++) {
		    Arrays.fill(drawn[i], false);
		}
		
		Random random = new Random();
		Integer dealerDrawnCards = 0;
		while (dealerDrawnCards < 3) {
			Integer suit = random.nextInt(4);
			Integer faceValue = random.nextInt(13) + 1;
			if (drawn[suit][faceValue] == false) {
				dealerCards[dealerDrawnCards] = new Integer[] {suit, faceValue};
				drawn[suit][faceValue] = true;
				dealerDrawnCards++;
			}
		}
		Integer playerDrawnCards = 0;
		while (playerDrawnCards < 3) {
			Integer suit = random.nextInt(4);
			Integer faceValue = random.nextInt(13) + 1;
			if (drawn[suit][faceValue] == false) {
				playerCards[playerDrawnCards] = new Integer[] {suit, faceValue};
				drawn[suit][faceValue] = true;
				playerDrawnCards++;
			}
		}
	}
	
	
	/**
	 * Returns the dealer's card.
	 * @param cardNum The number of the card (0, 1, or 2).
	 * @return An array representing the card (suit and face value).
	 */
	public Integer[] getDealerCard(Integer cardNum)
	{
		return dealerCards[cardNum];
	}
	
	
	/**
	 * Returns the player's card.
	 * @param cardNum The number of the card (0, 1, or 2).
	 * @return An array representing the card (suit and face value).
	 */
	public Integer[] getPlayerCard(Integer cardNum)
	{
		return playerCards[cardNum];
	}
	
	
	/**
	 * Returns all of the dealer's cards.
	 * @return A 2D array representing all of the dealer's cards.
	 */
	public Integer[][] getAllDealerCards()
	{
		return dealerCards;
	}
	
	
	/**
	 * Returns all of the player's cards.
	 * @return A 2D array representing all of the player's cards.
	 */
	public Integer[][] getAllPlayerCards()
	{
		return playerCards;
	}
	
	
	/**
	 * Returns the number of replaced cards.
	 * @return The number of replaced cards.
	 */
	public Integer getReplacedCount()
	{
		return replacedCount;
	}
	
	
	/**
	 * Adds 1 to the number of replaced cards.
	 */
	public void addReplacedCount()
	{
		replacedCount += 1;
	}
	
	
	/**
	 * Resets the number of replaced cards to 0.
	 */
	public void resetReplacedCount()
	{
		replacedCount = 0;
	}
	
	
	/**
	 * This method returns a String representation of a given card,
	 * identified by its card number and the player it belongs to.
	 * @param dealerPlayer An enum representing the player type - whether it's
	 * the dealer or the player.
	 * @param cardNum An Integer representing the card number.
	 * @return A String representing the card, in the format of "FACE_VALUE of SUIT".
	 */
	public String cardToString(DealerPlayer dealerPlayer, Integer cardNum)
	{
		String token = "";
		if (dealerPlayer == DealerPlayer.DEALER) {
			token += dealerCards[cardNum][1];
			token += " of ";
			token += Suit.values()[dealerCards[cardNum][0]].toString();
		} else {
			token += playerCards[cardNum][1];
			token += " of ";
			token += Suit.values()[playerCards[cardNum][0]].toString();
		}
		return token;
	}
	
	
	/**
	 * This method replaces a player's card in the deck with a new card generated randomly.
	 * @param cardNum An Integer representing the card number that needs to be replaced.
	 */
	public void replacePlayerCard(Integer cardNum)
	{
		Random random = new Random();
		Boolean set = false;
		while (set == false) {
			Integer suit = random.nextInt(4);
			Integer faceValue = random.nextInt(13) + 1;
			if (this.drawn[suit][faceValue] == false) {
				playerCards[cardNum] = new Integer[] {suit, faceValue};
				drawn[suit][faceValue] = true;
				set = true;
			}
		}
	}
	
	
	/**
	 * Calculates whether the player has won the game by comparing their
	 * card values with the dealer's cards.
	 * 
	 * The method compares the number of special cards (cards with face value
	 * greater than or equal to 11) and the sum of face values of cards of both
	 * the player and the dealer.
	 * 
	 * If the number of special cards of the player is greater than or equal to
	 * that of the dealer, and the sum of face values of the player's cards modulo
	 * 10 is greater than that of the dealer's cards modulo 10, then the player wins.
	 * Otherwise, the dealer wins
	 * 
	 * @return a boolean value indicating whether the player has won or not.
	 * True if the player has won, false otherwise.
	 */
	public Boolean checkPlayerCardValueWin()
	{
		Integer dealerSpecialCardCount = 0;
		Integer playerSpecialCardCount = 0;
		Integer dealerFaceValueSum = 0;
		Integer playerFaceValueSum = 0;
		for (Integer i = 0; i < 3; ++i) {
			if (dealerCards[i][1] >= 11) {
				dealerSpecialCardCount++;
			}
			if (playerCards[i][1] >= 11) {
				playerSpecialCardCount++;
			}
			dealerFaceValueSum += dealerCards[i][1];
			playerFaceValueSum += playerCards[i][1];
		}
		if (dealerSpecialCardCount > playerSpecialCardCount) {
			return false;
		} else if (dealerSpecialCardCount < playerSpecialCardCount) {
			return true;
		} else {
			
			if (dealerFaceValueSum % 10 >= playerSpecialCardCount % 10) {
				return false;
			} else {
				return true;
			}
			
		}
	}

}
