package org.example;

public class Constants {
    public static String ANNETTE_RIOT_KEY = "RGAPI-25625b4b-67b9-4a06-bfa5-23358028c447";

    // API URLS
    public static String ACCOUNTV1_BYRIOTID_LINK = "https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/Agurin/EUW";
    public static String SUMMONERV4_BYPUUID_LINK = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";

    public static String region = "oc1";
    public static String FRAGMENT = "https://" + region + ".riotgames.com/lol/summoner/v4/summoners/by-puuid/";

    public enum Region
    {
        BR1("br1"),
        EUN1("eun1"),
        EUW1("euw1"),
        JP1("jp1"),
        KR("kr"),
        LA1("la1"),
        LA2("la2"),
        ME1("me1"),
        NA1("na1"),
        OC1("oc1"),
        PH2("ph2"),
        RU("ru"),
        SG2("sg2"),
        TH2("th2"),
        TR1("tr1"),
        TW2("tw2"),
        VN2("vn2");

        private String region;

        Region(String reg) {
            this.region = reg;
        }

        public String getRegion() {
            return region;
        }
    }
}

// public static String LEAGUEV4_BYSUMMONER_LINK = "https://euw1.api.riotgames.com/lol/league/v4/entries/by-summoner/OigSK2yFG6vJTzxCk5YDZEdm0Xv8PfrnKb6TWWCqxE40jPg";
// old ACCOUNTV1_BYRIOTID_LINK = "https://europe.api.riotgames.com/riot/account/v1/accounts/by-riot-id/Agurin/EUW"
// old SUMMONOVERV4_BYPUUID_LINK = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/B_BHDZwmQBwqszCtpjEHiTq1zZrcQZicLGyGhbA3M8jCk8WFRGGqoAA_uUc0vMzaVRBt7nZ_i_UMhA"
