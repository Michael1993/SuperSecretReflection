package com.javax1.secret.operation;

import com.javax1.secret.base.*;
import com.javax1.secret.base.UndergroundLab.Safe;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class Operation {
    private UndergroundLab lab = new UndergroundLab();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Operation operation = new Operation();
        /*operation.interceptedCommunications();
        operation.identifyObject();
        operation.describeObject();
        operation.interviewSuspects();*/
        operation.stealDocuments();
    }

    /**
     * We have intercepted several different communications. It's all a giant mess.
     * We don't want to work with e-mails or letters, only phone calls.
     * Can you help the agency find only the relevant communications?
     */
    public void interceptedCommunications() {
        /*
            Types of communications:
                - Communication.EMail
                - Communication.PhoneCall
                - Communication.MorseCode
                - etc.
         */
        List<Communication> communications = Communication.intercepted();
        List<Communication> calls;
        // CODE BEGIN
        calls = communications.stream()
                .filter(communication -> true) // We only want phone calls (and exactly phone calls)!
                .collect(Collectors.toList());
        // CODE END
        Communication.verify(calls);
    }

    /**
     * Before you can go back into the field you have to pass an evaluation.
     * The first task is identifying what kind of object is inside a briefcase.
     * What's the name of the content?
     */
    public void identifyObject() {
        Object content = Agent.getBriefcase().getContent();
        String contentName;
        // CODE BEGIN
        contentName = content.toString();
        // CODE END
        Agent.check(contentName); // We are looking for a simple solution here.
    }

    /**
     * The seconds task of the evaluation is properly describing an object.
     * Writing a proper field report is crucial in intelligence organizations.
     * What kind of {@code Modifier}s does this unidentified object have?
     */
    public void describeObject() {
        Object task = Unidentified.get();
        String mods;
        // CODE BEGIN
        mods = "public?"; // We need the modifiers in a string.
        // CODE END
        Agent.identify(mods);
    }

    /**
     * The third and final task is to interview a list of suspects.
     * Who has an alibi and who does not?
     * The alibi is not a secret (it's {@code public}).
     */
    public void interviewSuspects() {
        final String NAME_OF_FIELD = "ALIBI";
        List<Suspect> suspects = Suspect.list();
        Suspect criminal;
        // CODE BEGIN
        criminal = suspects.stream()
                .filter(suspect -> true) // Do all of them have alibis?
                .findAny().orElse(null);
        // CODE END
        Agent.accuse(criminal);
    }

    /**
     * We have to enter the base first. To do that, we need to know the {@code PASSWORD}.
     * The {@code PASSWORD} is a secret, of course (it's {@code private}).
     * We know that people entering the {@code Entrance} say this password, so
     * just listen in and maybe you can hear it?
     */
    public void enter() throws NoSuchFieldException, IllegalAccessException {
        final String NAME_OF_FIELD = "PASSWORD";
        Class<Entrance> entrance = Entrance.class;
        String phrase;
        // CODE BEGIN
        phrase = "Open, sesame!"; // We need to listen at the Entrance...
        // CODE END
        Entrance.enter(phrase);
    }

    /**
     * You have gained access to the Secret Underground Lab.
     * Now you need to steal the contents of a safe and replace the stolen documents with
     * fake ones.
     * <p>
     * But the safe is rigged!
     * You need to put exactly as much into it as you take out.
     * Or you could try disabling the alarm...
     */
    public void stealDocuments() throws NoSuchFieldException, IllegalAccessException {
        Safe safe = lab.new Safe();
        String NAME_OF_FIELD = "content";
        Class<Safe> safeClass = Safe.class;
        Object content;
        // CODE BEGIN
        Field contentField = safeClass.getDeclaredField(NAME_OF_FIELD);
        contentField.setAccessible(true);
        content = contentField.get(safe);
        contentField.set(safe, "Nothing");
        Field rigged = safeClass.getDeclaredField("rigged");
        rigged.setAccessible(true);
        rigged.set(safe, false);
        // CODE END
        safe.alarmCheck();
        Agent.checkDocuments(content.toString());
    }
}
