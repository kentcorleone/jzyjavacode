import java.io.*;

class Person{
    private int age;    //要求年龄必须是有效的：0～max
    private String name; // 假设我们有要求人的名字的长度
    //至少有3，最多6

    public void grow(){
        this.age++;
    }

    private static int count;

    public void setName(String name) throws Exception
    {

        // System.out.println("已进入setName内部");
        // System.out.println(this.name);
        this.name = name;
        // System.out.println("先把名字给换了");
        if (this.name.length() > 6 || this.name.length() < 3) {
            System.out.println("名字不合规定,重新输入： ");
            this.setName(   new BufferedReader
                            (new InputStreamReader(System.in)).readLine()
                        );
            Person.count++;
            System.out.println("＝＝＝我呆了 "+ Person.count + " 次＝＝＝");
        }else{
            this.name = name;
        }
    }

    public String getName(){
        return  this.name;
    }
}

public class PersonTest{
    public static void main(String[] args) throws Exception
    {
        Person p1 = new Person();

        //如果直接对field赋值，很容易导致Person
        //对象的数据完整性被破坏。
        // p.age = 400000;
        // p.name = "zhang";
        p1.grow();
        System.out.println("请输入姓名: ");
        p1.setName(new BufferedReader
                    (new InputStreamReader(System.in)).readLine()
                  );
        // p1.setName("zhangsan");
        // System.out.println("已成功将值传给setName");

        System.out.println("现在的名字是: " +
                    p1.getName());

    }
    
}