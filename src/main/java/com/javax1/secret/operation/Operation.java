package com.javax1.secret.operation;

import com.javax1.secret.base.*;
import com.javax1.secret.help.Help;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operation {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //interceptedCommunications();
        //identifyObject();
        describeObject();
        interviewSuspects();
    }

    /**
     * We have intercepted several different communications. It's all a giant mess.
     * We don't want to work with e-mails or letters, only phone calls.
     * Can you help the agency find only the relevant communications?
     */
    public static void interceptedCommunications() {
        /*
            Types of communications:
                - Communication.EMail
                - Communication.PhoneCall
                - Communication.MorseCode
                - etc.
         */
        List<Communication> communications = Communication.intercepted();
        List<Communication> calls = communications.stream()
                .filter(communication -> true) // We only want phone calls (and exactly phone calls)!
                .collect(Collectors.toList());
        Communication.verify(calls);
    }

    /**
     * Before Agent 42 can go back into the field they have to pass an evaluation.
     * The first task is identifying what kind of object is inside a briefcase.
     * What could it be? Can you help Agent 42?
     */
    public static void identifyObject() {
        Object content = Agent.getBriefcase().getContent();
        Agent.check(content.toString()); // We are looking for a simple solution here.
    }

    /**
     * The seconds task of the evaluation is properly describing an object.
     * Writing a proper field report is crucial in intelligence organizations.
     * What kind of {@code Modifier}s does this unidentified object have?
     */
    public static void describeObject() {
        Object task = Unidentified.get();
        String mods = Modifier.toString(task.getClass().getModifiers()); // We need the modifiers... but as strings.
        Set<String> split = Set.of(mods.split(" "));
        Agent.identify(split);
    }

    /**
     * The third and final task is to interview a list of suspects.
     * Who has an alibi and who does not?
     * The alibi is not a secret (it's {@code public}).
     */
    public static void interviewSuspects() {
        final String NAME_OF_FIELD = "ALIBI";
        List<Suspect> suspects = Suspect.list();
        Suspect criminal = suspects.stream()
                .filter(suspect -> Stream.of(suspect.getClass().getDeclaredFields())
                        .noneMatch(field -> field.getName().equals(NAME_OF_FIELD))) // Do all of them have alibis?
                .findAny().orElse(null);
        Agent.accuse(criminal);
    }

    /**
     * We have to enter the base first. To do that, we need to know the {@code PASSWORD}.
     * We know that people entering the {@code Entrance} say this password, so
     * just listen in and maybe we can hear it?
     */
    public static void enter() throws NoSuchFieldException, IllegalAccessException {
        final String NAME_OF_FIELD = "PASSWORD";
        String phrase = "Open, sesame!"; // We need to listen at the Entrance...
        Entrance.enter(phrase);
    }
}
