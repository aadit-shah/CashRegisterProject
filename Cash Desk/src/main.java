import cashdesk.*;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        CashDesk cd = new CashDesk();
    }
}
