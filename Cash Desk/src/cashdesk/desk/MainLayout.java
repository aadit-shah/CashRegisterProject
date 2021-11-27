package cashdesk.desk;

import javax.swing.*;
import java.awt.*;

/**
 * The main Layout class for the Cashdesk
 */
public class MainLayout extends JPanel {
    /* This is the main window layout */

    /**
     * Create the main Layout
     */
    public MainLayout() {
        super();

        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Add a Panel to the box Layout and set it's maximum size
     * @param pan The panel to insert
     * @param size The maximum Dimension
     */
    public void addPanel(JPanel pan, Dimension size) {
        pan.setMaximumSize(size);

        super.add(pan);
    }

    /**
     * Create a spacer after the panel
     * @param height The height of the panel
     */
    public void addSpacer(int height) {
        super.add(Box.createVerticalStrut(height));
    }

}
