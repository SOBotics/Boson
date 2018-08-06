package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommentMonitor extends Monitor<Comment, Comment>{

    private Instant previousTime;

    public CommentMonitor(ChatRoom room, int frequency, String site, String apiKey, Filter<Comment>[] filters, PrinterService<Comment> printer) {
        super(room, frequency, site, apiKey, filters, printer);
        previousTime = Instant.now().minusSeconds(frequency);
    }

    @Override
    protected void monitor(ChatRoom room, String site, String apiKey, Filter<Comment>[] filters, PrinterService<Comment> printer, ApiService apiService) throws IOException {

        List<Comment> display = apiService.getComments(site, 1, 100, previousTime);

        for (Filter<Comment> filter: filters){

            List<Boolean> filterResult = filter.filterAll(display);
            List<Comment> tempDisplay = new ArrayList<>();

            for(int i = 0; i< filterResult.size(); i++){
                boolean result = filterResult.get(i);
                Comment comment = display.get(i);
                if(result){
                    tempDisplay.add(comment);
                }
            }

            display = tempDisplay;
        }

        for(Comment comment: display){
            room.getRoom().send(printer.print(comment));
        }

        previousTime = Instant.now();
    }
}
