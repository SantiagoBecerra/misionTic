package view;

import model.vo.InfoLider;
import model.vo.InfoPjs;
import model.vo.PurchaseByPj;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JPanelTable extends JPanel {
    private final DefaultTableModel modelInfoLider, ModelInfoPj, modelPurchase;
    private final JTable table;

    public JPanelTable() {
        setLayout(new BorderLayout());
        setOpaque(false);
        modelInfoLider = new DefaultTableModel();
        ModelInfoPj = new DefaultTableModel();
        modelPurchase = new DefaultTableModel();
        Font fontHeader = new Font("Unispace", Font.BOLD, 20);
        table = new JTable();
        table.setOpaque(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setFont(fontHeader);
        table.getTableHeader().setOpaque(false);
        table.setRowHeight(40);
        table.setShowGrid(false);
        table.setFont(fontHeader);
        table.setFillsViewportHeight(true);
        table.setForeground(Color.decode("#ffffff"));
        table.setBackground(Color.decode("#94BC19"));
        ((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);
        JScrollPane jsp = new JScrollPane();
        //jsp.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jsp.setViewportView(table);
        jsp.setOpaque(false);
        jsp.getViewport().setOpaque(false);
        this.add(jsp, BorderLayout.CENTER);

    }

    public void changeColumnTableLider() {
        String[] headers = {"Id Lider", "Nombre", "Apellido", "Ciudad Residencia"};
        modelInfoLider.setColumnIdentifiers(headers);
        repaint();
    }

    public void changeColumnTablePjs() {
        String[] headers = {"Id Proyecto", "Constructora", "No Habitaciones", "Ciudad"};
        ModelInfoPj.setColumnIdentifiers(headers);
        repaint();
    }

    public void changeColumnTablePurchases() {
        String[] headers = {"Id Compra", "Constructora", "Banco Vinculado"};
        modelPurchase.setColumnIdentifiers(headers);
        repaint();
    }

    public void fillTableLider(ArrayList<InfoLider> infoLiders) {
        if (!infoLiders.isEmpty()) {
            changeColumnTableLider();

            table.setModel(modelInfoLider);
            modelInfoLider.setRowCount(0);
            for (InfoLider infoLider : infoLiders) {
                modelInfoLider.addRow(new Object[]{infoLider.getIdLider(), infoLider.getNombre(), infoLider.getApellido(),infoLider.getCiudadResi()});
            }
        }
        repaint();
        revalidate();
    }

    public void fillTablePjs(ArrayList<InfoPjs> pjs) {
        if (!pjs.isEmpty()) {
            changeColumnTablePjs();
            table.setModel(ModelInfoPj);
            ModelInfoPj.setRowCount(0);
            for (InfoPjs infoPjs : pjs) {
                ModelInfoPj.addRow(new Object[]{infoPjs.getIdPj(), infoPjs.getConstr(), infoPjs.getNoHab(),infoPjs.getCiudad()});
            }
        }
        repaint();
        revalidate();
    }
    public void fillTablePurchases(ArrayList<PurchaseByPj> purchaseByPjs) {
        if (!purchaseByPjs.isEmpty()) {
            changeColumnTablePurchases();
            table.setModel(modelPurchase);
            modelPurchase.setRowCount(0);
            for (PurchaseByPj purchaseByPj : purchaseByPjs) {
                modelPurchase.addRow(new Object[]{purchaseByPj.getIdCompra(),purchaseByPj.getConstr(),purchaseByPj.getBancoVinc()});
            }
        }
        repaint();
        revalidate();
    }
}
