package org.sobotics.boson.framework.services.chat.printers;

public interface PrinterService <T>{
    String print(T object);
    String print(T object, String dashboard);
    String print(T object, String dashboard, String intro);
}
