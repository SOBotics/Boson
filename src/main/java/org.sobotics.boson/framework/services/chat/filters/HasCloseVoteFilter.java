package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Question;


public class HasCloseVoteFilter implements Filter<Question> {
    @Override
    public boolean filter(Question data) {

        if (data.getCloseVoteCount()>0){
            return true;
        }
        return false;
    }
}
