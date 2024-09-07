package org.example;

public class Summoner {
    // Credentials
    private String puuid;
    private String accountId;
    private String summonerId;

    // Account information
    private String gameName;
    private String tagLine;
    private int summonerLevel;

    // initialise class with empty values, populated later through the API
    public Summoner() {
        puuid = "";
        accountId = "";
        summonerId = "";
        gameName = "";
        tagLine = "";
        summonerLevel = 0;
    }

    public String getPuuid() { return puuid; }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }



    @Override
    public String toString() {
        return "\nSummoner class values:" + "\nPUUID: " + puuid + "\nAccount ID: " + accountId + "\nSummoner ID: " + summonerId
                + "\nGame name: " + gameName + "\nTag: " + tagLine + "\nSummoner level: " + summonerLevel;
    }
}

