package cashdesk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The History Viewer is a separate Window in which all the purchases are shown
 */
public class HistoryViewer {

    /* The data part */
    private DataHolder dataHolder;
    private String data[][];
    private String column[];

    /* The Swing part */
    private Frame frame;
    private JTable table;
    private JScrollPane scrollPane;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem load;

    /**
     * Create a new Window with the History Viewer
     * @param dataHolder The data which should be used
     */
    public HistoryViewer(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
        this.frame = new Frame(400, 500, "History", null, true);

        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Menu");
        this.save = new JMenuItem("Save");
        this.load = new JMenuItem("Load");

        this.menu.add(load);
        this.menu.add(save);
        this.menuBar.add(menu);
        this.frame.setJMenuBar(menuBar);

        this.setActionListeners();
        this.setData();
        this.setTable();
    }

    private void setActionListeners() {
        this.save.addActionListener(e -> this.saveMethod());
        this.load.addActionListener(e -> this.loadMethod());
    }

    private void saveMethod() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save history");

        int userSelection = fileChooser.showSaveDialog(this.frame);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {
            FileOutputStream f = new FileOutputStream(fileChooser.getSelectedFile());
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(this.data);

            o.close();
            f.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadMethod() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load history");

        int userSelection = fileChooser.showOpenDialog(this.frame);
        if (userSelection != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {
            FileInputStream f = new FileInputStream(fileChooser.getSelectedFile());
            ObjectInputStream o = new ObjectInputStream(f);

            this.data = (String[][]) o.readObject();

            o.close();
            f.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        this.table.setModel(new DefaultTableModel(this.data, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    /**
     * Set the data
     */
    private void setData() {
        this.data = new String[dataHolder.getLength()][Data.getWidth()];
        this.column = Data.getIndexes();

        for (int i = 0; i < dataHolder.getLength(); i++) {
            this.data[i] = dataHolder.getData(i).toStringArray();
        }
    }

    /**
     * Set the table
     */
    private void setTable() {
        this.table = new JTable();

        /* This can be done either that way of with another class that extends DefaultTableModel */
        this.table.setModel(new DefaultTableModel(this.data, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        this.table.setAutoCreateRowSorter(true);
        this.scrollPane = new JScrollPane(this.table);
        this.frame.add(this.scrollPane);
    }
}
