package model;

public class PrecioTotal {
    private Double totalComputadores = 0.0;
    private Double totalComputadoresPortatiles = 0.0;
    private Double totalComputadoresMesa = 0.0;
    private Computadores[] listaComputadores;

    public PrecioTotal(Computadores[] pComputadores) {
        this.listaComputadores = pComputadores;
    }

    public void mostrarTotales() {
        for(int i = 0; i<listaComputadores.length;i++){
            totalComputadores += listaComputadores[i].calcularPrecio() + listaComputadores[i].getPrecioBase();
            if(listaComputadores[i] instanceof ComputadoresMesa){
                totalComputadoresMesa += listaComputadores[i].calcularPrecio() + listaComputadores[i].getPrecioBase();

            }else if(listaComputadores[i] instanceof ComputadoresPortatiles){
                totalComputadoresPortatiles += listaComputadores[i].calcularPrecio() + listaComputadores[i].getPrecioBase() ;
            }
        }
        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " +
                totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " +
                totalComputadoresPortatiles);
    }
}
