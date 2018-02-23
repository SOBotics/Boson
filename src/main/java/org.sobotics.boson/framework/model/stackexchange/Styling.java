package org.sobotics.boson.framework.model.stackexchange;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Styling {
    private String linkColor;
    private String tagBackgroundColor;
    private String tagForegroundColor;

    public Styling(String linkColor, String tagBackgroundColor, String tagForegroundColor) {
        this.linkColor = linkColor;
        this.tagBackgroundColor = tagBackgroundColor;
        this.tagForegroundColor = tagForegroundColor;
    }

    public Styling() {
    }

    public String getLinkColor() {
        return linkColor;
    }

    public void setLinkColor(String linkColor) {
        this.linkColor = linkColor;
    }

    public String getTagBackgroundColor() {
        return tagBackgroundColor;
    }

    public void setTagBackgroundColor(String tagBackgroundColor) {
        this.tagBackgroundColor = tagBackgroundColor;
    }

    public String getTagForegroundColor() {
        return tagForegroundColor;
    }

    public void setTagForegroundColor(String tagForegroundColor) {
        this.tagForegroundColor = tagForegroundColor;
    }

    @Override
    public String toString() {
        return "Styling{" +
                "linkColor='" + linkColor + '\'' +
                ", tagBackgroundColor='" + tagBackgroundColor + '\'' +
                ", tagForegroundColor='" + tagForegroundColor + '\'' +
                '}';
    }
}
