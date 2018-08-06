package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class UserIdFilter extends Filter<Content> {
    private int userId;

    // TODO: REMOVE THIS IN PRODUCTION!!!!!!!!!!!!!

    public UserIdFilter(int userId){
        this.userId = userId;
    }

    @Override
    public boolean filter(Content data) {
        return data.getOwner().getUserId() == userId;

    }
}
