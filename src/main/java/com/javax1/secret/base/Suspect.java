package com.javax1.secret.base;

import java.util.List;

public class Suspect {
    public static List<Suspect> list() {
        return List.of(
                new Innocent(),
                new Innocent(),
                new Innocent(),
                new Guilty(),
                new Innocent()
        );
    }

    public static boolean isGuilty(Suspect criminal) {
        return criminal.getClass().equals(Guilty.class);
    }

    private static class Innocent extends Suspect {
        public final String alibi = "I am innocent!";
    }

    private static class Guilty extends Suspect {
    }
}
