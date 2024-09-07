package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Scanner;

public class APIRequestService {

    public APIRequestService() {} // Empty constructor for now - not sure if needed.

    /**
     * Sends a GET request to the Riot API to the provided endpoint.
     * @return JSON response body as string
     */
    public static String sendGetRequest(String requestLink) throws IOException {
        String json;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header("X-Riot-Token", Constants.ANNETTE_RIOT_KEY)
                .url(requestLink)
                .build();

        Response response = client.newCall(request).execute();

        if (response.body() != null) {
            json = response.body().string();
        }
        else {
            json = "Error fetching API data from " + requestLink;
        }

        return json;
    }

    /**
     * Query user for Riot in-game username and tagline.
     */
    public static String buildQueryURL() {
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

    /**
     * Get a player's PUUID, in-game name, and tagline.
     * @return formatted JSON string
     * TODO: Dynamic request link to get different regions (NA/EU)
     * TODO: Dynamic request link with user input for gameName and tagLine
     * TODO: Refactor Summoner class/Deserialisation method as needed
     * **/
    public static String getAccountInfoByRiotID() throws IOException {
        String formattedJson;
        String url = buildQueryURL();
        String json = sendGetRequest(url);

        // remove curly braces
        formattedJson = json.replaceAll("[{}]", "");

        return formattedJson;
    }

    /**
     * Get summoner's account ID, summoner ID, and summoner level using their encrypted PUUID.
     * @return formatted JSON string
     */
    public static String getSummonerInfoByPUUID() throws IOException {
        String formattedJson;
        String summonerID;
        String accountID;
        int summonerLevel;

        // String puuid = Summoner.getPuuid();

        String json = sendGetRequest(Constants.SUMMONERV4_BYPUUID_LINK);

        JsonObject jsonObj = new Gson().fromJson(json, JsonObject.class);

        // Extracts summoner ID, account ID, and summonerLevel from response body
        // Also converts them to the appropriate type.
        summonerID = jsonObj.get("id").getAsString();
        accountID = jsonObj.get("accountId").getAsString();
        summonerLevel = jsonObj.get("summonerLevel").getAsInt();

        // id , accountId, summonerLevel as string acceptable by gson
        formattedJson = String.format("\"summonerId\": \"%s\", \"accountId\": \"%s\", \"summonerLevel\": %d",
                summonerID, accountID, summonerLevel);

        return formattedJson;
    }

    /**
     * Deserialises the provided JSON string and inserts its values into the Summoner class.
     */
    public static void createNewSummoner() throws IOException {
        Gson gson = new Gson();

        String accountInfo = getAccountInfoByRiotID();
        String summonerInfo = getSummonerInfoByPUUID();
        String formatted = "{" + accountInfo + ", " + summonerInfo + "}";

        Summoner sr = gson.fromJson(formatted, Summoner.class);

        System.out.println("\nJSON String:\n" + formatted);
        System.out.println("\n" + sr);
    }

}
