import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
// import javax.swing.JOptionPane;


public class JFrameExit{
    public static void main(String[] args) {
        final JFrame jf = new JFrame("测试退出程序？ ");

        //当关闭窗口时，自动退出程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(30,50,200,160);
        jf.setVisible(true);
    }
}