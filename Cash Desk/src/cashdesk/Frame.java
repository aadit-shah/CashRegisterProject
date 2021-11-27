package cashdesk;

import javax.swing.*;

/**
 * A Frame that auto creates itself with the given paramters
 */
public class Frame extends JFrame {

    /* They are unnecessary */
    private int height;
    private int width;

    /**
     * Create a new frame
     * @param width Width of the frame
     * @param height Height of the frame
     * @param title Title of the frame
     * @param main The main content, null for None
     */
    public Frame(int width, int height, String title, JPanel main) {
        new Frame(width, height, title, main, false);
    }

    /**
     * Create a new frame
     * @param width Width of the frame
     * @param height Height of the frame
     * @param title Title of the frame
     * @param main The main content, null for None
     * @param resizable True for resizable, false for not
     */
    public Frame(int width, int height, String title, JPanel main, boolean resizable) {
        super();

        this.width = width;
        this.height = height;

        if (main != null) {
            this.setContentPane(main);
        }

        super.setTitle(title);
        super.setSize(width, height);
        super.setResizable(resizable);
        super.setVisible(true);
    }

    /**
     * Center the Frame
     */
    public void centerWindow() {
        this.setLocationRelativeTo(null);
    }

}
