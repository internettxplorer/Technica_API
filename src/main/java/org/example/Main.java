package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Summoner summoner = new Summoner();
        APIRequestService.getAccountInfoByRiotID(summoner);
        APIRequestService.getSummonerInfoByPUUID(summoner);

//        APIRequestService.createNewSummoner();
//        String puuid = RequestHandler.getAccountInfoByRiotID();
//        String info = RequestHandler.getSummonerInfoByPUUID();
//         System.out.println(puuid + "\n");
//        System.out.println(info);
//
//        System.out.println(puuid + info);

    }
}




