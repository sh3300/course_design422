package com.company;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;

/**
 * Created by 锦 on 2015/4/4.
 */
public class FileList extends JList {
    FileListModel dataModel;
    static final long serialVersionUID = 10;
    String FilePath;

    public FileList() {
        dataModel = new FileListModel();
        setModel(dataModel);
        FilePath = dataModel.getFilePath();
        this.setCellRenderer(new MyCellRenderer());
    }

    public void fireTreeSelectionChanged(I_fileSystem node){
        dataModel.setNode(node);
        FilePath = dataModel.getFilePath();
        updateUI();
    }
}

class FileListModel implements ListModel{
    I_fileSystem node;
    char fileType = I_fileSystem.ALL;
    String FilePath;

    public void setNode(I_fileSystem node) {
        this.node = node;
        FilePath = node.getFilePath();
    }

    public String getFilePath(){
        return this.FilePath;
    }

    public Object getElementAt(int index) {
        if(node != null){
            return node.getChild(fileType,index);
        } else {
            return null;
        }
    }

    public int getSize(){
        if (node != null){
            return node.getChildCount(fileType);
        }else {
            return 0;
        }
    }

    public void addListDataListener(ListDataListener l) {
    }

    public void removeListDataListener(ListDataListener l) {
    }
}

class MyCellRenderer extends JLabel implements ListCellRenderer{
    public MyCellRenderer(){
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list,    Object value,    int index,    boolean isSelected,    boolean cellHasFocus) {
        FolderNode node = (FolderNode) value;

        setIcon(node.getIcon());
        setText(value.toString());
        setBackground(isSelected ? Color.BLUE : Color.WHITE);
        setForeground(isSelected ? Color.WHITE : Color.BLACK);
        return this;
    }
}




























