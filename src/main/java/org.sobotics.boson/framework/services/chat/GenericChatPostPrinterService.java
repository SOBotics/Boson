package org.sobotics.boson.framework.services.chat;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.model.stackexchange.Question;

public class GenericChatPostPrinterService {
    private String sitename;

    public GenericChatPostPrinterService(String sitename) {
        this.sitename = sitename;
    }

    public String print(Comment comment){
        return "[ [Boson](https://git.io/vA9TM) ] New comment posted on "+ sitename+ " " + comment.getLink();
    }
    public String print(Answer answer){
        return "[ [Boson](https://git.io/vA9TM) ] New answer posted on "+ sitename+ " " + answer.getLink();
    }
    public String print(Question question){
        return "[ [Boson](https://git.io/vA9TM) ] New question posted on "+ sitename+ " " + question.getLink();
    }
}
