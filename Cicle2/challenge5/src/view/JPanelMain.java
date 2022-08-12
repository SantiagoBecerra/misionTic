package view;

import model.vo.InfoLider;
import model.vo.InfoPjs;
import model.vo.PurchaseByPj;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelMain extends JPanel {
    private Image img;
    private JPanelTable tablePanel;
    public JPanelMain() {
        this.setLayout(new BorderLayout());
        img = new ImageIcon(getClass().getResource("/img/back.jpg")).getImage();
        setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
        tablePanel = new JPanelTable();
        add(tablePanel);
    }

    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        setMinimumSize(getParent().getSize());
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
    public void fillTableLider(ArrayList<InfoLider> infoLiders) {
        tablePanel.fillTableLider(infoLiders);
    }

    public void fillTablePjs(ArrayList<InfoPjs> pjs) {
        tablePanel.fillTablePjs(pjs);
    }
    public void fillTablePurchases(ArrayList<PurchaseByPj> purchaseByPjs) {
        tablePanel.fillTablePurchases(purchaseByPjs);
    }

    public Image getImg() {
        return img;
    }

    public JPanelTable getTablePanel() {
        return tablePanel;
    }
}
