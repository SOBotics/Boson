package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;
import org.sobotics.boson.framework.services.data.ApiService;
import org.sobotics.boson.framework.services.data.StackExchangeApiService;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Monitor <T,U>{

    private ChatRoom room;
    private int frequency;
    private String site;
    private String apiKey;
    private String apiToken;
    private Filter<T> filters[];
    private PrinterService<U> printer;
    private ScheduledExecutorService service;
    private ApiService apiService;

    public Monitor(ChatRoom room, int frequency, String site, String apiKey, Filter<T>[] filters, PrinterService<U> printer, String apiToken) {
        this.room = room;
        this.frequency = frequency;
        this.site = site;
        this.filters = filters;
        this.apiKey = apiKey;
        this.apiToken = apiToken;
        this.printer = printer;
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.apiService = new StackExchangeApiService(apiKey);
    }
    public Monitor(ChatRoom room, int frequency, String site, String apiKey, Filter<T>[] filters, PrinterService<U> printer, ApiService apiService) {
        this.room = room;
        this.frequency = frequency;
        this.site = site;
        this.filters = filters;
        this.apiKey = apiKey;
        this.printer = printer;
        this.service = Executors.newSingleThreadScheduledExecutor();
        this.apiService = apiService;
    }

    public ScheduledExecutorService startMonitor(){
        Runnable runnable = () -> {
            try {
                monitor(room, site, filters, printer, apiService);
            } catch (IOException e) {
                e.printStackTrace();
                room.getRoom().send("Error while calling API: `"+ e.getMessage()+"`");
            }
        };
        service.scheduleAtFixedRate(runnable, 0, frequency, TimeUnit.SECONDS);
        return service;
    }

    public void stopMonitor(){
        service.shutdown();
    }

    protected abstract void monitor(ChatRoom room, String site, Filter<T>[] filters, PrinterService<U> printer, ApiService apiService) throws IOException;
}
