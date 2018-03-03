package org.sobotics.boson.framework.services.chat.samples;

import org.sobotics.boson.framework.model.stackexchange.Content;

public class GenericChatPostPrinterService<T extends Content> {
    private String sitename;

    public GenericChatPostPrinterService(String sitename) {
        this.sitename = sitename;
    }

    public String print(T content){
        return "[ [Boson](https://git.io/vA9TM) ] New "+ content.getType()+
                " posted on "+ sitename + " " + content.getLink();
    }
}
