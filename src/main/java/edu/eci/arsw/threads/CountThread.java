package edu.eci.arsw.threads;


public class CountThread extends Thread {

    // Variables para guardar el rango de numeros entre a y b
    private int a;
    private int b;

    // Constructor que recibe el rango
    public CountThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // ejecucion del hilo
    @Override
    public void run() {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }
}

