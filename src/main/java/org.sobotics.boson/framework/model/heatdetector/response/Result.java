package org.sobotics.boson.framework.model.heatdetector.response;

public class Result {

    private long id;
    private double nb;
    private double op;
    private BadRegex bad;
    private int score;

    public Result(long id, double nb, double op, BadRegex bad, int score) {
        this.id = id;
        this.nb = nb;
        this.op = op;
        this.bad = bad;
        this.score = score;
    }

    public Result() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNb() {
        return nb;
    }

    public void setNb(double nb) {
        this.nb = nb;
    }

    public double getOp() {
        return op;
    }

    public void setOp(double op) {
        this.op = op;
    }

    public BadRegex getBad() {
        return bad;
    }

    public void setBad(BadRegex bad) {
        this.bad = bad;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", nb=" + nb +
                ", op=" + op +
                ", bad=" + bad +
                ", score=" + score +
                '}';
    }
}
