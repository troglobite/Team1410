package blackJack;

import javax.swing.ImageIcon;

public class gameLogic {
	
	Deck deck = new Deck();
	Deck playerCards = new Deck();
	Deck computerCards = new Deck();
	
	int playerHand = 0;
	int computerHand = 0;
	Card playerCard;
	Card computerCard;

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
		sb.append("res/" + cardRank.toLowerCase() + "_of_" + cardSuite.toLowerCase());
		String fileLocation = sb.toString();
		System.out.println(fileLocation);
		return new ImageIcon(fileLocation);
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
}
