package com.company;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Vector;

/**
 * Created by 锦 on 2015/3/31.
 */
public class JExplorer {
    public JExplorer(){
        JFrame frame = new JFrame();
        UI panel = new UI(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int left = (screen.width - frame.getWidth()) / 2;
        int top = (screen.height - frame.getHeight()) / 2;

        frame.setLocation(left, top);
        frame.setVisible(true);

    }

}

class UI extends JPanel {
    static final long serialVersionUID = 0l;
    static int LEFT_WIDTH = 200;
    static int RIGHT_WIDTH = 300;
    static int WINDOW_HEIGHT = 300;
    static int ABOVE_HEIGHT =  40;
    static int ABOVE_WIDTH =  160;

    JFrame frame = null;

    public String isPartition(String Path){
        Path = Path.trim();
        if(Path.charAt(Path.length()-1) == '\\'){
            System.out.print("123\n");
            Path = Path.substring(0,Path.length()-1);
            return Path;
        } else {
            return Path;
        }
    }

    public UI(JFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(800, 630));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setLayout(new BorderLayout());

        FileList list = new FileList();
        FileTree tree = new FileTree(list);
        tree.setDoubleBuffered(true);
        list.setDoubleBuffered(true);

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(LEFT_WIDTH, WINDOW_HEIGHT));

        JScrollPane listView = new JScrollPane(list);
        listView.setPreferredSize(new Dimension(RIGHT_WIDTH, WINDOW_HEIGHT));

        JSplitPane pane1 =    new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeView,    listView);


        pane1.setDividerLocation(300);
        //pane1.setDividerSize(4);//设置分割线粗细

        JButton jbtChange = new JButton("转化成HTML文档");
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(jbtChange);
        panel2.setPreferredSize(new Dimension(ABOVE_WIDTH, ABOVE_HEIGHT));
        JSplitPane pane2 =    new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel2,    pane1);
        pane2.setDividerLocation(40);

        add(pane2);

        class ButtonListener implements ActionListener {
            public FileList list;

            public ButtonListener(FileList list){this.list=list;}
            public  void actionPerformed(ActionEvent e){
                Vector<String> AllPath = new Vector<String>();
                String Path;

                for(int i=0;i<=999;i++)
                    if(list.isSelectedIndex(i)){
                        Path = list.FilePath;
                        Path = isPartition(Path);
                        Path = Path + '\\' + list.getModel().getElementAt(i);
                        AllPath.add(Path);
                        System.out.print(999+"\n");
                        //System.out.print(i+"   "+Path+"\n");
                    }
                for(int i = 0;i < AllPath.size();i++){
                    System.out.println(AllPath.get(i));
                }
            }
        }

        ButtonListener listener = new ButtonListener(list);
        jbtChange.addActionListener(listener);

    }
}















