public class MethodOverride{
    public static void main(String[] args) {
        MethodOverride mo1 = new MethodOverride();
        mo1.test();
        mo1.test("123");
        mo1.test(20+"");
    }

    public void test(){
        System.out.println("---没有形参的test方法－－－");
    }

    public String test(String name){
        System.out.println("---有形参的test方法");
        System.out.println("name参数值: " + name);

        return  name + ",您好";
    }


}