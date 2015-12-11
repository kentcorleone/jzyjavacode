public class 等腰三角形{
    public static void main(String[] args) {
        int h = 8;
        for (int i = 0; i < h; i++) {
            //输出每行前面的空格
            for (int k = i; k < h - 1; k++) {
                System.out.print(" ");
            }
            //输出星号＊
            for (int j = 0; j < 2*i + 1; j++) {
                System.out.print("*");
            }
            //每行打印完换行
            System.out.println();
        }
    }
}

