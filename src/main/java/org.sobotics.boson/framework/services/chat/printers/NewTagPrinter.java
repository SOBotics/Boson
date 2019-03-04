package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Tag;

public class NewTagPrinter extends PrinterService<Tag>{
    private String sitename;

    public NewTagPrinter(String sitename) {
        this.sitename = sitename;
    }


    @Override
    public String print(Tag tag, String dashboard, String intro) {

        String message = "New tag " +
                "[tag:"+tag.getName()+"] " +
                "with "+tag.getCount()+" questions";

        return getFinalPrintString(dashboard, intro, message);
    }

}
