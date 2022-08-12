package model.dao;

import model.vo.InfoPjs;
import model.vo.PurchaseByPj;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PurchaseByPjDao {
    public PurchaseByPjDao() {
    }
    public ArrayList<PurchaseByPj> getPurchases() throws SQLException {
        ArrayList<PurchaseByPj> purchaseByPjs = new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT c.ID_Compra,p.Constructora,p.Banco_Vinculado FROM Proyecto p,Compra c\n" +
                "WHERE p.ID_Proyecto = c.ID_Proyecto\n" +
                "AND c.Proveedor = 'Homecenter'\n" +
                "AND p.Ciudad = 'Salento'";
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            PurchaseByPj purchaseByPj = new PurchaseByPj(rs.getInt(1),rs.getString(2),rs.getString(3));
            purchaseByPjs.add(purchaseByPj);
        }
        rs.close();
        statement.close();
        return purchaseByPjs;
    }
}
