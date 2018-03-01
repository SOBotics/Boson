package org.sobotics.boson.framework.services;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.PostSorting;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public abstract class ApiService {

    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getAnswers(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, PostSorting.ACTIVITY);
    }

    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getQuestions(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, PostSorting.ACTIVITY);
    }

    public abstract List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException;

    public abstract List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException;
}
