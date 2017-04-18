package blackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card> {
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
		//always shuffle twice
		Collections.shuffle(deck);
		Collections.shuffle(deck);
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
	
	public void clearDeck() {
		deck.clear();
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}

	@Override
	public Iterator<Card> iterator() {
		Iterator<Card> iCard = deck.iterator();
		return iCard;
	}
	
	Comparator<Card> comparator = new Comparator<Card>() {
		@Override
		public int compare(Card c1, Card c2) {
			return c1.getRank().toString().toLowerCase().compareTo(c2.getRank().toString().toLowerCase());
		}
	};
	
	
	public void reverseOrder() {
		Collections.sort(deck, Collections.reverseOrder(comparator));
	}
}
