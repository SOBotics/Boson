package org.sobotics.boson.framework.model.stackexchange;

public class OriginalQuestion {
    private int acceptedAnswerId;
    private int answerCount;
    private int questionId;
    private String title;

    public OriginalQuestion(int acceptedAnswerId, int answerCount, int questionId, String title) {
        this.acceptedAnswerId = acceptedAnswerId;
        this.answerCount = answerCount;
        this.questionId = questionId;
        this.title = title;
    }

    public OriginalQuestion() {
    }

    public int getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(int acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "OriginalQuestion{" +
                "acceptedAnswerId=" + acceptedAnswerId +
                ", answerCount=" + answerCount +
                ", questionId=" + questionId +
                ", title='" + title + '\'' +
                '}';
    }
}
