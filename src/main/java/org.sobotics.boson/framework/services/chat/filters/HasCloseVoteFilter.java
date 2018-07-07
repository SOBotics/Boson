package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Question;


public class HasCloseVoteFilter implements Filter<Question> {

    private int voteCount;

    public HasCloseVoteFilter(int voteCount){
        this.voteCount = voteCount;
    }

    @Override
    public boolean filter(Question data) {

        if (data.getCloseVoteCount()>voteCount){
            return true;
        }
        return false;
    }
}
