package cashdesk.desk;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * The first row of the Cash Desk, it holds the name and value of the item which should be added to the basket
 */
public class ProductLayout extends JPanel implements ActionListener {
    private JLabel nameLabel;
    private JLabel valueLabel;

    private JTextField nameText;
    private JFormattedTextField value;

    private JButton addButton;

    private DefaultListModel list;

    /**
     * Create the Product Layout
     * @param list The basket
     */
    public ProductLayout(DefaultListModel list) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.list = list;
        this.addContent();
    }

    /**
     * Add the content to the Panel
     */
    private void addContent() {
        /* Initialize all JComponents */
        this.nameLabel  = new JLabel("Item:  ");
        this.valueLabel = new JLabel("Value:  ");
        this.nameText   = new JTextField();
        this.addButton  = new JButton("Add");

        /* Limit the Textfield to only accept numbers */
        NumberFormatter format = new NumberFormatter(NumberFormat.getNumberInstance(Locale.US));
        format.setValueClass(Float.class);
        this.value = new JFormattedTextField(format);

        /* Set Dimensions to the components */
        this.nameText.setMaximumSize(new Dimension(150, 20));
        this.value.setMaximumSize(new Dimension(80, 20));
        this.addButton.setMaximumSize(new Dimension(80, 20));

        this.addButton.addActionListener(this);

        this.addToLayout();
    }

    /**
     * Add the content to the Layout
     */
    private void addToLayout() {
        /* Add everything to the layout and set Distances between them */
        super.add(Box.createHorizontalStrut(10));
        super.add(this.nameLabel);
        super.add(this.nameText);
        super.add(Box.createHorizontalStrut(10));
        super.add(this.valueLabel);
        super.add(this.value);
        super.add(Box.createHorizontalStrut(10));
        super.add(this.addButton);
        super.add(Box.createHorizontalStrut(10));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Check if the value is not just whitespaces and not empty */
        if (this.nameText.getText().trim().isEmpty() || this.value.getText().trim().isEmpty()) {
            return;
        }

        String val = "Item: " + this.nameText.getText().trim() + " - Price: " + this.value.getText();
        this.list.addElement(val);

        this.nameText.setText("");
        this.value.setText("");
    }
}
