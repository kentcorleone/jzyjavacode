public class 九九乘法表{
    public static void main(String[] args){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                if(j < i){
                    System.out.print(i + " * " + j + " = " + i * j + " , ");
                }
                else if (j == i) {
                    System.out.print(i + " * " + j + " = " + i * j);
                    System.out.println();
                }
            }
        }
    }
}