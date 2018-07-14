package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Monitor <T,U>{

    private ChatRoom room;
    private int frequency;
    private String site;
    private String apiKey;
    private Filter<T> filters[];
    private PrinterService<U> printer;
    private ScheduledExecutorService service;

    public Monitor(ChatRoom room, int frequency, String site, String apiKey, Filter<T>[] filters, PrinterService<U> printer) {
        this.room = room;
        this.frequency = frequency;
        this.site = site;
        this.filters = filters;
        this.apiKey = apiKey;
        this.printer = printer;
        this.service = Executors.newSingleThreadScheduledExecutor();
    }

    public ScheduledExecutorService startMonitor(){
        Runnable runnable = () -> {
            try {
                monitor(room, site, apiKey, filters, printer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        service.scheduleAtFixedRate(runnable, 0, frequency, TimeUnit.SECONDS);
        return service;
    }

    public void stopMonitor(){
        service.shutdown();
    }

    protected abstract void monitor(ChatRoom room, String site, String apiKey, Filter<T> filters[], PrinterService<U> printer) throws IOException;
}
