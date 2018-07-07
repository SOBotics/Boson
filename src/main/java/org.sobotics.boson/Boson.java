package org.sobotics.boson;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.StackExchangeClient;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.boson.sample.QuestionPrinterBot;

public class Boson{

    public static void main(String[] args) {
        PropertyService  propertyService = new PropertyService();
        StackExchangeClient client = new StackExchangeClient(propertyService.getProperty("email"), propertyService.getProperty("password"));
        Room room = client.joinRoom(ChatHost.STACK_OVERFLOW, 167826);

//        AnswerPrinterBot interpersonalAnswerBot = new AnswerPrinterBot(room, "interpersonal", 660);
//        interpersonalAnswerBot.start();

        room.send("[RoundaBot](https://www.youtube.com/watch?v=-Tdu4uKSZ3M) started");

        QuestionPrinterBot gamedev = new QuestionPrinterBot(room, "area51.meta.stackexchange.com", 59);
        gamedev.start();

    }
}