package org.sobotics.boson;

import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.services.data.ApiService;
import org.sobotics.boson.framework.services.data.StackExchangeApiService;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class Boson{

    public static void main(String[] args) {

        ApiService apiService = new StackExchangeApiService("HYWHTHpYImfSRnhkArqu8Q((",
                "Cm3XpScEriqPKpawx4Dc6A))");
        try {
            List<Comment> questions = apiService.getComments("stackoverflow", 1, 1, Instant.now().minusSeconds(100));
            for(Comment question: questions)
                System.out.println(question);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}