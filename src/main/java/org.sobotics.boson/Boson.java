package org.sobotics.boson;

import org.sobotics.boson.bot.BosonBot;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.chatexchange.chat.ChatHost;
import org.sobotics.chatexchange.chat.Room;
import org.sobotics.chatexchange.chat.StackExchangeClient;

public class Boson{

    public static void main(String[] args) {
        PropertyService  propertyService = new PropertyService();
        String email = propertyService.getProperty("email");
        String password = propertyService.getProperty("password");
        String apiKey = propertyService.getProperty("apikey");
        String apiToken = propertyService.getProperty("apitoken");
        String dashUrl = propertyService.getProperty("higgsurl");
        String dashApi = propertyService.getProperty("higgsapi");
        String dashKey = propertyService.getProperty("higgskey");
        StackExchangeClient client = new StackExchangeClient(email, password);
        Room room = client.joinRoom(ChatHost.STACK_OVERFLOW, 167908);

        new BosonBot(room, client, apiKey, apiToken, dashUrl, dashApi, dashKey).start();

        //new PostPrinterBot(room, "stackoverflow", 10000000).start();

    }
}