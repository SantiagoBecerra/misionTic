package controller;

import model.dao.ComprasDeLiderDao;
import model.dao.DeudasPorProyectoDao;
import model.dao.ProyectoBancoDao;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesController {
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ProyectoBancoDao proyectoBancoDao;

    public ReportesController() {
        comprasDeLiderDao = new ComprasDeLiderDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        proyectoBancoDao = new ProyectoBancoDao();
    }
    public ArrayList<ComprasDeLiderVo> leaderMostSpend() throws SQLException {
        return comprasDeLiderDao.leaderMostSpend();
    }
    public ArrayList<DeudasPorProyectoVo> listByLimit(double limit) throws SQLException {
        return deudasPorProyectoDao.listByLimit(limit);
    }
    public ArrayList<ProyectoBancoVo> findByBank(String bank) throws SQLException {
        return proyectoBancoDao.findByBank(bank);
    }

}
