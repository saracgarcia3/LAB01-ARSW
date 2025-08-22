package edu.eci.arsw.blacklistvalidator;

import java.util.List;

//Mirar los casos de n hilos

public class PerformanceEvaluator {

    public static void main(String[] args) {
        // Número de hilos fijo 

        int nThreads = Runtime.getRuntime().availableProcessors() * 2;

        String ip = "202.24.34.55"; // dirección IP de prueba
        HostBlackListsValidator validator = new HostBlackListsValidator();

        long startTime = System.currentTimeMillis();

        List<Integer> ocurrences = validator.checkHost(ip, nThreads);

        long endTime = System.currentTimeMillis();

        System.out.println(">>> IP evaluada: " + ip);
        System.out.println(">>> Número de hilos: " + nThreads);
        System.out.println(">>> Tiempo de ejecución: " + (endTime - startTime) + " ms");
        System.out.println(">>> Total ocurrencias: " + ocurrences.size());
    }
}
