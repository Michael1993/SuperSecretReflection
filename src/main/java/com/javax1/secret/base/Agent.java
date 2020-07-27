package com.javax1.secret.base;

import java.util.Set;

public class Agent {

    public static Briefcase getBriefcase() {
        return new Briefcase(new WeirdCube());
    }

    public static void check(String briefcase) {
        if (!briefcase.equals(WeirdCube.class.getSimpleName())) {
            throw new EndOfMissionException("Agent 42 was unable to pass the necessary test to qualify for the mission.");
        }
    }

    public static void identify(Set<String> mods) {
        if (!mods.stream().allMatch(Agent::modifiers) || mods.size() < 3) {
            throw new EndOfMissionException("Agent 42 fumbled their words and failed their evaluation.");
        }
    }

    private static boolean modifiers(String s) {
        return s.matches("(protected|static|final)");
    }

    public static void accuse(Suspect criminal) {
        if (criminal == null) {
            throw new EndOfMissionException("Agent 42 was unable to point out anyone from the suspects and failed their evaluation.");
        }
        if (!Suspect.isGuilty(criminal)) {
            throw new EndOfMissionException("Agent 42 accused the wrong suspect and failed their evaluation.");
        }
    }
}
