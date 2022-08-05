package model.vo;

public class DeudasPorProyectoVo {
    private int id;
    private double valor;

    public DeudasPorProyectoVo(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%3d %,15.1f", id, valor);
    }
}
