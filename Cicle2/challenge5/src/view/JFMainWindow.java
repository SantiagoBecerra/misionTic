package view;

import model.vo.InfoLider;
import model.vo.InfoPjs;
import model.vo.PurchaseByPj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JFMainWindow extends JFrame {
    private JPanelMain jPanelMain;

    public JFMainWindow(ActionListener actionListener) throws HeadlessException {
        setTitle("Challenge 5");
        jPanelMain = new JPanelMain();
        setExtendedState(MAXIMIZED_BOTH);
        setJMenuBar(new MyMenuBar(actionListener));
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/icon.png"));
        setIconImage(icon);
        this.add(jPanelMain);
        setVisible(true);
    }
    public void fillTableLider(ArrayList<InfoLider> infoLiders) {
        jPanelMain.fillTableLider(infoLiders);
    }

    public void fillTablePjs(ArrayList<InfoPjs> pjs) {
        jPanelMain.fillTablePjs(pjs);
    }
    public void fillTablePurchases(ArrayList<PurchaseByPj> purchaseByPjs) {
        jPanelMain.fillTablePurchases(purchaseByPjs);
    }

}
