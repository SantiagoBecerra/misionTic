package model.vo;

public class InfoLider {
    private int idLider;
    private String nombre;
    private String apellido;
    private String ciudadResi;

    public InfoLider(int idLider, String nombre, String apellido, String ciudadResi) {
        this.idLider = idLider;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudadResi = ciudadResi;
    }

    public int getIdLider() {
        return idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCiudadResi() {
        return ciudadResi;
    }
}
