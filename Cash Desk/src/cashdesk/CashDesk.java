package cashdesk;

import cashdesk.DataHolder;
import cashdesk.Frame;
import cashdesk.desk.ControlLayout;
import cashdesk.desk.ListLayout;
import cashdesk.desk.MainLayout;
import cashdesk.desk.ProductLayout;

import javax.swing.*;
import java.awt.*;

/**
 * The CashDesk Class
 */
public class CashDesk {
    /* It's unnecessary */
    private MainLayout mLayout;
    private ProductLayout pLayout;
    private ListLayout lLayout;
    private ControlLayout cLayout;

    /* This has to be stored as a reference, as it's used by multiple classes */
    private DefaultListModel listModel;
    private DataHolder dataHolder;

    /**
     * Create the Cash desk
     */
    public CashDesk() {
        this.listModel = new DefaultListModel();
        this.dataHolder = new DataHolder();

        /* Create the partial layouts */
        this.mLayout = new MainLayout();
        this.pLayout = new ProductLayout(listModel);
        this.lLayout = new ListLayout(390, listModel);
        this.cLayout = new ControlLayout(listModel, dataHolder);

        /* Combine them into the main Layout */
        this.mLayout.addPanel(this.pLayout, new Dimension(390, 40));
        this.mLayout.addSpacer(5);
        this.mLayout.addPanel(this.lLayout, new Dimension(390, 200));
        this.mLayout.addSpacer(5);
        this.mLayout.addPanel(this.cLayout, new Dimension(390, 50));

        Frame f = new Frame(400, 300, "Cash Desk", mLayout);
    }
}
