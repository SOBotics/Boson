package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Question;

public class CloseVoteQuestionPrinter extends PrinterService<Question>{
    private String sitename;

    public CloseVoteQuestionPrinter(String sitename) {
        this.sitename = sitename;
    }

    public String print(Question question, String dashboard, String intro){
        String message = "[tag:"+question.getTags()[0]+"] ";

        if (question.getLastEditDate()!=null && question.getLastEditDate().equals(question.getLastActivityDate()))
            message+="Question with close votes edited ";
        else
            message+="Activity in answers on a question with closed votes ";

        message+="["+ question.getTitle()+ "]("+ question.getLink() +")";

        return getFinalPrintString(dashboard, intro, message);

    }
}
