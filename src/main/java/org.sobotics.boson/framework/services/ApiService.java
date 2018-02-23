package org.sobotics.boson.framework.services;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.PostSorting;

import java.io.IOException;
import java.time.Instant;

public abstract class ApiService {

    public Answer[] getAnswers(String site, int page, int pageSize, Instant fromDate) throws IOException {
        return getAnswers(site, page, pageSize, fromDate, Instant.now(), PostOrdering.DESC, PostSorting.ACTIVITY);
    }

    public abstract Answer[] getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException;

}
