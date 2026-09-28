package com.example.thedicegame.modelo;
import java.util.Random;
public class Dado {
    private int caras;
    private int valorActual;
    private Random random;

    /**
     * Constructor de un dado de seis caras.
     */
    public Dado() {
        this.caras = 6;
        this.random = new Random();
    }

    /**
     * Realiza un lanzamiento de dado.
     * @return El valor del dado, un número aleatorio entre 1 y 6.
     */
    public int lanzar() {
        this.valorActual = this.random.nextInt(this.caras) + 1;
        return this.valorActual;
    }

    /**
     *
     * @return El valor actual del dado.
     */
    public int getValorActual() {
        return this.valorActual;
    }
}
