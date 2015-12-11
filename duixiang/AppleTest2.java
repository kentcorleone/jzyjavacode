public class AppleTest2{
    public static void main(String[] args){
        
        // 右边使用new创建一个Apple实例，并让apple引用变量指向Apple实例
        Apple apple = new Apple();

        //引用变量apple在main方法中声明，它就被放在main方法栈中 new Apple()对象放在堆里面。apple是一个引用变量，本质是一个包装后的指针，apple指向程序创建的Apple对象
    
    }
}