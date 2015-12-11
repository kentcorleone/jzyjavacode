public class Recursion{

    // 实例方法，因为没有static修饰.
    public void test(){
        System.out.println("------test--------");
        this.test(); // 方法里调用自身，就是递归。
    }

    //程序的入口 main方法是属于类的
    public static void main(String[] args) {
        Recursion rc = new Recursion();
        // rc.test();
        System.out.println(rc.f(20));
    }

    public int f(int n){
        if (n == 0) {
            return 2;
        }else if (n == 1) {
            return 3;
        }else{
            return this.f(n-2) + 2 * this.f(n-1);
        }
    }

}