package model.dao;

import model.vo.InfoLider;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InfoLiderDao {
    public InfoLiderDao() {
    }
    public ArrayList<InfoLider> getInfoLider() throws SQLException {
        ArrayList<InfoLider> infoLiders = new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT ID_Lider,Nombre,Primer_Apellido,Ciudad_Residencia FROM Lider order by Ciudad_Residencia;";
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            InfoLider infoLider = new InfoLider(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            infoLiders.add(infoLider);
        }
        rs.close();
        statement.close();
        return infoLiders;
    }


}
