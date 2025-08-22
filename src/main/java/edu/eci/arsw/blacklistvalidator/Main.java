/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

/**
 *
 * @author hcadavid
 */
public class Main {
    public static void main(String[] args) {
        HostBlackListsValidator validator = new HostBlackListsValidator();

        String ip = "202.24.34.55";  // IP fija de prueba
        int nThreads = 8;           // Número fijo de hilos

        System.out.println("Verificando IP: " + ip + " con " + nThreads + " hilos...");
        validator.checkHost(ip, nThreads);
    }
}
