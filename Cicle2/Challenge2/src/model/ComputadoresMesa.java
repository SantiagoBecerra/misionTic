package model;

public class ComputadoresMesa extends Computadores{
    private int almacenamiento = 50;

    public ComputadoresMesa() {
        super();
    }

    public ComputadoresMesa(double precioBase,int peso) {
        super(precioBase,peso);
    }

    public ComputadoresMesa(double precioBase,int peso, char consumoW,int almacenamiento) {
        super(precioBase,peso, consumoW);
        this.almacenamiento = almacenamiento;
    }

    @Override
    public double calcularPrecio() {
        double adicion = super.calcularPrecio();
        if (almacenamiento > 100){
            adicion += 100;
        }
        return adicion;
    }
}
