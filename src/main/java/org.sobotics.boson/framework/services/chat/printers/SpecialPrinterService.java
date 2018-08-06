package org.sobotics.boson.framework.services.chat.printers;

public interface SpecialPrinterService <T> extends PrinterService<T>{
    String print(T content, String message);
}
