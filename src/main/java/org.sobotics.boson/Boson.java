package org.sobotics.boson;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.StackExchangeClient;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.boson.sample.TagMonitorBot;

public class Boson{

    public static void main(String[] args) {
        PropertyService  propertyService = new PropertyService();
        StackExchangeClient client = new StackExchangeClient(propertyService.getProperty("email"), propertyService.getProperty("password"));
        Room room = client.joinRoom(ChatHost.STACK_OVERFLOW, 167908);

        room.send("[ [Tagdor](https://chat.stackoverflow.com/transcript/message/43142452#43142452) ] started");

        TagMonitorBot taggy = new TagMonitorBot(room, "stackoverflow", 120);
        taggy.start();

    }
}