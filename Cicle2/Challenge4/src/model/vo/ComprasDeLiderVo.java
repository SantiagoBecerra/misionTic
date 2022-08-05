package model.vo;

public class ComprasDeLiderVo {
    private String lider;
    private double valor;

    public ComprasDeLiderVo(String lider, double valor) {
        this.lider = lider;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return String.format("%-25s %,15.1f", lider, valor);
    }
}
