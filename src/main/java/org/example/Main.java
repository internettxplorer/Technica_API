package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Try gameName = Agurin, tagLine = EUW (any should work though)
//        System.out.println(APIRequestService.queryServerRegion());
        Summoner summoner = new Summoner();
        APIRequestService.getAccountInfoByRiotID(summoner);
//        Utils.setServerRegion(summoner);
//        System.out.println("\n" + summoner.getRegion());
//        APIRequestService.getSummonerInfoByPUUID(summoner);
//        System.out.println("\n" + summoner);
    }
}




