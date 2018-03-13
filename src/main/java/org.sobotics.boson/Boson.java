package org.sobotics.boson;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.StackExchangeClient;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.boson.sample.QuestionPrinterBot;

public class Boson{

    public static void main(String[] args) {
        PropertyService propertyService = new PropertyService();
        StackExchangeClient client = new StackExchangeClient(propertyService.getProperty("email"), propertyService.getProperty("password"));
        Room room = client.joinRoom(ChatHost.STACK_EXCHANGE, 59667);

//        AnswerPrinterBot interpersonalAnswerBot = new AnswerPrinterBot(room, "interpersonal", 660);
//        interpersonalAnswerBot.start();

        QuestionPrinterBot gamedev = new QuestionPrinterBot(room, "gamedev", 100);
        gamedev.start();

    }
}