public class VarArgs{

    public static void main(String[] args) {
        //定义一个va变量，va变量指向VarArgs实例
        VarArgs va = new VarArgs();    
        va.test(3);
        va.info("hello",3,4,5,6,7,8,9);
        System.out.println("----------");
        va.info("java");
        va.info("hello", new int[]{11,13,14});
    }

    //int... 代表可以传入n个参数值。
    public void info(String name,int... nums){
        //在方法中，nums相当于数组
        for (int num : nums) {
            System.out.println(name + "----" + num);
        }
    }
    public void test(int age){
        System.out.println("age参数值为: " + age);
    }


}