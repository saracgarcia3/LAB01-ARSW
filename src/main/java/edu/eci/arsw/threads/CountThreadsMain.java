package edu.eci.arsw.threads;

public class CountThreadsMain {
    public static void main(String[] args) {
        
        // se crean los 3 hilos solicitados del ejercicio 
        CountThread t1 = new CountThread(0, 99);
        CountThread t2 = new CountThread(100, 199);
        CountThread t3 = new CountThread(200, 299);

        // Se inicia cada hilo con start() y luego run()
        t1.run();
        t2.run();
        t3.run();;

        
    }
}

