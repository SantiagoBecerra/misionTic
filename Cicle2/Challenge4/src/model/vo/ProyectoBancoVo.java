package model.vo;

public class ProyectoBancoVo {

    private int id;
    private String constructora;
    private String ciudad;
    private String clasificacion;
    private int estrato;
    private String lider;

    public ProyectoBancoVo(int id, String constructora, String ciudad, String clasificacion, int estrato, String lider) {
        this.id = id;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.clasificacion = clasificacion;
        this.estrato = estrato;
        this.lider = lider;
    }

    @Override
    public String toString() {
        return String.format("%3d %-25s %-20s %-15s %7d %-30s", id, constructora, ciudad,
                clasificacion, estrato, lider);
    }
}
