public class Bird{

    String name;

    //此时程序定义了有参数的构造器
    //系统将不会再为它提供无参的构造器
    public Bird(String name){
        this.name = name;
    }

    public void bat(){
        System.out.println(this.name + "在挥动翅膀");
    }

    public void fly(){
        this.bat(); // 方法中看不出this代表谁
        System.out.println(this.name + "在天空飞翔");
    }

    public static void main(String[] args) {
        Bird bird = new Bird("外鸟");
        bird.fly();
    }
}