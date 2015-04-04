package com.company;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import java.util.Vector;

/**
 * Created by 锦 on 2015/4/4.
 */
public class FileTree extends JTree {
    static final long serialVersionUID = 0;
    private FileList theList;

    public FileTree(){
    }

    public FileTree(FileList list) {
        theList = list;
        setModel(new FileSystemModel(new FolderNode()));
        addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent tse) {
            }
        });
        this.setSelectionRow(0);
    }

    public void fireValueChanged(TreeSelectionEvent tse) {
        TreePath tp = tse.getNewLeadSelectionPath();
        Object o = tp.getLastPathComponent();
        theList.fireTreeSelectionChanged((FolderNode) o);
    }

    public void fireTreeCollapsed(TreePath path) {
        super.fireTreeCollapsed(path);
        TreePath curpath = getSelectionPath();
        if (path.isDescendant(curpath)) {
            setSelectionPath(path);
        }
    }

    public void fireTreeWillExpand(TreePath path) {
        System.out.println("Path will expand is " + path);
    }

    public void fireTreeWillCollapse(TreePath path) {
        System.out.println("Path will collapse is " + path);
    }

    class ExpansionListener implements TreeExpansionListener {
        FileTree tree;

        public ExpansionListener(FileTree ft) {
            tree = ft;
        }

        public void treeCollapsed(TreeExpansionEvent tee) {
        }

        public void treeExpanded(TreeExpansionEvent tee) {
        }
    }
}

class FileSystemModel implements TreeModel {
    I_fileSystem theRoot;
    char fileType = I_fileSystem.DIRECTORY;

    public FileSystemModel(I_fileSystem fs) {
        theRoot = fs;
    }

    public Object getRoot() {
        return theRoot;
    }


    public Object getChild(Object parent, int index) {
        return ((I_fileSystem) parent).getChild(fileType, index);
    }

    public int getChildCount(Object parent) {
        return ((I_fileSystem) parent).getChildCount(fileType);
    }

    public boolean isLeaf(Object node) {
        return ((I_fileSystem) node).isLeaf(fileType);
    }

    public int getIndexOfChild(Object parent, Object child) {
        return ((I_fileSystem) parent).getIndexOfChild(fileType, child);
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    public void addTreeModelListener(TreeModelListener l) {
    }

    public void removeTreeModelListener(TreeModelListener l) {
    }
}

interface I_fileSystem{
    final public static char DIRECTORY = 'D';
    final public static char FILE = 'D';
    final public static char ALL = 'A';

    public Icon getIcon();
    public String getFilePath();
    public I_fileSystem getChild(char fileType, int index);
    public int getChildCount(char fileType);
    public boolean isLeaf(char fileType);
    public int getIndexOfChild(char fileType, Object child);
}

class FolderNode implements I_fileSystem{
    private static FileSystemView fsView;
    private static boolean showHiden = true;
    private File theFile;
    private Vector<File> all = new Vector<File>();
    private Vector<File> folder = new Vector<File>();

    public  Icon getIcon(){
        return fsView.getSystemIcon(theFile);
    }

    public File getTheFile(){
        return theFile;
    }

    public  String getFilePath(){
        return theFile.getPath();
    }

    public String toString(){
        return fsView.getSystemDisplayName(theFile);
    }

    private void prepareChildren(){
        File[] files = fsView.getFiles(theFile,showHiden);

        for(int i = 0;i < files.length; i++){
            all.add(files[i]);
            if (files[i].isDirectory() && !files[i].toString().toLowerCase().endsWith(".lnk")) {
                folder.add(files[i]);
            }
        }

    }

    public FolderNode(){
        fsView = FileSystemView.getFileSystemView();
        theFile = fsView.getHomeDirectory();
        prepareChildren();
    }

    private FolderNode(File file) {
        theFile = file;
        prepareChildren();
    }

    public  FolderNode getChild(char fileType, int index) {
        if (I_fileSystem.DIRECTORY == fileType) {
            return new FolderNode(folder.get(index));
        } else if (I_fileSystem.ALL == fileType) {
            return new FolderNode(all.get(index));
        } else if(I_fileSystem.FILE == fileType){
            return null;
        } else {
            return null;
        }
    }

    public int getChildCount(char fileType) {
        if (I_fileSystem.DIRECTORY == fileType) {
            return folder.size();
        } else if (I_fileSystem.ALL == fileType) {
            return all.size();
        } else if (I_fileSystem.FILE == fileType) {
            return -1;
        } else {
            return -1;
        }
    }

    public boolean isLeaf(char fileType) {
        if (I_fileSystem.DIRECTORY == fileType) {
            return folder.size() == 0;
        } else if (I_fileSystem.ALL == fileType) {
            return all.size() == 0;
        } else if (I_fileSystem.FILE == fileType) {
            return true;
        } else {
            return true;
        }
    }

    public int getIndexOfChild(char fileType, Object child) {
        if (child instanceof FolderNode) {
            if (I_fileSystem.DIRECTORY == fileType) {
                return folder.indexOf(((FolderNode) child).theFile);
            } else if (I_fileSystem.ALL == fileType) {
                return all.indexOf(((FolderNode) child).theFile);
            } else if (I_fileSystem.FILE == fileType) {
                return -1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

class FolderRenderer extends DefaultTreeCellRenderer {
    private static final long serialVersionUID = 1L;

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row,    boolean hasFocus) {
        I_fileSystem node = (I_fileSystem) value;
        Icon icon = node.getIcon();

        setLeafIcon(icon);
        setOpenIcon(icon);
        setClosedIcon(icon);

        return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    }
}






















