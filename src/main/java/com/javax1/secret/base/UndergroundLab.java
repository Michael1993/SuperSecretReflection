package com.javax1.secret.base;

public class UndergroundLab {

    public class Safe {
        private String content = "Very Secret Documents";
        private boolean rigged = true;

        public boolean isRigged() {
            return rigged;
        }

        public void alarmCheck() {
            if (content.equals("Very Secret Documents")) {
                throw new EndOfMissionException("You failed to replace the documents with the fakes.");
            }

            if (isRigged() && content.length() != "Very Secret Documents".length()) {
                throw new EndOfMissionException("Oh no, the safe alarm was triggered!");
            }
        }
    }
}
