public class BreakLabelTest{
    public static void main(String[] args){
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++ ) {
                System.out.println("i的值为 " + i + ", j的值为 " + j);
                if (j > 5) {
                    break outer;
                }
            }
        }
    }
}