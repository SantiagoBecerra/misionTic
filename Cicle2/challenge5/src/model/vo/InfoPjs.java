package model.vo;

public class InfoPjs {
    private int idPj;
    private String constr;
    private int NoHab;
    private String ciudad;

    public InfoPjs(int idPj, String constr, int noHab, String ciudad) {
        this.idPj = idPj;
        this.constr = constr;
        NoHab = noHab;
        this.ciudad = ciudad;
    }

    public int getIdPj() {
        return idPj;
    }

    public String getConstr() {
        return constr;
    }

    public int getNoHab() {
        return NoHab;
    }

    public String getCiudad() {
        return ciudad;
    }
}
