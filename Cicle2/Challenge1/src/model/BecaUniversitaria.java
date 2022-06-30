package model;

public class BecaUniversitaria {
    private int pTiempo = 0;
    private double pMonto,pInteres = 0.0;

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres) {
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }

    public BecaUniversitaria() {

    }

    public double calcularInteresCompuesto() {
        return Math.round(pMonto*(Math.pow(1+pInteres/100,pTiempo)-1));
    }

    public double calcularInteresSimple() {
        return Math.round(pMonto*pInteres/100*pTiempo);
    }
    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
        double response = Math.round(calcularInteresCompuesto()-calcularInteresSimple());
        String res = "La diferencia entre la proyección de interés compuesto e interés simple es: $" + response;
        return res;
    }
    public String compararInversion ( ){
        double response = Math.round(calcularInteresCompuesto()-calcularInteresSimple());
        if(response != 0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + response;
        }else{
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
    }

    public static void main(String[] args) {
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria(48,10000,2.0);
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        System.out.println(becaUniversitaria.compararInversion());
    }
}
