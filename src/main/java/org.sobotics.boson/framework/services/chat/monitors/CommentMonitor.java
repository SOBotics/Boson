package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;
import org.sobotics.boson.framework.services.data.StackExchangeApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class CommentMonitor extends Monitor<Comment, Comment>{

    private Instant previousTime;

    public CommentMonitor(ChatRoom room, int frequency, String site, String apiKey, Filter<Comment>[] filters, PrinterService<Comment> printer) {
        super(room, frequency, site, apiKey, filters, printer);
        previousTime = Instant.now().minusSeconds(60);
    }

    @Override
    protected void monitor(ChatRoom room, String site, String apiKey, Filter<Comment>[] filters, PrinterService<Comment> printer) throws IOException {
        ApiService apiService = new StackExchangeApiService(apiKey);
        List<Comment> comments = apiService.getComments(site, 1, 100, previousTime);
        for (Comment comment: comments){
            for (Filter<Comment> filter: filters){
                if(filter.filter(comment)){
                    room.getRoom().send(printer.print(comment));
                }
            }
        }
        previousTime = Instant.now();
    }
}
