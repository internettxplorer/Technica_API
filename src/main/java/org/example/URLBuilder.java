package org.example;

import java.util.Scanner;

public class URLBuilder {
    /**
     * Query user for Riot username and tagline to search.
     * @return URL formatted with inputted username and tagline
     */
    public static String buildAccountQueryURL() {
        String url;
        String username;
        String tagline;

        Scanner scanner = new Scanner(System.in);

        // Query user for Riot ID
        System.out.println("\nEnter Riot username: ");
        username = scanner.nextLine();
        System.out.println("\nEnter tagline: ");
        tagline = scanner.nextLine();

        // Build URL
        url = Constants.ACCOUNTV1_BYRIOTID_LINK + username + "/" + tagline;

        return url;
    }

    public static String buildSummonerQueryURL(Summoner s) {
        String region = s.getRegion();
        String puuid = s.getPuuid();

        return "https://" + region + Constants.SUMMONERV4_BYPUUID_LINK + puuid;
    }
}
