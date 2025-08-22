/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {

    private static final int BLACK_LIST_ALARM_COUNT = 5;

    public List<Integer> checkHost(String ipaddress, int N) {
        LinkedList<Integer> blackListOcurrences = new LinkedList<>();
        HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();

        int registeredServersCount = skds.getRegisteredServersCount();
        int range = registeredServersCount / N;

        List<SearchThread> threads = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int start = i * range;
            int end = (i == N - 1) ? registeredServersCount : (i + 1) * range;

            SearchThread st = new SearchThread(start, end, ipaddress, skds);
            threads.add(st);
            st.start();
        }
        for (SearchThread st : threads) {
            try {
                st.join();
                blackListOcurrences.addAll(st.getOcurrences());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (blackListOcurrences.size() >= BLACK_LIST_ALARM_COUNT) {
            System.out.println("La dirección IP: " + ipaddress + " es NO confiable.");
        } else {
            System.out.println("La dirección IP: " + ipaddress + " es confiable.");
        }

        System.out.println("Número de listas negras revisadas: "
                + registeredServersCount + " de " + registeredServersCount);

        return blackListOcurrences;
    }
}