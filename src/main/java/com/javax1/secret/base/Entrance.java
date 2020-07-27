package com.javax1.secret.base;

public class Entrance {
    private static final String PASSWORD = "я служу советскому союзу";

    public static void enter(String phrase) {
        if (!phrase.equals(PASSWORD)) {
            throw new EndOfMissionException("You were apprehended at the entrance.");
        }
    }
}
