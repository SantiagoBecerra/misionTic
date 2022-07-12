package model;

public class ComputadoresPortatiles extends Computadores{
    private int pulgadas =20;
    private boolean camaraITG;

    public ComputadoresPortatiles() {
        super();
    }

    public ComputadoresPortatiles(double precioBase,int peso) {
        super(precioBase,peso);
    }

    public ComputadoresPortatiles(double precioBase,int peso, char consumoW,int pulgadas,boolean camaraITG) {
        super(precioBase,peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;

    }

    @Override
    public double calcularPrecio() {
        double adicion = super.calcularPrecio();
        if(pulgadas > 40){
            adicion+= getPrecioBase()*.3;
        }
        if(camaraITG){
            adicion+=50;
        }
        return adicion;
    }

}
