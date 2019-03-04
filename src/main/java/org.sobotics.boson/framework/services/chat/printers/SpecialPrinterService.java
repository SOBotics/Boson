package org.sobotics.boson.framework.services.chat.printers;

public abstract class SpecialPrinterService <T> extends PrinterService<T>{
    abstract String print(T content, String dashboard, String intro, String message);
}
