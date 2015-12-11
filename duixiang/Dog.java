public class Dog{
    //代表狗胃中食物量
    double foodAmount;
    String name;

    public void eat(){
        //this永远代表调用该方法的对象
        //this在该方法里面所代表的对象是不确定的。
        //直到该方法被调用时才确定下来，谁调用这个方法，
        //this就代表谁
        this.foodAmount += 10;
    }

    public Dog(String name){
        //this代表该构造器正在初始化的对象
        this.name = name;
    }

    public void info(){
        System.out.println("我的名字是 " + this.name);
        System.out.println("我肚子里的食物为 " + this.foodAmount);
    }

    static public void main(String[] args) {
        //调用构造器，方法时，参数值会传入构造器，方法中。
        Dog d = new Dog("旺财");

        Dog d2 = new Dog("啦西");

        Dog d3 = new Dog("旺旺");

        d2.eat(); 
        d2.info();

        d3.info();

    }
    /**
        语文－英语
        正常的句子满足： 主谓宾 宾语可以省略
        如： 猪八戒吃西瓜
            孙悟空飞

        在面向对象的程序里面，上面两个语句可写为：
        猪八戒.吃（西瓜）；
        孙悟空.飞（）；

        孙悟空的年龄；
        张三的狗；
    */
}