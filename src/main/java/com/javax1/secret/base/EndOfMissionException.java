package com.javax1.secret.base;

/**
 * Thrown when the agent is captured, killed or has to abandon the mission.
 */
public class EndOfMissionException extends RuntimeException {
    public EndOfMissionException(String s) {
        super(s);
    }
}
