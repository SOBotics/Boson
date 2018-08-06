package org.sobotics.boson.framework.model.heatdetector.request;

import java.util.List;

public class HeatDetectorRequest {

    private String domain;
    private int minScore;
    private List<Content> contents;

    public HeatDetectorRequest(String domain, int minScore, List<Content> contents) {
        this.domain = domain;
        this.minScore = minScore;
        this.contents = contents;
    }

    public HeatDetectorRequest() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "HeatDetectorRequest{" +
                "domain='" + domain + '\'' +
                ", minScore=" + minScore +
                ", contents=" + contents +
                '}';
    }
}
