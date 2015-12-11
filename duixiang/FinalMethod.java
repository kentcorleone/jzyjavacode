public class FinalMethod extends MyBase{
    int count = 30;
    int count2 = 31;
    // static int sint = 41;
    public static void main(String[] args) {
        //把子类实例，赋值给父类变量,向上转型
        MyBase bs1  = new FinalMethod();

        //这里bs1的编译型类型是MyBase，而MyBase里面的
        //info方法是private的，不能被访问。

        FinalMethod fm = (FinalMethod)bs1;

        fm.info();
        // System.out.println(bs1.count);
        // FinalMethod fm = (FinalMethod)bs1;
        // Syste;m.out.println(fm.count2)


    }

    // @Override
    public void info(){
        System.out.println("重写的info方法");
    }
}

class Base{
    int count = 20;
    // static int sint = 40;

    public void info(){
        System.out.println("===info方法===");
    }
}

class MyBase{
    final private void info(){

    }
}

