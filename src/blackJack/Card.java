package blackJack;

public class Card {
	private RankEnum rank;
	private SuiteEnum suite;
	
	public Card(SuiteEnum s, RankEnum r){
		this.suite = s;
		this.rank = r;
	}
	
	public SuiteEnum getSuite(){
		return suite;
	}
	public RankEnum getRank(){
		return rank;
	}
	
	
	@Override
	public String toString(){
		return rank + " of " + suite;
	}
}
