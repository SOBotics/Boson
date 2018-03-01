package org.sobotics.boson.framework.services;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.PostSorting;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class ApiCacheApiService extends ApiService {

    @Override
    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException {
        return null;
    }

    @Override
    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException {
        return null;
    }


}
