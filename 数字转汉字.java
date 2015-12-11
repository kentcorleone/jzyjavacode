public class 数字转汉字{
    public static void main(String[] args) {
        String[] hanziqun = new String[]{"零","壹","贰","叁","肆","伍",
        "陆","柒","捌","玖"};
        String[] hanziUnit = new String[]{"","十","百","千"};

        int a = 1024;

        //把数字转化成字符串最简单的方法,直接加一个空字符串即可
        String str = a + "";

        String results = "";

        for (int i = str.length() - 1, j = 0; i > -1; i--) {
            //获取str第i个位置的字符
            char numChar = str.charAt(i);
            /*
             *
             */
            //如果当前数字为0，无需添加单位
            if (numChar == '0') {
                results = hanziqun[numChar-48] + results;
            }
            else{
            results = (hanziqun[numChar-48] + hanziUnit[j]) + results;
            }
            j++;
        }
        System.out.println(results);
        
    }
}