package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    private static final String UBICACION_BD = "D:/Documentos/Hellous/UselessData/isNotImportantThat/isGreat/SBV/MisionTic/Narrativas/ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
