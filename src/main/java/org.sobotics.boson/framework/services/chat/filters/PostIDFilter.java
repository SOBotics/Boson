package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.stackexchange.Comment;

public class PostIDFilter implements Filter<Comment> {
    private Integer id;

    public PostIDFilter(Integer id){
        this.id = id;
    }

    @Override
    public boolean filter(Comment data) {
        return data.getPostId()==id;
    }
}
