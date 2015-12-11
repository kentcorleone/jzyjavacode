import java.io.*;

public class KeyBoardTest{
    public static void main(String[] args) throws Exception {
        //System.in 代表键盘. 把System.in 做了一个包装
        // br可以理解为包装之后的键盘
        BufferedReader br = new BufferedReader
                        (new InputStreamReader(System.in));

        String line = null;    
        
        //读取用户输入的一行，并将这行赋值给line变量，
        //如果所读取的用户输入的一行不为null，则循环
        while((line = br.readLine()) != null){
            System.out.println("~~~" + line);
        }            
    }
}