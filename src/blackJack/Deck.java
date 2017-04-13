package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<Card>();
	
	//building the deck
	public Deck(){
		//for loop iterates through each rank enum inside each suite enum
		//then adds the a new card to the deck List
		for(SuiteEnum suite: SuiteEnum.values()){
			for(RankEnum rank: RankEnum.values()){
				deck.add(new Card(suite, rank));
			}
		}
	}
	
	public Card draw(){
		Card drawnCard = null;
		if(deck.size() > 0){
			drawnCard = deck.get(deck.size() - 1);
			deck.remove(deck.size() - 1);
		}else{
			System.out.println("Deck Empty");
		}
		return drawnCard;
	}
}
