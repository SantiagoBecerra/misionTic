package run;

import view.ReportesView;
import java.sql.SQLException;

public class Run {
    public static void main(String[] args) throws SQLException {
        ReportesView reportesView = new ReportesView();
        reportesView.lideresQueMasGastan();
    }
}
