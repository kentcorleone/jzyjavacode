import java.lang.Comparable;
import java.util.LinkedList;
import java.util.Collections;


//实现Comparable接口，意味着该牌是可比较大小的
public class Card implements Comparable<Card>{

	//定义花色
	private static final String[] ALL_TYPES = new String[]{"方块","草花","红心","黑桃"};

	//定义牌面值
	private static final String[] ALL_VALUES = new String[]
		{"2","3","4","5",
		 "6","7","8","9",
		 "10","J","Q","K","A" };



	private String type; //具体某张牌的种类
	private String value; //具体某张牌的值

	public Card(String type, String value){
		this.type = type;
		this.value = value;
	}


	public static String[] getAllTypes(){
		return ALL_TYPES;
	}

	public static String[] getAllValues(){
		return ALL_VALUES;
	}

	@Override
	public int compareTo(Card other){
		//牌面值的大小与它在数组中的索引相关，
		//它的索引越大，我们就认为它的牌面值越大。
		if(StringArrayUtil.search(this.value,ALL_VALUES) > StringArrayUtil.search(other.value,ALL_VALUES)){
			return 1;
		}

		else if(StringArrayUtil.search(this.value,ALL_VALUES) < StringArrayUtil.search(other.value,ALL_VALUES)){
			return -1;
		}

		// 等于的情况下就比较花色
		else{
			if(StringArrayUtil.search(this.type,ALL_TYPES) > StringArrayUtil.search(other.type,ALL_TYPES)){
				return 1;
			}
			else{
				return -1;
			}

		}

	}

	@Override
	public String toString(){
		return type + value;
	}


}
