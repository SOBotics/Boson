package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class ReputationFilter extends Filter<Content> {
    private int reputation;

    public ReputationFilter(int reputation){
        this.reputation = reputation;
    }

    @Override
    public boolean filter(Content data) {
        if(reputation<0)
            return data.getOwner().getReputation() < -reputation;
        else
            return data.getOwner().getReputation() > reputation;
    }
}
