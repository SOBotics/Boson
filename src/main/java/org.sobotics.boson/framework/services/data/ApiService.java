package org.sobotics.boson.framework.services.data;

import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.model.stackexchange.*;
import org.sobotics.boson.framework.model.stackexchange.api.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public abstract class ApiService {

    public List<Answer> getAnswers(String site) throws IOException {
        return getAnswers(site, 1, 30, null, null, Ordering.DESC, AnswerSorting.ACTIVITY);
    }

    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getAnswers(site, page, pageSize, fromDate, Instant.now(), Ordering.DESC, AnswerSorting.ACTIVITY);
    }

    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate) throws IOException, StackExchangeApiException {
        return getQuestions(site, page, pageSize, fromDate, null, Ordering.DESC, QuestionSorting.ACTIVITY, new String[0]);
    }

    public List<Question> getQuestionsByCreation(String site, int page, int pageSize, Instant fromDate) throws IOException, StackExchangeApiException {
        return getQuestions(site, page, pageSize, fromDate, null, Ordering.ASC, QuestionSorting.CREATION, new String[0]);
    }

    public List<Comment> getComments(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getComments(site, page, pageSize, fromDate, Instant.now(), Ordering.DESC, CommentSorting.CREATION);
    }

    public abstract List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, AnswerSorting sort) throws IOException;

    public abstract List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, QuestionSorting sort, String[] tags) throws IOException, StackExchangeApiException;

    public abstract List<Comment> getComments(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, CommentSorting sort) throws IOException;

    public abstract List<Tag> getTags(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, TagSorting sort, String inName) throws IOException;

    public abstract List<Post> getPosts(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, PostSorting sort, String inName) throws IOException;

    public abstract List<Post> getAllPosts(String site, Instant fromDate, Instant toDate, Ordering order, PostSorting sort, String inName) throws IOException;


    public List<Tag> getTags(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getTags(site, page, pageSize, fromDate, Instant.now(), Ordering.DESC, TagSorting.POPULAR, "");
    }


}
