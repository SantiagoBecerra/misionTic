package model.dao;

import model.vo.ComprasDeLiderVo;
import util.JDBCUtilities;

import java.sql.*;
import java.util.ArrayList;

public class ComprasDeLiderDao {
    public ComprasDeLiderDao() {
    }
    public ArrayList<ComprasDeLiderVo> leaderMostSpend() throws SQLException {
        ArrayList<ComprasDeLiderVo> comprasDeLiderVos= new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT l.Nombre ||' '|| l.Primer_Apellido || ' ' || l.Segundo_Apellido LIDER,  SUM(c.Cantidad*mc.Precio_Unidad) VALOR\n" +
                "FROM Proyecto p , Lider l , Compra c, MaterialConstruccion mc\n" +
                "WHERE c.ID_Proyecto = p.ID_Proyecto\n" +
                "  AND p.ID_Lider  = l.ID_Lider\n" +
                "  AND c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion\n" +
                "GROUP BY LIDER\n" +
                "ORDER BY SUM(c.Cantidad*mc.Precio_Unidad) DESC LIMIT 10";

        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            ComprasDeLiderVo cl = new ComprasDeLiderVo(rs.getString(1),rs.getDouble(2));
            comprasDeLiderVos.add(cl);
        }
        rs.close();
        statement.close();
        return comprasDeLiderVos;
    }
}
