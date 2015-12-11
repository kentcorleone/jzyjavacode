class Demo{
    String name;
    int age;
    static int num;
}

public class DemoTest{
    public static void main(String[] args) {
        Demo d ＝ null;

        System.out.println("~~~~~~" + Demo.num);

        d = new Demo();

        Demo d2 = new Demo();

        d.age = 20;
    }
}