import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
// import javax.swing.JOptionPane;


public class JFrameAdapterTest{
    public static void main(String[] args) {
        final JFrame jf = new JFrame("测试退出程序？ ");
        jf.addWindowListener(new WindowAdapter(){

            //窗口关闭时激发该方法
            @Override
            public void windowClosing(WindowEvent e){
                //显示一个确认对话框
                int result = JOptionPane.showConfirmDialog(jf,"sure to close the window?");
                if(result == 0) System.exit(0);
            }

        });
        jf.setBounds(30,50,200,160);
        jf.setVisible(true);
    }
}