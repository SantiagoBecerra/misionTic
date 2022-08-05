package model.dao;

import model.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeudasPorProyectoDao {
    public DeudasPorProyectoDao() {
    }

    public ArrayList<DeudasPorProyectoVo> listByLimit(double limit) throws SQLException {
        ArrayList<DeudasPorProyectoVo> deudasPorProyectoVos = new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT p.ID_Proyecto,SUM(c.Cantidad*mc.Precio_Unidad) AS VALOR\n" +
                "FROM Compra c ,Proyecto p , MaterialConstruccion mc\n" +
                "WHERE c.ID_Proyecto = p.ID_Proyecto \n" +
                "AND c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion \n" +
                "AND c.Pagado = 'No'\n" +
                "GROUP BY p.ID_Proyecto\n" +
                "HAVING SUM(c.Cantidad*mc.Precio_Unidad) > ?\n" +
                "ORDER BY SUM(c.Cantidad*mc.Precio_Unidad) DESC";

        PreparedStatement statement = c.prepareStatement(sql);
        statement.setDouble(1, limit);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            DeudasPorProyectoVo dp = new DeudasPorProyectoVo(rs.getInt(1),rs.getDouble(2));
            deudasPorProyectoVos.add(dp);
        }
        rs.close();
        statement.close();
        return deudasPorProyectoVos;
    }

}
