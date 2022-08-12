package model.dao;

import model.vo.InfoLider;
import model.vo.InfoPjs;
import util.JDBCUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InfoPjsDao {
    public InfoPjsDao() {
    }
    public ArrayList<InfoPjs> getInfoPjs() throws SQLException {
        ArrayList<InfoPjs> infoPjs = new ArrayList<>();
        Connection c = JDBCUtilities.getConnection();
        String sql = "SELECT ID_Proyecto, Constructora,Numero_Habitaciones,Ciudad FROM Proyecto\n" +
                "WHERE Clasificacion = 'Casa Campestre'\n" +
                "AND Ciudad = 'Santa Marta' OR  Ciudad = '“Barranquilla”' OR Ciudad = 'Cartagena'";
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            InfoPjs infoPj = new InfoPjs(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
            infoPjs.add(infoPj);
        }
        rs.close();
        statement.close();
        return infoPjs;
    }
}
