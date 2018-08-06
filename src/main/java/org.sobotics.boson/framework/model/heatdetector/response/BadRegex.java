package org.sobotics.boson.framework.model.heatdetector.response;

public class BadRegex {

    private String regex;
    private int type;

    public BadRegex(String regex, int type) {
        this.regex = regex;
        this.type = type;
    }

    public BadRegex() {
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BadRegex{" +
                "regex='" + regex + '\'' +
                ", type=" + type +
                '}';
    }
}
