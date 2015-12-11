public class AppleTest{

    // apple是一个局部变量 
    Apple apple;

    // new后面接的是构造器
    apple = new Apple(); //创建一个Apple对象实例，并让apple引用变量指向该Apple对象实例
// Apple对象存放在堆里。apple引用变量存放在对应的方法栈里面
    
    // 要调用方法，就一定要满足对方的要求
    System.out.println(apple.sayHi(“孙悟空”));

    // 使用局部变量之前，必须先赋初始值。
    System.out.println(apple); // 打印对象，输出的是”类名@hashcode值”
}