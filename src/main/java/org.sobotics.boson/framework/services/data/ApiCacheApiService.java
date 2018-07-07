package org.sobotics.boson.framework.services.data;

import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.api.AnswerSorting;
import org.sobotics.boson.framework.model.stackexchange.api.CommentSorting;
import org.sobotics.boson.framework.model.stackexchange.api.Ordering;
import org.sobotics.boson.framework.model.stackexchange.api.QuestionSorting;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class ApiCacheApiService extends ApiService {

    @Override
    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, AnswerSorting sort) throws IOException {
        return null;
    }

    @Override
    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, QuestionSorting sort, String[] tags) throws IOException, StackExchangeApiException {
        return null;
    }

    @Override
    public List<Comment> getComments(String site, int page, int pageSize, Instant fromDate, Instant toDate, Ordering order, CommentSorting sort) throws IOException {
        return null;
    }


}
