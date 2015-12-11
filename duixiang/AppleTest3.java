public class AppleTest3{
    public static void main(String[] args) {
        //此处只是定义了一个Apple的引用变量a，a并未指向任何有效的内存。
        Apple a = null;
        Syso.println(a.subs);
    }
}