public class Animal{
    //初始化块
    {
        weight = 20.3;
        System.out.println("---正在执行Animal实例初始化快");
    }



    static{
        System.out.println("对Animal类进行初始化");
        eyeNum = 3;
    }

    //定义Field时，所制定的初始值其实是假象
    double weight = 12.3;
    String name;
    static int eyeNum = 2;

    public Animal(){
        System.out.println("---正在执行Animal无参数的构造器");

    }

    public Animal(String name){
        this.name = name;
        System.out.println("---正在执行Animal有参数的构造器");
    }

    public static void main(String[] args) {
        // Animal a1 = new Animal();
        // a1.info();
        // Animal a2 = new Animal("喜羊羊");
        // a2.info();
        // System.out.println(Animal.eyeNum);
        // new Sparrow();

        //此时并不算主动使用Sparrow类
        // Sparrow sp;
    }

    public void info(){
        System.out.println("名字： " + this.name
                         +" 体重： " + this.weight);    
    }

}

class Bird extends Animal{
    static {
        System.out.println("Bird的类初始化块");
    }

    {
        System.out.println("对Bird实例执行初始化的初始化块");
    }


    public Bird(){
        System.out.println("Bird的无参构造器");

    }

    public Bird(String name){
        super(name);
        System.out.println("Bird的有参构造器");
    }

}

class Sparrow extends Bird{
    static{
        System.out.println("Sparrow的类初始化块");
    }
    {
        System.out.println("对Sparrow实例执行初始化的初始化块");
    }


    public Sparrow(){
        // this("");
        System.out.println("麻雀的无参数构造器");
    }

    public Sparrow(String name){
        // this();
        super();
        System.out.println("---麻雀带一参");
    }
}