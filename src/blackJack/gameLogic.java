package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public String cardInfo(String current){
		if(current.equals("player")){
			playerCard = deck.draw();
			playerCards.addCard(playerCard);
			return playerCard.toString();
		}else{
			computerCard = deck.draw();
			computerCards.addCard(computerCard);
			return computerCard.toString();
		}
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
