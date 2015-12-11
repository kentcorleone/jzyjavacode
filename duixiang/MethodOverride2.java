public class MethodOverride2{
    public static void main(String[] args) {
        MethodOverride2 mo2 = new MethodOverride2();
        mo2.info();   
    }

    public void info(String name){
        System.out.println("===打一个string形参的info方法");
    }

    public static void info(){
        System.out.println("没有String形参的info方法");
    }
}