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

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public Summoner() {}

    @Override
    public String toString() {
        return "\nSummoner class values:" + "\nPUUID: " + puuid + "\nAccount ID: " + accountId + "\nSummoner ID: " + summonerId
                + "\nGame name: " + gameName + "\nTag: " + tagLine + "\nSummoner level: " + summonerLevel;
    }
}

