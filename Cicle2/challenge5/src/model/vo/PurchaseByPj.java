package model.vo;

public class PurchaseByPj {
    private int idCompra;
    private String constr;
    private String bancoVinc;

    public PurchaseByPj(int idCompra, String constr, String bancoVinc) {
        this.idCompra = idCompra;
        this.constr = constr;
        this.bancoVinc = bancoVinc;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public String getConstr() {
        return constr;
    }

    public String getBancoVinc() {
        return bancoVinc;
    }
}
