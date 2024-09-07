package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Try gameName = Agurin, tagLine = EUW (any should work though)
        Summoner summoner = new Summoner();
        APIRequestService.getAccountInfoByRiotID(summoner);
        APIRequestService.getSummonerInfoByPUUID(summoner);

        System.out.println("\n" + summoner);
    }
}




