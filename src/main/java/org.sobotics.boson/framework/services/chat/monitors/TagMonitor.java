package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Tag;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.dashboard.DashboardService;
import org.sobotics.boson.framework.services.data.ApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TagMonitor extends Monitor<Tag, List<Tag>>{

    private Instant previousTime;

    public TagMonitor(ChatRoom room, int frequency, String site, String apiKey, String apiToken, Filter<Tag>[] filters,
                      PrinterService<List<Tag>> printer, DashboardService dashboardService) {
        super(room, frequency, site, apiKey, filters, printer, apiToken, dashboardService);
        previousTime = Instant.now().minusSeconds(frequency);
    }

    @Override
    protected void monitor(ChatRoom room, String site, Filter<Tag>[] filters, PrinterService<List<Tag>> printer,
                           ApiService apiService, DashboardService dashboardService) throws IOException {
        List<Tag> tags = apiService.getTags(site,  previousTime);
        List<Tag> filteredTags = new ArrayList<>();
        for (Tag tag: tags){
            for (Filter<Tag> filter: filters){
                if(filter.filter(tag)){
                    filteredTags.add(tag);
                }
            }
        }
        room.getRoom().send(printer.print(filteredTags));
        // TODO: Figure out how to add tags on Higgs
        previousTime = Instant.now();
    }
}
