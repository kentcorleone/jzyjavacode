public class 打印圆{
    public static void main(String[] args) {
        int r = 20;
        for (int i = 0; i < 2*r ; i++) {
            //输出星号前面的空格
            for (int k = 0; k < (r-(Math.ceil(Math.sqrt(r * r - (r - i)*(r - i))))); k++) {
                System.out.print(" ");
            }
            //输出第一个星号
            System.out.print("*");
            //输出两个星号之间的空格
            for (int j = 0; j < 2 * Math.ceil(Math.sqrt(r * r - (r - i)*(r - i))); j++) {
                 System.out.print(" ");
            } 
            //输出第二个星号
            System.out.print("*");
            //打印完当行之后，进行换行
            System.out.println();

        }
    }
}