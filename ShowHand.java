import java.util.LinkedList;
import java.util.Collections;

public class ShowHand{

	//定义花色
	static final String[] TYPES = new String[]{"方块","草花","红心","黑桃"};

	//定义牌面值
	static final String[] VALUES = new String[]
		{"2","3","4","5",
		 "6","7","8","9",
		 "10","J","Q","K","A" };

	//游戏最多玩家数量：5名
	static final int MAX_PLAYER_NUMS = 5;	

	//最少(小)玩家数量：2名
	static final int MIN_PLAYER_NUMS = 2; 

	//用于存放桌面上的牌
	private LinkedList<String> cards = new LinkedList<>();	 

	private String[] playerNames = new String[MAX_PLAYER_NUMS];

	public static void main(String[] args) {
		ShowHand suoha = new ShowHand();
		suoha.initCard();

	}

	//该方法用于模拟“洗牌”
	private void initCard(){
		//先把"桌上"的牌全部清空
		cards.clear();

		for(int i = 0; i < TYPES.length; i++){
			for(int j = 0; j < VALUES.length;j++){
				cards.add(TYPES[i] + VALUES[j]);
			}
		}

		//洗牌
		Collections.shuffle(cards);

		// System.out.println(cards);
		// System.out.println(cards.pop());
	}

	private int initPlayers(String... names){
		if(name.length > MAX_PLAYER_NUMS ||
			names.length < MIN_PLAYER_NUMS){

		}
	}

}