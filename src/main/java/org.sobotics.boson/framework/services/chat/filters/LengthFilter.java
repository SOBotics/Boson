package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class LengthFilter implements Filter<Content> {
    private int length;

    public LengthFilter(int length){
        this.length = length;
    }

    @Override
    public boolean filter(Content data) {
        if(length <0)
            return data.getBody().length() < -length;
        else
            return data.getBody().length() > length;
    }
}
