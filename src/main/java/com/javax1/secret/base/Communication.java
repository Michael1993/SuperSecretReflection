package com.javax1.secret.base;

import java.util.List;

public class Communication {
    public static List<Communication> intercepted() {
        return List.of(
                new PhoneCall(),
                new EMail(),
                new PigeonMessage(),
                new Letter(),
                new MorseCode(),
                new EncodedSpyMessage()
        );
    }

    public static void verify(List<Communication> calls) {
        if (calls.stream().anyMatch(call -> !(call instanceof PhoneCall))) {
            throw new EndOfMissionException("The agency could not handle the vast amount of collected data... " +
                    "Well, not before 5 PM, anyways. After that, everyone went home.");
        }

        if (calls.stream().anyMatch(call -> !call.getClass().equals(PhoneCall.class))) {
            throw new EndOfMissionException(
                    "Unfortunately, the agency was overwhelmed with the things that also used the phone cables " +
                            "but were not actually phone calls."
            );
        }
    }

    public static class PhoneCall extends Communication {
    }

    public static class EMail extends Communication {
    }

    public static class PigeonMessage extends Communication {
    }

    public static class Letter extends Communication {
    }

    public static class MorseCode extends PhoneCall {
    }

    public static class EncodedSpyMessage extends PhoneCall {
    }
}
