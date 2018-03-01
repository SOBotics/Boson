package org.sobotics.boson;

import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.services.ApiService;
import org.sobotics.boson.framework.services.StackExchangeApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class Boson{

    public static void main(String[] args) {

        ApiService apiService = new StackExchangeApiService("HYWHTHpYImfSRnhkArqu8Q((",
                "Cm3XpScEriqPKpawx4Dc6A))");
        try {
            List<Answer> answers = apiService.getAnswers("stackoverflow", 1, 1, Instant.now().minusSeconds(100));
            for(Answer answer: answers)
                System.out.println(answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}