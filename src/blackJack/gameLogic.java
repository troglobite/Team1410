package blackJack;

import javax.swing.ImageIcon;

public class gameLogic {
	
	private static Deck deck = new Deck();
	private static Deck playerCards = new Deck();
	private static Deck computerCards = new Deck();
	
	static int playerHand = 0;
	static int computerHand = 0;
	static Card playerCard;
	static Card computerCard;

	public gameLogic() {
		playerCards.clearDeck();
		computerCards.clearDeck();
	}

	public Card cardInfo(String current){
		if(current.equals("player")){
			playerCard = deck.draw();
			playerCards.addCard(playerCard);
			return playerCard;
		}else{
			computerCard = deck.draw();
			computerCards.addCard(computerCard);
			return computerCard;
		}
	}
	
	public ImageIcon placeCard(Card userCard) {
		String cardRank = userCard.getRank().toString();
		String cardSuite = userCard.getSuite().toString();
		StringBuilder sb = new StringBuilder();
		sb.append("/res/" + cardRank.toLowerCase() + "_of_" + cardSuite.toLowerCase() + ".png");
		String fileLocation = sb.toString();
		return new ImageIcon(gameLogic.class.getResource(fileLocation));
	}
	
	public String generateHandTotal(String user) {
		playerHand = 0;
		computerHand = 0;
		
		if(user.equals("player")) {
			playerCards.reverseOrder();
			for(Card el : playerCards) {
				// Checks for the ace rank.
				if(el.getRank().getValue() == 1) {
					// Checks whether or not ace should be alt value of 11.
					if(playerHand + el.getRank().getValueAlt() > 21) {
						playerHand += el.getRank().getValue();
					} else {
						playerHand += el.getRank().getValueAlt();
					}
				} else {
					playerHand += el.getRank().getValue();
				}
			}
			return String.valueOf(playerHand);
		} else {
			computerCards.reverseOrder();
			for(Card el : computerCards) {
				// Checks for ace rank.
				if(el.getRank().getValue() == 1) {
					// Checks whether or not ace should be alt value of 11.
					if(computerHand + el.getRank().getValueAlt() > 21) {
						computerHand += el.getRank().getValue();
					} else {
						computerHand += el.getRank().getValueAlt();
					}
				} else {
					computerHand += el.getRank().getValue();
				}
			}
			return String.valueOf(computerHand);
		}
		
	}
	
	public static void resetGame() {
		deck = new Deck();
		playerCards.clearDeck();
		computerCards.clearDeck();
		playerHand = 0;
		computerHand = 0;
		playerCard = null;
		computerCard = null;
	}
	
	
	
}
