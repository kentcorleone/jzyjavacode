import java.util.List;
import java.util.LinkedList;

public class CardsInHand implements Comparable<CardsInHand>{

	//梭哈中牌型的大小
	private static final String[] suohaRanking = {"散牌","一对","二对","三条","顺子",
													"同花","fullhouse","四条","同花顺"};

	//一个玩家拿在手上的所有牌
	private List<Card> cards = new LinkedList<>();

	public CardsInHand(List<Card> cards){
		this.cards = cards;
	}

	public void add(Card card){
		cards.add(card);
	}

	public Card get(int index){
		return cards.get(index);
	}

	public int size(){
		return cards.size();
	}

	public void clear(){
		cards.clear();
	}

	public int compareTo(CardsInHand other){
		//梭哈牌大小的比较，首先比较的是牌型,
		//拥有更大牌型的更大

		//现在需要一个方法，能够在牌中判断牌型
	}

	//这个方法判断玩家手上的牌是否有牌型，有的话是什么
	public static getCardsKind(CardsInhand cards){
		
	}
}