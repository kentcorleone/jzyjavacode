public abstract class AbstractTest{

    public AbstractTest(){
        System.out.println();
    }

    {
        System.out.println();
    }

    //该方法不是抽象方法。
    //该方法有方法体，只是方法体里面没有代码。
    public void info(){
        System.out.println("123");
    }

    // public static abstract void info2();

    public abstract void test();

    abstract public void test2();

    //abstract与static不能同时修饰方法
    // abstract public static void test3();

    public static void test4(){}

    // private abstract void test5();

    public static void main(String[] args) {
        // InstanceTest it1 = new InstanceTest(); 
        AbstractTest at = new InstanceTest();
        at.info();       
    }


}

class InstanceTest extends AbstractTest{

    // AbstractTest at = new InstanceTest();

    // AbstractTest.test4();
    // AbstractTest.test3();
    {
        // at.info();
        // AbstractTest.test3();
    }

    // public static void main(String[] args) {
    //     InstanceTest it1 = new InstanceTest();
    // }

    public void info(){
        System.out.println("234");
    }

    @Override
    public void test2(){

    }

    @Override
    public void test(){}



}