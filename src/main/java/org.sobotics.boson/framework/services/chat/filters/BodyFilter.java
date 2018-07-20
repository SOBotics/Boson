package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class BodyFilter implements Filter<Content> {
    private String keyword;

    public BodyFilter(String keyword){
        this.keyword = keyword;
    }

    @Override
    public boolean filter(Content data) {
        return data.getBody().toLowerCase().contains(keyword.toLowerCase());

    }
}
