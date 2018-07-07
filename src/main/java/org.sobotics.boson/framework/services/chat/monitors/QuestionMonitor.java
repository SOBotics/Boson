package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;
import org.sobotics.boson.framework.services.data.StackExchangeApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionMonitor extends Monitor<Question>{

    private Instant previousLastActivityDate;

    public QuestionMonitor(ChatRoom room, int frequency, String site, Filter<Question>[] filters, PrinterService<Question> printer) {
        super(room, frequency, site, filters, printer);
        previousLastActivityDate = Instant.now().minusSeconds(60);
    }

    @Override
    protected void monitor(ChatRoom room, String site, Filter<Question>[] filters, PrinterService<Question> printer) throws IOException {
        System.out.println("Monitoring the questions on site "+site+" and reporting them in "+room.getRoomId());
        ApiService apiService = new StackExchangeApiService("kmtAuIIqwIrwkXm1*p3qqA((");
        List<Question> questions;
        try {
            questions = apiService.getQuestions(site, 1, 100, null);
            questions = questions.stream().filter(question -> question.getLastActivityDate().isAfter(previousLastActivityDate)).collect(Collectors.toList());
            if (questions.size()>0) {
                previousLastActivityDate = questions.get(0).getLastActivityDate();
            }

            for (Question q: questions){
                System.out.println("Title: "+q.getTitle() +
                        "Link: "+q.getLink());
            }

        } catch (StackExchangeApiException e) {
            room.getRoom().send("Bot not configured properly");
            e.printStackTrace();
            return;
        }
        for (Question question: questions){
            for (Filter<Question> filter: filters){
                if(filter.filter(question)){
                    room.getRoom().send(printer.print(question));
                }
            }
        }
    }
}
