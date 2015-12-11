import javax.swing.*;
import java.awt.event.InputEvent;

public class MenuTest extends JFrame{

    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");
    JMenu viewMenu = new JMenu("视图");

    JMenuItem newItem = new JMenuItem("新建");
    JMenuItem openItem = new JMenuItem("打开");
    JMenuItem saveItem = new JMenuItem("保存");
    JMenuItem exitItem = new JMenuItem("退出");
    JMenuItem undoItem = new JMenuItem("撤销");
    JMenuItem redoItem = new JMenuItem("重做");

    //JMunu继承了JMenuItem，所有JMenu可以当成JMenuItem来用
    //子类的实例是一种特殊的父类实例
    JMenu deleteItem = new JMenu("删除");

    JMenuItem deleteSelectedLine = new JMenuItem("删除所选行");
    JMenuItem deleteLine = new JMenuItem("删除行");
    JMenuItem deleteWord = new JMenuItem("删除单词");



 


    public MenuTest(){
        super("菜单测试");
        //MunuTest本身就继承了JFrame
        this.setIconImage(new ImageIcon("self.jpeg").getImage());

        menuBar.add(fileMenu); //往里面添加第一个菜单
        menuBar.add(editMenu); //往里面添加第二个菜单
        menuBar.add(viewMenu); //往里面添加第三个菜单

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); //添加分隔条
        fileMenu.add(exitItem);

        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.addSeparator(); //添加分隔符
        editMenu.add(deleteItem); //添加删除

        deleteItem.add(deleteSelectedLine);
        deleteItem.add(deleteLine);
        deleteItem.add(deleteWord);


        //为菜单项添加快捷键
        newItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_DOWN_MASK));

        //为窗口安装菜单条
        this.setJMenuBar(menuBar);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();

        //把JFrame的实例代表的窗口显示出来
        this.setVisible(true);
    }

    JFrame mainWin = new JFrame("菜单测试");

    public void init(){

        //设置图标
        // mainWin.setImage(Image image);

        // mainWin.pack();
        // mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        MenuTest mt = new MenuTest();
        // mt.init();
    }
}