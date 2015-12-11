public class Apple{

    private int age;
    protected String name;
    
    //用了static，表明它属于类，而不是属于实例
    static protected String[] subs;

    double weight = 56.3;

    int grade;  

    String sayHi(String name){
        return name + “ hi”;
    }
}