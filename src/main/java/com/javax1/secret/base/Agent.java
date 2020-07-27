package com.javax1.secret.base;

import java.util.Set;

public class Agent {

    public static Briefcase getBriefcase() {
        return new Briefcase(new WeirdCube());
    }

    public static void check(String briefcaseContent) {
        if (!briefcaseContent.equals(WeirdCube.class.getSimpleName())) {
            throw new EndOfMissionException("You were unable to pass the necessary test to qualify for the mission.");
        }
    }

    public static void identify(String mods) {
        Set<String> split = Set.of(mods.split(" "));
        if (!split.stream().allMatch(Agent::modifiers) || split.size() < 3) {
            throw new EndOfMissionException("You fumbled your words and failed their evaluation.");
        }
    }

    private static boolean modifiers(String s) {
        return s.matches("(protected|static|final)");
    }

    public static void accuse(Suspect criminal) {
        if (criminal == null) {
            throw new EndOfMissionException("You were unable to point out anyone from the suspects and failed your evaluation.");
        }
        if (!Suspect.isGuilty(criminal)) {
            throw new EndOfMissionException("You accused the wrong suspect and failed your evaluation.");
        }
    }

    public static void checkDocuments(String docs) {
        if (!docs.equals("Very Secret Documents")) {
            throw new EndOfMissionException("You did not steal the documents from the safe!");
        }
    }
}
