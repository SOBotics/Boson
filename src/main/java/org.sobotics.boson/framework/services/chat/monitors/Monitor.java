package org.sobotics.boson.framework.services.chat.monitors;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.printers.PrinterService;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Monitor <T>{

    private ChatRoom room;
    private int frequency;
    private String site;
    private Filter<T> filters[];
    private PrinterService<T> printer;
    private ScheduledExecutorService service;

    public Monitor(ChatRoom room, int frequency, String site, Filter<T>[] filters, PrinterService<T> printer) {
        this.room = room;
        this.frequency = frequency;
        this.site = site;
        this.filters = filters;
        this.printer = printer;
        this.service = Executors.newSingleThreadScheduledExecutor();
    }

    public ScheduledExecutorService startMonitor(){
        Runnable runnable = () -> {
            try {
                monitor(room, site, filters, printer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        System.out.println(runnable);
        service.scheduleAtFixedRate(runnable, 0, frequency, TimeUnit.SECONDS);
        return service;
    }

    protected abstract void monitor(ChatRoom room, String site, Filter<T> filters[], PrinterService<T> printer) throws IOException;
}
