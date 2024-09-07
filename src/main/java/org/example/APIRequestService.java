package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Scanner;

public class APIRequestService {

    public APIRequestService() {} // Empty constructor for now - not sure if needed.

    /**
     * Sends a GET request to the Riot API to the provided URL.
     * @param requestLink API request link
     * @return JSON response body as string
     */
    public static String sendGetRequest(String requestLink) throws IOException {
        String json;

        OkHttpClient client = new OkHttpClient();

        // Build GET request
        Request request = new Request.Builder()
                .header("X-Riot-Token", Constants.ANNETTE_RIOT_KEY)
                .url(requestLink)
                .build();

        // Send request to client, if successful parse as string
        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                json = response.body().string();
            } else {
                json = "Error fetching API data from " + requestLink;
            }
        }

        return json;
    }

    /**
     * Query user for Riot username and tagline to search.
     * @return URL formatted with inputted username and tagline
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
     * Get a player's PUUID, in-game name, and tagline based on user input.
     * @param summoner Summoner instance to insert API response body into
     * **/
    public static void getAccountInfoByRiotID(Summoner summoner) throws IOException {
        String formattedJson;

        // query user for RiotID and send GET request to API
        String url = buildQueryURL();
        String json = sendGetRequest(url);

        // remove curly braces from json
        formattedJson = json.replaceAll("[{}]", "");

        // insert response body into Summoner object
        fromJsonToSummoner(formattedJson, summoner);
    }

    /**
     * Get summoner's account ID, summoner ID, and summoner level using their encrypted PUUID.
     * @return formatted JSON string
     */
    public static void getSummonerInfoByPUUID(Summoner summoner) throws IOException {
        // Build API request url from base link and summoner PUUID
        String puuid = summoner.getPuuid();
        String url = Constants.SUMMONERV4_BYPUUID_LINK + puuid;
        String formattedJson;

        String json = sendGetRequest(url);

        // remove curly braces from json
        formattedJson = json.replaceAll("[{}]", "");

        // insert response body into Summoner object
        fromJsonToSummoner(formattedJson, summoner);
    }

    /**
     * Formats and deserialises specified JSON string into an object of the specified class.
     * @param json Comma separated JSON string with key-value pairs. Any braces/brackets must be removed.
     * @param summoner Summoner class to insert deserialised values into.
     */
    public static void fromJsonToSummoner(String json, Summoner summoner) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String formatted = "{" + json + "}";
        // update Summoner instance with the values inside the provided JSON
        summoner = objectMapper.readerForUpdating(summoner).readValue(formatted);
    }

}
