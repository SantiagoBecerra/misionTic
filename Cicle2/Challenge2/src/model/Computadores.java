package model;

public class Computadores {
    private int peso = 5;
    private char consumoW = 'F';
    private double precioBase = 100;

    public Computadores() {
    }
    public Computadores(double precioBase,int peso ) {
        this.peso = peso;
        this.precioBase = precioBase;
    }

    public Computadores(double precioBase,int peso, char consumoW) {
        this.peso = peso;
        this.consumoW = consumoW;
        this.precioBase = precioBase;
    }
    public double calcularPrecio(){
        double adicion = 0.0;
        switch(consumoW){
            case 'A':
                adicion += 100;
                break;
            case 'B':
                adicion += 80;
                break;
            case 'C':
                adicion += 60;
                break;
            case 'D':
                adicion += 50;
                break;
            case 'E':
                adicion += 30;
                break;
            case 'F':
                adicion += 10;
                break;
            default:break;
        }
        if(peso>=0 && peso < 19){
            adicion += 10;
        }else if(peso>=20 && peso < 49){
            adicion += 50;
        }
        else if(peso>=50 && peso <=79){
            adicion += 80;
        }else if(peso >= 80){
            adicion += 100;
        }
        return adicion;
    }
    public double getPrecioBase() {
        return precioBase;
    }
}
