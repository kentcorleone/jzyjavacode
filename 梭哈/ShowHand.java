import java.util.LinkedList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class ShowHand{

	//游戏最多玩家数量：5名
	static final int MAX_PLAYER_NUMS = 5;		

	//最少玩家数量：2名
	static final int MIN_PLAYER_NUMS = 2;	

	//游戏继续条件
	static boolean gameEndCondition = false;

	//一轮结束条件
	static boolean oneTurnEndCondition = false;

	//定义一个数组来保存我们最多的5个玩家的名字
	// private String[] playerNames = new String[MAX_PLAYER_NUMS];

	//用于存放桌面上的牌
	private LinkedList<Card> cards = new LinkedList<>();

	//定义一个数组来保存我们最多的5个玩家的信息
	private List<Player> playerInformation = new LinkedList<>();

	//定义一个List数组来保存最多5个玩家的手上的牌
	private List<CardsInHand> playerCards = new LinkedList<>();

	//定义每个用户的筹码，最多保存5个玩家的筹码
	// private int[] playerChips = new int[MAX_PLAYER_NUMS];

	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.initCard();
		sh.initPlayers("ziji","baig","nium");
		// System.out.println(Arrays.toString(sh.playerNames));
		while(!gameEndCondition){

			while(!oneTurnEndCondition){

				sh.deliverCard(0); 			//派一轮牌
				sh.deliverCard(0); 			//派一轮牌
				sh.showPlayerStatus(); 		//显示最先发的两张牌,和筹码情况

				sh.bidingProcess(sh); 		//下注过程
			}

			sh.oneTurnSettle(sh);



			// sh.deliverCard(sh.compareCard(true));	//根据当前明牌的大小，从最大的发起
			// sh.showPlayerStatus();		//再次显示目前的情况,牌型和筹码	

			// sh.compareCard(true);

			// Card c1 = new Card("红心","K");
			// Card c2 = new Card("黑桃","Q");

			// System.out.println(c1.compareTo(c2));
		}


	}


	private void bidingProcess(ShowHand sh){

		//桌面上下注的钱
		int bidingMoney = 0;

		//每轮的基本轮钱
		int forgeitMoney = 0;


		for(int i = 0; i < 3; i++){

				Scanner sc = new Scanner(System.in);	
				forgeitMoney = 100 * (1 + i);						

			//非最后一轮
			if(i != 2){


				int maxIndex = sh.compareCard(true);
			

				System.out.println("-------------------第 " + (i+1) + " 轮-------------------");
				System.out.println("----------------当前场上筹码：" + bidingMoney + " -----------------");
				System.out.println("--------------当前一轮的基本底注是：" + forgeitMoney + " ------------------");

				//我的牌面最大
				if(maxIndex == 0){
					System.out.print("您的牌面最大，请下注: ");
					int bid = Integer.parseInt(sc.nextLine());
					System.out.println("我下注： " + bid);
					for(int j = 0; j < playerInformation.size(); j++){
						playerInformation.get(j).changeChips(-bid);
						playerInformation.get(j).changeChips(-forgeitMoney);
						bidingMoney += bid;
						bidingMoney += forgeitMoney;
					}

				}
				else{
					int bid = ThreadLocalRandom.current().nextInt(200,1000);

					System.out.println(sh.playerInformation.get(maxIndex).getName() + "下注"
						+ bid
						+ " ,您是否跟住？跟住输入Y，其他放弃");

					String flag = sc.nextLine();
					//表明用户放弃该轮投注
					if(!flag.equalsIgnoreCase("y")){
						// sh.playerChips[0] -= bid;
						//该轮的基本轮钱没有了
						playerInformation.get(0).changeChips(-forgeitMoney);
						bidingMoney += forgeitMoney;
						oneTurnEndCondition = true;
						break;
					}
					else{ //跟住的情况
						for(int j = 0; j < playerInformation.size(); j++){
							playerInformation.get(j).changeChips(-bid);
							playerInformation.get(j).changeChips(-forgeitMoney);
							bidingMoney += bid;
							bidingMoney += forgeitMoney;
						}					
					}
				}
			}

			// sh.showPlayerStatus();
			sh.deliverCard(maxIndex);
			sh.showPlayerStatus();

			//最后一轮
			else{
				int maxIndex = sh.compareCard(false);

			}


		}

		oneTurnEndCondition = true;		
	}

	//一轮游戏完之后进行结算
	private void oneTurnSettle(ShowHand sh){
		int winningMen = sh.compareCard(false);


	}
	//初始玩家
	public void initPlayers(String... names){
		if(names.length > MAX_PLAYER_NUMS ||
			names.length < MIN_PLAYER_NUMS){
			System.out.println("初始化玩家数量不对");
			return;
		}
		else{
			for(int i = 0; i < names.length; i++){
				// playerNames[i] = names[i];
				playerInformation.add(new Player(names[i]));
				// for(int j = 0; j< playerInformation.size();j++){
				// 	System.out.println(playerInformation.get(j).getName());
				// }
				//初始化玩家时，同时给玩家分配初始筹码
				// playerChips[i] = BEGIN_CHIP;
				// List<Card> ca = new LinkedList<>();
				CardsInHand ca = new CardsInHand(new LinkedList<Card>());
				playerCards.add(ca);
			}
		}
	}	

	//该方法用于模拟“洗牌”
	public void initCard(){
		//先把"桌上"的牌全部清空
		cards.clear();

		for(int i = 0; i < Card.getAllTypes().length; i++){
			for(int j = 0; j < Card.getAllValues().length;j++){
				cards.add(new Card(Card.getAllTypes()[i],Card.getAllValues()[j]));
			}
		}

		//洗牌
		Collections.shuffle(cards);
	}

	// 代表从pos位置开始派牌
	private void deliverCard(int pos){

		int currentPlayerNumber = playerInformation.size();
		// System.out.println(currentPlayerNumber);

		//循环，依次为每个玩家派一张牌
		//从pos位置开始循环，依次为每个玩家派一张牌。
		for(int i = pos; i < pos + currentPlayerNumber; i++){
			//代表第i个玩家，如果玩家名不为null
			if(playerInformation.get(i % currentPlayerNumber).getName() != null){
				// System.out.println(playerCards.get(i%currentPlayerNumber));
				playerCards.get(i % currentPlayerNumber).add(cards.pop());
			}
		}

		// System.out.println(cards.size());
	}



	//比较参与游戏的所有玩家手上的“明牌”（除了第一张）
	//如果isMing参数为true，意味着不比较第一张牌的大小
	private  int compareCard(boolean isMing){

		int realPlayerNumber = playerInformation.size();
		/*
		if(牌面是否为同花顺)

		if（牌面是4个）

		if（牌面是3+2）（3条+1对）

		if（牌面是同花）

		if（牌面是顺子）

		if（牌面是3条）

		if(牌面有2对）

		if（牌面有1对）

		if（牌面全是散牌）
		*/

		//如果玩家手上的牌都是散牌，我们就要每个玩家手上最大的牌

		//该数组用于保存每个玩家手上最大的牌
		Card[] maxCard = new Card[realPlayerNumber];

		//循环，依次处理第i个玩家
		for(int i =0; i < realPlayerNumber; i++){

			//玩家名不为null，表明正在参与游戏
			if(playerInformation.get(i).getName() != null){
				//如果只判断明牌，意味着从第二张牌开始判断
				int fromIndex = isMing ? 1 : 0;
				maxCard[i] = playerCards.get(i).get(fromIndex); 
				
				//依次循环第i个玩家手上的j到最后一张牌
				for(int j = fromIndex, len = playerCards.get(i).size(); j < len; j++){
					if(maxCard[i].compareTo(playerCards.get(i).get(j)) < 0){
						maxCard[i] = playerCards.get(i).get(j);
					}
				}
			}
		}

		Card max = maxCard[0]; //假设第一个人手上的最大的牌最大。
		int maxIndex = 0;
		for(int i = 1, len = maxCard.length; i < len; i++){
			if(playerInformation.get(i).getName() != null){
				if(max.compareTo(maxCard[i]) < 0){
					max = maxCard[i];
					maxIndex = i;
				}
			}
		}

		return maxIndex;
	}

	// private void decideWinningCondition(){
	// 	for(int i = 0; i < playerChips.length; i++){
	// 		if(playerChips[i] < 0){
	// 			// player
	// 		}
	// 	}
	// }

	private void showPlayerStatus(){
		//循环，依次为每个玩家派一张牌
		//永远为第一个人先派牌,为每个人派一张牌。
		int realPlayerNumber = playerInformation.size();
		for(int i = 0; i <realPlayerNumber; i++){
			//代表第i个玩家，如果玩家名不为null
			
			if(playerInformation.get(i).getName() != null){
				System.out.print(playerInformation.get(i).getName() + "(当前筹码: " 
					+ playerInformation.get(i).getChip() + ")"
					+ "\t" + "手牌：");
			    

				for(int j = 0; j < playerCards.get(i).size(); j++){
			    	//如果是第一张牌，而且不是自己					
					if(j == 0 && !playerInformation.get(i).getName().equals("ziji")){
						//表明是隐藏牌
						System.out.print("▄▄▄▄   ");
					}
					else{
						//否则直接输出牌面
						System.out.print(playerCards.get(i).get(j) + "  ");
					}
				}
				System.out.println("");
			}
		}

		// System.out.println(cards.size());		
	}

}



