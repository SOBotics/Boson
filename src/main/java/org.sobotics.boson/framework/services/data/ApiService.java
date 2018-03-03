package org.sobotics.boson.framework.services.data;

import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.api.AnswerSorting;
import org.sobotics.boson.framework.model.stackexchange.api.CommentSorting;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.QuestionSorting;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public abstract class ApiService {

    public List<Answer> getAnswers(String site) throws IOException {
        return getAnswers(site, 1, 30, null, null, PostOrdering.DESC, AnswerSorting.ACTIVITY);
    }

    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getAnswers(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, AnswerSorting.ACTIVITY);
    }

    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate) throws IOException, StackExchangeApiException {
        return getQuestions(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, QuestionSorting.ACTIVITY, new String[0]);
    }

    public List<Comment> getComments(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getComments(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, CommentSorting.CREATION);
    }

    public abstract List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, AnswerSorting sort) throws IOException;

    public abstract List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, QuestionSorting sort, String[] tags) throws IOException, StackExchangeApiException;

    public abstract List<Comment> getComments(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, CommentSorting sort) throws IOException;
}
