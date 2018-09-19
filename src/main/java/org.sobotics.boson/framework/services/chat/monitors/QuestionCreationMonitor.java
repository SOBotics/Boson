package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class QuestionCreationMonitor extends Monitor<Question, Question>{

    private Instant previousTime;

    public QuestionCreationMonitor(ChatRoom room, int frequency, String site, String apiKey, String apiToken,
                                   Filter<Question>[] filters, PrinterService<Question> printer) {
        super(room, frequency, site, apiKey, filters, printer, apiToken);
        previousTime = Instant.now().minusSeconds(60);
    }

    @Override
    protected void monitor(ChatRoom room, String site, Filter<Question>[] filters, PrinterService<Question> printer, ApiService apiService) throws IOException {
        List<Question> questions = null;
        try {
            questions = apiService.getQuestionsByCreation(site, 1, 100, previousTime);
        } catch (StackExchangeApiException e) {
            e.printStackTrace();
        }
        for (Question question: questions){
            for (Filter<Question> filter: filters){
                if(filter.filter(question)){
                    room.getRoom().send(printer.print(question));
                }
            }
        }
        previousTime = Instant.now();
    }
}
