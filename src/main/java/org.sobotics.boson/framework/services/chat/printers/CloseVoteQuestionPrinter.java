package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Question;

public class CloseVoteQuestionPrinter implements PrinterService<Question>{
    private String sitename;

    public CloseVoteQuestionPrinter(String sitename) {
        this.sitename = sitename;
    }

    public String print(Question question){
        String s = "[ [RoundaBot](https://www.youtube.com/watch?v=-Tdu4uKSZ3M) ] [tag:"+question.getTags()[0]+"] ";

        if (question.getLastEditDate()!=null && question.getLastEditDate().equals(question.getLastActivityDate()))
            s+="Question with close votes edited ";
        else
            s+="Activity in answers on a question with closed votes ";

        s+="["+ question.getTitle()+ "]("+ question.getLink() +")";

        return s;

    }
}
