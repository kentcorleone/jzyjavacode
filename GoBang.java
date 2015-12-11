import java.io.*;
import java.util.*;

public class GoBang{

    //定义棋盘的边框
    static final int GOBANG_SIZE  = 11;
    static final String NO_CHESS = "☐";
    static final String BLACK_CHESS = "●";
    static final String WHITE_CHESS = "✦";
    static final String MenWinning = "●●●●●";
    static final String PCWinning = "✦✦✦✦✦";

    //定义一个二位数组，此时的数组元素系统全部自动初始化为null
    static String[][] status = new String[GOBANG_SIZE][GOBANG_SIZE];

    public static void main(String[] args) throws Exception{
        //程序从这里开始
        System.out.println("五子棋");

        init(); //该方法把每个数组元素都赋值为口

        printQipan(); //打印棋盘

        //System.in 代表键盘. 把System.in 做了一个包装
        // br可以理解为包装之后的键盘
        BufferedReader br = new BufferedReader
                        (new InputStreamReader(System.in));

        String line = null;    
        
        //读取用户输入的一行，并将这行赋值给line变量，
        //如果所读取的用户输入的一行不为null，则循环
        while((line = br.readLine()) != null){
            //line就是用户输入的一行字符串，这行字符串满足（x，y）的格式
            //如果用户不听话，不输入满足这个格式的字符串，我们就不让他玩游戏
            //此时需要将line字符串用逗号分割成前后两部分 

            String[] xyStr = line.split(",");

            //获取（x，y）位于逗号(,)之前的部分
            String xStr = xyStr[0];
            //获取（x，y）位于(,)之后的部分
            String yStr = xyStr[1];

            int xPos = Integer.parseInt(xStr);

            int yPos = Integer.parseInt(yStr);

            //如果用户希望下棋的坐标不为方框，表示该下棋点有棋子了
            if (!status[xPos][yPos].equals(NO_CHESS)) {
                System.out.println("此处有棋子，请下到别处");
                continue; //忽略本次循环后面语句
            }
            //所谓用户下棋，本质就是把该下棋点的字符串重新赋值
            status[xPos][yPos] = BLACK_CHESS; 

            //此时先做一个愚蠢的电脑,下棋是随机的
            //所谓随机的下棋，生成两个0(包括)到GOBANG_SIZE（不包括）的随机数
            //作为坐标

            while(true){
                //现在生成了pc要下棋的坐标
                int pcX = new Random().nextInt(GOBANG_SIZE); 
                int pcY = new Random().nextInt(GOBANG_SIZE);   

                //如果电脑希望下棋的坐标为方框，表示该下棋点没有棋子了
                if (status[pcX][pcY].equals(NO_CHESS)) {
                    //所谓用户下棋，本质就是把该下棋点的字符串重新赋值
                    status[pcX][pcY] = WHITE_CHESS; 
                    break; //忽略本次循环后面语句
                }

                //如果到了下面，表示电脑下棋的位置有棋子，程序开始下一次循环
                //随机生成电脑下棋的坐标
                
            }     

            printQipan();

            //每次用户电脑下完棋之后，判断一次输赢
            if (judge() > 0) {
                System.out.println("恭喜你，获胜了");
                return;
            }else if (judge() < 0) {
                System.out.println("很遗憾，你输了");
                return;
            }else{

            }
        } 
    }

    //初始化了一个棋盘
    public static void init(){
        for (int i = 0; i < GOBANG_SIZE; i++) {
            for (int j = 0; j < GOBANG_SIZE; j++) {
                status[i][j] = NO_CHESS;
            }
        }
    }

    //输出每个数组元素 （相当于在控制台绘制棋盘），由于经常需要绘制棋盘
    // 所以此处就执行输出 
    public static void printQipan(){
        for (int i = 0; i < GOBANG_SIZE; i++) {
            for (int j = 0; j < GOBANG_SIZE; j++) {
                System.out.print(status[i][j]);
            }
            System.out.println();
        }
    }

    //定义成判断输赢的方法，用户每次下棋之后，电脑每次下棋之后进行一次判断
    public static int judge(){
        //一共有四种方向会出现胜利情况
        //横，竖，正斜，反斜

        //竖的情况
        for (int i = 0; i < GOBANG_SIZE; i++) {
            String line = "";
            //循环完成时，程序将会返回“口口口口口口口”的字符串
            for (int j = 0; j < GOBANG_SIZE; j++) {
                line += status[j][i];
            }

            //判断字符串内，是否包含某个子串
            if (line.contains(MenWinning)) {
                return 1;
            }else if (line.contains(PCWinning)) {
                return -1;
            }
        }

        //横的情况
        for (int i = 0; i < GOBANG_SIZE; i++) {
            String line = "";
            //循环完成时，程序将会返回“口口口口口口口”的字符串
            for (int j = 0; j < GOBANG_SIZE; j++) {
                line += status[i][j];
            }

            //判断字符串内，是否包含某个子串
            if (line.contains(MenWinning)) {
                return 1;
            }else if (line.contains(PCWinning)) {
                return -1;
            }
        }   

        //正斜的情况
        for (int i = GOBANG_SIZE - 1; i > -1; i--) {
            String line = "";

            //正斜情况下，（x，y）的坐标差值是是一个等差数列
            //范围在两个gobang——size之内
            int zxChazhi = i; //将正斜差值定为变量
            //循环完成时，程序将会返回“口口口口口口口”的字符串
            //这意味着每次j都是从i＋zxChazhi开始的，即是1-GOBANG
            //SIZE+ i 从i的最开始的值带入得：0 往下走 －1 －2 
            // －3 。。。 ，然而坐标并没有负值，所以得到的结果
            //不是想要的,想要得到的结果是依次下来的正斜，所以要
            //进行一些修改,正斜差值这个值不能是一个定值，他要变动
            for (int j = 0,k = j + zxChazhi; k < GOBANG_SIZE;j++,k++) {
                line += status[j][k];
            }

            // for (int j = i + zxChazhi ; j > -1; j--) {
            //     line += status[i][j];
            // }

            //判断字符串内，是否包含某个子串
            if (line.contains(MenWinning)) {
                return 1;
            }else if (line.contains(PCWinning)) {
                return -1;
            }
        }      

        //反斜的情况
        for (int i = 0; i < GOBANG_SIZE - 1; i++) {
            String line = "";
            //反斜的情况下，（x,y）坐标的和值依次增大
            int fxHezi = i;
            
            for (int j = 0,k = fxHezi - j; k > 0; j++,k--) {
                line += status[j][k];
            }

            //判断字符串内，是否包含某个子串
            if (line.contains(MenWinning)) {
                return 1;
            }else if (line.contains(PCWinning)) {
                return -1;
            }

        }       

        return 0;
    }
}