package org.sobotics.boson.framework.model.heatdetector.response;

import java.util.List;

public class HeatDetectorResponse {

    private String domain;
    private List<Result> result;
    private int backoff;

    public HeatDetectorResponse(String domain, List<Result> result, int backoff) {
        this.domain = domain;
        this.result = result;
        this.backoff = backoff;
    }

    public HeatDetectorResponse() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public int getBackoff() {
        return backoff;
    }

    public void setBackoff(int backoff) {
        this.backoff = backoff;
    }

    @Override
    public String toString() {
        return "HeatDetectorResponse{" +
                "domain='" + domain + '\'' +
                ", result=" + result +
                ", backoff=" + backoff +
                '}';
    }
}
