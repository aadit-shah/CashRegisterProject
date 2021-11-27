package cashdesk.desk;

import cashdesk.Data;
import cashdesk.DataHolder;
import cashdesk.HistoryViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * The control layout that holds the pay button as well as the pay method and history panel
 */
public class ControlLayout extends JPanel implements ActionListener {
    private JComboBox payMethod;
    private JButton pay;
    private JButton history;

    private String[] payMethods;

    /* Data */
    private DefaultListModel list;
    private DataHolder dataHolder;

    /**
     * The Control Layout
     * @param list The basket
     * @param dh The Data holder in which the payment should be inserted
     */
    public ControlLayout(DefaultListModel list, DataHolder dh) {
        super();
        super.setLayout(new GridLayout(2, 2, 4, 4));

        /* Constants */
        this.list = list;
        this.dataHolder = dh;

        this.addContent();
    }

    /**
     * Add the Content to the Panel
     */
    private void addContent() {
        /* Initialize all JComponents */
        this.payMethods = new String[]{"Mastercard", "Amex", "Cash"};
        this.payMethod = new JComboBox(this.payMethods);
        this.pay = new JButton("Pay");
        this.history = new JButton("View History");

        this.pay.addActionListener(this);
        /* There are many possibilities to do the following, this is the easiest one (Compatibility from Java 8) */
        this.history.addActionListener(e -> new HistoryViewer(this.dataHolder)); // Lambda expression

        this.addToLayout();
    }

    /**
     * Add Elements to the Layout
     */
    private void addToLayout() {
        super.add(this.payMethod);
        super.add(this.pay);
        super.add(this.history);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.list.getSize() == 0) {
            return;
        }

        /* Extract the value from the basket */
        float value = 0;
        for(int i = 0; i < this.list.size(); i++) {
            String[] words = this.list.getElementAt(i).toString().split("\\s+");
            String line = words[words.length - 1].replace(",", "");
            value += Float.parseFloat(line);
        }

        /* Create a new Data Entry and add it to the data holder, then clear the basket */
        Data data = new Data(-1, value, LocalTime.now().toString(), this.payMethod.getSelectedItem().toString());
        this.dataHolder.insert(data);
        this.list.clear();

    }
}
