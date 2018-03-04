package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class GenericContentPrinterService<T extends Content> implements PrinterService<T>{
    private String sitename;

    public GenericContentPrinterService(String sitename) {
        this.sitename = sitename;
    }

    public String print(T content){
        return "[ [Boson](https://git.io/vA9TM) ] New "+ content.getType()+
                " posted on "+ sitename + " " + content.getLink();
    }
}
