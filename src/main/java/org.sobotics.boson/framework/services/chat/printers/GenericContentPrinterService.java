package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class GenericContentPrinterService<T extends Content> extends PrinterService<T>{
    private String sitename;

    public GenericContentPrinterService(String sitename) {
        this.sitename = sitename;
    }

    public String print(T content, String dashboard, String intro){
        String message = "New [" + content.getType() +
                "](" + content.getLink() + ") posted on " + sitename + "  by [" +
                content.getOwner().getDisplayName() + "](" + content.getOwner().getLink() + ")";
        return getFinalPrintString(dashboard, intro, message);
    }
}
