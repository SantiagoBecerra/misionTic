package run;

import util.JDBCUtilities;
import view.ReportesView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Run {
    public static void main(String[] args) throws SQLException {
        ReportesView reportesView = new ReportesView();
        reportesView.lideresQueMasGastan();
    }
}
