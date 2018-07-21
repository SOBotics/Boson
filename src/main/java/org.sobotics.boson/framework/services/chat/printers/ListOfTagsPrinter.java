package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Tag;

import java.util.List;

public class ListOfTagsPrinter implements PrinterService<List<Tag>>{
    private String sitename;

    public ListOfTagsPrinter(String sitename) {
        this.sitename = sitename;
    }

    public String print(List<Tag> tags){
        String s = "[ [Boson](https://git.io/vA9TM) ] New tags created: ";
        for (Tag tag: tags){
            s += "[tag:"+tag.getName()+"] ";
        }
        return s;

    }
}
