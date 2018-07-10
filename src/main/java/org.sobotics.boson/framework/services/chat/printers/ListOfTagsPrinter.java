package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.stackexchange.Tag;

import java.util.List;

public class ListOfTagsPrinter implements PrinterService<List<Tag>>{
    private String sitename;

    public ListOfTagsPrinter(String sitename) {
        this.sitename = sitename;
    }

    public String print(List<Tag> tags){
        String s = "[ [Tagdor](https://chat.stackoverflow.com/transcript/message/43142452#43142452) ] New tags created in the past 6 hrs: ";
        for (Tag tag: tags){
            s += "[tag:"+tag.getName()+"] ";
        }
        return s;

    }
}
