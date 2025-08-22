package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;

public class SearchThread extends Thread {
    private int start;
    private int end;
    private String ip;
    private HostBlacklistsDataSourceFacade skds;
    private List<Integer> occurrences;

    public SearchThread(int start, int end, String ip, HostBlacklistsDataSourceFacade skds) {
        this.start = start;
        this.end = end;
        this.ip = ip;
        this.skds = skds;
        this.occurrences = new LinkedList<>();
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (skds.isInBlackListServer(i, ip)) {
                occurrences.add(i);
            }
        }
    }

    public List<Integer> getOcurrences() {
        return occurrences;
    }
}