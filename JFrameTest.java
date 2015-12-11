import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
// import javax.swing.JOptionPane;


public class JFrameTest{
    public static void main(String[] args) {
        final JFrame jf = new JFrame("测试退出程序？ ");
        jf.addWindowListener(new WindowListener(){

            //窗口激活时激发该方法
            public void windowActivated(WindowEvent e){}
            // Invoked when the Window is set to be the active Window.

            // public void windowOpened(WindowEvent e){}

            //窗口关闭后激发该方法
            public void windowClosed(WindowEvent e){}
            // Invoked when a window has been closed as the result of calling dispose on the window.

            //窗口关闭时激发该方法
            public void windowClosing(WindowEvent e){
                //显示一个确认对话框
                int result = JOptionPane.showConfirmDialog(jf,"sure to close the window?");
                if(result == 0) System.exit(0);
            }
            // Invoked when the user attempts to close the window from the window's system menu.

            //窗口失去激活时激发该方法
            public void windowDeactivated(WindowEvent e){}
            // Invoked when a Window is no longer the active Window.

            //窗口恢复时激发该方法
            public void windowDeiconified(WindowEvent e){}
            // Invoked when a window is changed from a minimized to a normal state.

            //窗口最小化时激发该方法
            public void windowIconified(WindowEvent e){}
            // Invoked when a window is changed from a normal to a minimized state.

            //窗口第一次可见时(打开时)激发该方法
            public void windowOpened(WindowEvent e){}
            // Invoked the first time a window is made visible.
        });
        jf.setBounds(30,50,200,160);
        jf.setVisible(true);
    }
}