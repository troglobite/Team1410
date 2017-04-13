package blackJack;

public enum RankEnum {
	TWO(2, 0), 
	THREE(3, 0), 
	FOUR(4, 0), 
	FIVE(5, 0), 
	SIX(6, 0), 
	SEVEN(7, 0), 
	EIGHT(8, 0), 
	NINE(9, 0), 
	TEN(10, 0), 
	JACK(10, 0), 
	QUEEN(10, 0), 
	KING(10, 0), 
	ACE(1, 11);	
	
	private int value, valueAlt;
	
	RankEnum(int value, int valueAlt){
		this.value = value;
		this.valueAlt = valueAlt;
	}
	
	public int getValue(){
		return value;
	}
	public int getValueAlt(){
		return valueAlt;
	}
}
