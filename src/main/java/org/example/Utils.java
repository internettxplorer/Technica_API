package org.example;

import java.util.Scanner;

/**
 * Miscellaneous functions, probably waiting for proper organisation later on
 */
public class Utils {
    /**
     * Query the user for server region to access in the API.
     * Compares input to the Region enum and returns a string if found.
     * @return String from the Constants.Region enum, representing a server region,
     * or null if not found
     */
    public static String queryServerRegion() {
        String input;
        String region = null;
        Scanner scanner = new Scanner(System.in);

        // Query user for server region
        System.out.println("\nEnter server region: ");
        input = scanner.nextLine().toUpperCase();

        // Iterate through Region enum. If a match is found,
        for (Constants.Region reg : Constants.Region.values()) {
            if (reg.name().equals(input)) {
                Constants.Region regValue = Constants.Region.valueOf(input);
                region = regValue.getRegion();
            }
        }
        return region;
    }

    /**
     * Sets the server region of the provided Summoner if region is not null.
     * @param s Summoner instance to insert server region into
     */
    public static void setServerRegion(Summoner s) {
        String region = queryServerRegion();
        if (region != null) {
            s.setRegion(region);
        }
        else {
            throw new java.lang.Error("\nError: No region set");
        }
    }
}
