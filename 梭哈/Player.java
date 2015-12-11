public class Player{


	//玩家手中最多拥有5张手牌
	static final int MAX_CARDS_IN_HAND = 5;

	//初始筹码值
	final int BEGIN_CHIP = 3000;	

	//初始玩家姓名
	static String beginName = "金泽扬";	

	//玩家姓名
	private String name;

	//玩家手中的初始筹码
	private int chip;

	//玩家手中最多拥有5张手牌
	// private List<Card> playerCards = new LinkedList<>(8);

	public Player(){
		this.name = beginName;
		this.chip = BEGIN_CHIP;
	}

	public Player(String name){
		this.name = name;
		this.chip = BEGIN_CHIP;
	}

	public String getName(){
		return this.name;
	}

	public void changeChips(int amount){
		chip += amount;
	}

	public int getChip(){
		return this.chip;
	}



}