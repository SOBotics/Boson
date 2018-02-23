package org.sobotics.boson.framework.services;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.PostSorting;

import java.io.IOException;
import java.time.Instant;

public class ApiCacheApiService extends ApiService {

    @Override
    public Answer[] getAnswers(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return new Answer[0];
    }

    @Override
    public Answer[] getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException {
        return new Answer[0];
    }
}
