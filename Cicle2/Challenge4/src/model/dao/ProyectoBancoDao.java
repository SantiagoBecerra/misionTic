package model.dao;

import model.vo.ProyectoBancoVo;
import util.JDBCUtilities;

import java.sql.*;
import java.util.ArrayList;

public class ProyectoBancoDao {

    public ProyectoBancoDao() {
    }
    public ArrayList<ProyectoBancoVo>  findByBank(String bank) throws SQLException {
        ArrayList<ProyectoBancoVo> proyectoBancoVos = new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT p.ID_Proyecto ID, p.Constructora , p.Ciudad  ,p.Clasificacion ,t.Estrato, l.Nombre ||' '|| l.Primer_Apellido || ' ' || l.Segundo_Apellido \n" +
                "FROM Proyecto p ,Lider l,Tipo t\n" +
                "WHERE p.ID_Lider = l.ID_Lider \n" +
                "AND p.ID_Tipo = t.ID_Tipo \n" +
                "AND p.Banco_Vinculado = ? \n" +
                "ORDER BY p.Fecha_Inicio DESC ,p.Ciudad,p.Constructora";

        PreparedStatement statement = c.prepareStatement(sql);
        statement.setString(1, bank);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            ProyectoBancoVo vo = new ProyectoBancoVo(rs.getInt(1),rs.getString(2),rs.getString(3)
            ,rs.getString(4),rs.getInt(5),rs.getString(6));
            proyectoBancoVos.add(vo);
        }
        rs.close();
        statement.close();
        return proyectoBancoVos;
    }

}
