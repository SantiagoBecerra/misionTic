package controller;

import model.dao.InfoLiderDao;
import model.dao.InfoPjsDao;
import model.dao.PurchaseByPjDao;
import view.JFMainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Controller implements ActionListener {
    private InfoLiderDao infoLiderDao;
    private InfoPjsDao infoPjsDao;
    private PurchaseByPjDao purchaseByPjDao;
    private JFMainWindow jfMainWindow;

    public Controller() throws SQLException {
        infoLiderDao = new InfoLiderDao();
        infoPjsDao = new InfoPjsDao();
        purchaseByPjDao = new PurchaseByPjDao();
        jfMainWindow = new JFMainWindow(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Actions.valueOf(e.getActionCommand())){
            case SHOW_FIRST:
                try {
                    showFirst();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case SHOW_SECOND:
                try {
                    showSecond();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case SHOW_THIRD:
                try {
                    showThird();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:break;
        }
    }

    private void showThird() throws SQLException {
        jfMainWindow.fillTablePurchases(purchaseByPjDao.getPurchases());

    }

    private void showSecond() throws SQLException {
        jfMainWindow.fillTablePjs(infoPjsDao.getInfoPjs());
    }

    private void showFirst() throws SQLException {
        jfMainWindow.fillTableLider(infoLiderDao.getInfoLider());
    }
}
