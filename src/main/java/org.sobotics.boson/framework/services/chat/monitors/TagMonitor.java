package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Tag;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;
import org.sobotics.boson.framework.services.data.StackExchangeApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class TagMonitor extends Monitor<Tag>{

    private Instant previousTime;

    public TagMonitor(ChatRoom room, int frequency, String site, Filter<Tag>[] filters, PrinterService<Tag> printer) {
        super(room, frequency, site, filters, printer);
        previousTime = Instant.now().minusSeconds(60*60*24);
    }

    @Override
    protected void monitor(ChatRoom room, String site, Filter<Tag>[] filters, PrinterService<Tag> printer) throws IOException {
        ApiService apiService = new StackExchangeApiService("");
        List<Tag> tags = apiService.getTags(site, 1, 100, previousTime);
        for (Tag tag: tags){
            for (Filter<Tag> filter: filters){
                if(filter.filter(tag)){
                    room.getRoom().send(printer.print(tag));
                }
            }
        }
        previousTime = Instant.now();
    }
}
