package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Post;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.dashboard.DashboardService;
import org.sobotics.boson.framework.services.data.ApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class PostMonitor extends Monitor<Post, Post>{

    private Instant previousTime;

    public PostMonitor(ChatRoom room, int frequency, String site, String apiKey, String apiToken,
                       Filter<Post>[] filters, PrinterService<Post> printer, DashboardService dashboardService) {
        super(room, frequency, site, apiKey, filters, printer, apiToken, dashboardService);
        previousTime = Instant.now().minusSeconds(60);
    }

    @Override
    protected void monitor(ChatRoom room, String site, Filter<Post>[] filters, PrinterService<Post> printer,
                           ApiService apiService, DashboardService dashboardService) throws IOException {
        List<Post> posts = apiService.getPostsByCreation(site, previousTime);
        for (Post post: posts){
            for (Filter<Post> filter: filters){
                if(filter.filter(post)){
                    room.getRoom().send(getFinalPrintString(printer, dashboardService, post));
                }
            }
        }
        previousTime = Instant.now();
    }
}
