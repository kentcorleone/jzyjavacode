import java.lang.StringBuilder;


public class FinalTest{
    final static StringBuilder s = new StringBuilder("xyz");
    public static void main(String[] args) {
        s.append("123");
        System.out.println(s)e;
    }
}