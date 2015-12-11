public class LocalVarTest{

    //此处的name就是形参
    public void test(String name){
        String str = "白骨精";
        System.out.println(str);

        {
            String str = "zhizhujing";
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        int age = 20;
        System.out.println(age);

        {
            //代码块的局部变量只在花括号内有效
            String name = "sunwukong";
            System.out.println(name);            
        }

        
    }
}