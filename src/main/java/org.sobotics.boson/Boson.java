package org.sobotics.boson;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.StackExchangeClient;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.boson.sample.AnswerPrinterBot;

public class Boson{

    public static void main(String[] args) {
        PropertyService propertyService = new PropertyService();
        StackExchangeClient client = new StackExchangeClient(propertyService.getProperty("email"), propertyService.getProperty("password"));
        Room room = client.joinRoom(ChatHost.STACK_OVERFLOW, 165544);
        AnswerPrinterBot<Answer> answerPrinterBot = new AnswerPrinterBot<>();
        answerPrinterBot.start(room, "superuser");
    }
}