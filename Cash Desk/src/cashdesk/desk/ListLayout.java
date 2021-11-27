package cashdesk.desk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The ListLayout contains the basket and a remove button
 */
public class ListLayout extends JPanel implements ActionListener {
    private JList list;
    private JButton button;
    private JLabel label;

    private int buttonWidth;
    private DefaultListModel listMod;

    /**
     * Create the List Layout
     * @param buttonWidth The maximum button width for the remove button
     * @param list The basket
     */
    public ListLayout(int buttonWidth, DefaultListModel list) {
        super();
        super.setLayout(new BorderLayout());

        this.buttonWidth = buttonWidth;
        this.listMod = list;
        this.addContent();
    }

    /**
     * Add content to the panel
     */
    private void addContent() {
        /* Initialize all JComponents */
        this.list = new JList(this.listMod);
        this.button = new JButton("Remove selected");
        this.label = new JLabel("Items in the shopping cart:");

        this.button.setMaximumSize(new Dimension(this.buttonWidth, 25));
        this.button.addActionListener(this);

        this.addToLayout();
    }

    /**
     * Here it's added to the layout
     */
    private void addToLayout() {
        /* Add them to the Layout and specify size */
        super.add(this.label, BorderLayout.PAGE_START);
        super.add(this.list, BorderLayout.CENTER);
        super.add(this.button, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* TODO: On button click remove the selected item in the basket */
        int index = this.list.getSelectedIndex();

        /* Check for ArrayOutOfBoundsException (Empty list or nothing selected) */
        if (index == -1) {
            return;
        }

        this.listMod.remove(index);
    }
}
