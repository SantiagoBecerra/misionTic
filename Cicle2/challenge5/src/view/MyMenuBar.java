package view;
import controller.Actions;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyMenuBar extends JMenuBar {
    private JMenu file;
    private JMenuItem InfoLider, InfoPjs, infoPurchaseByPj;
    public MyMenuBar(ActionListener actionListener) {

        file = new JMenu("File");

        InfoLider = new JMenuItem("Mostrar Inf 1");
        InfoLider.setActionCommand(Actions.SHOW_FIRST.toString());
        InfoLider.addActionListener(actionListener);
        InfoPjs = new JMenuItem("Mostrar Inf 2");
        InfoPjs.setActionCommand(Actions.SHOW_SECOND.toString());
        InfoPjs.addActionListener(actionListener);

        infoPurchaseByPj = new JMenuItem("Mostrar Inf 3");
        infoPurchaseByPj.setActionCommand(Actions.SHOW_THIRD.toString());
        infoPurchaseByPj.addActionListener(actionListener);

        file.add(InfoLider);
        file.add(InfoPjs);
        file.add(infoPurchaseByPj);

        add(file);
    }

}
