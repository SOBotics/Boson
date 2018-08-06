package org.sobotics.boson.framework.model.heatdetector.request;

public class Content {

    private long id;
    private String text;

    public Content(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Content() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
