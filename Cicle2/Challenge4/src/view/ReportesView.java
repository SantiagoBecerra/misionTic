package view;

import controller.ReportesController;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

import java.sql.SQLException;

public class ReportesView {
    private ReportesController reportesController;
    public ReportesView() {
        reportesController = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco)  {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            try {
                for (ProyectoBancoVo vo: reportesController.findByBank(banco)){
                    System.out.println(vo.toString());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior)  {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %14s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            try {
                for (DeudasPorProyectoVo vo: reportesController.listByLimit(limiteInferior)){
                    System.out.println(vo.toString());
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void lideresQueMasGastan()  {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %14s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        try {
            for (ComprasDeLiderVo vo: reportesController.leaderMostSpend()){
                System.out.println(vo.toString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
