public class StringArrayUtil{
	//用于获取target字符串在strArr数组中索引
	public static int search(String target, String[] strArr){

		//i 从0开始，一直循环到数组的最后一个元素
		//一次遍历每个数组元素
		for(int i = 0, len = strArr.length; i < len; i++){

			//表明已经从字符串数组中找到了目标字符串
			if(strArr[i].equals(target)){
				return i;
			}
		}

		//返回-1，表明在strArr数组中没有找到target元素
		return -1;
	}
}