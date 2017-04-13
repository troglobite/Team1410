package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gameLogic {
	
	Deck deck = new Deck();
	int playerHand = 0;
	int computerHand = 0;
	Card playerCard;
	Card computerCard;

	public gameLogic() {
		//test comment
		
	}

	public String cardInfo(String current){
		if(current.equals("player")){
			playerCard = deck.draw();
			return playerCard.toString();
		}else{
			computerCard = deck.draw();
			return computerCard.toString();
		}
	}
	public String updatePlayerHand(){
		playerHand += playerCard.getRank().getValue();
		return String.valueOf(playerHand);
	}
	
	public String updateComputerHand(){
		computerHand += computerCard.getRank().getValue();
		return String.valueOf(computerHand);
	}
}
