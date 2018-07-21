package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Tag;

public class NewTagPrinter implements PrinterService<Tag>{
    private String sitename;

    public NewTagPrinter(String sitename) {
        this.sitename = sitename;
    }

    public String print(Tag tag){
        String s = "[ [Boson](https://git.io/vA9TM) ] New tag " +
                "[tag:"+tag.getName()+"] ";

        s+="with "+tag.getCount()+" questions";

        return s;

    }
}
