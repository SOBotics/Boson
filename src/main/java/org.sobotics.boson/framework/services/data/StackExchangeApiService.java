package org.sobotics.boson.framework.services.data;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobotics.boson.framework.exceptions.StackExchangeApiException;
import org.sobotics.boson.framework.exceptions.TypeSizeExceededException;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.api.AnswerSorting;
import org.sobotics.boson.framework.model.stackexchange.api.CommentSorting;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.QuestionSorting;
import org.sobotics.boson.framework.services.PropertyService;
import org.sobotics.boson.framework.utils.HttpRequestUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StackExchangeApiService extends ApiService{

    private static final Logger LOGGER = LoggerFactory.getLogger(StackExchangeApiService.class);

    private String apiKey;
    private String apiToken;
    private final String API_URL = "https://api.stackexchange.com/2.2";

    public StackExchangeApiService() {
        PropertyService service = new PropertyService();
        apiKey = service.getProperty("apiKey");
        apiToken = service.getProperty("apiToken");
    }

    public StackExchangeApiService(String apiKey) {
        this.apiKey = apiKey;
        this.apiToken = "";
    }

    public StackExchangeApiService(String apiKey, String apiToken) {
        this.apiKey = apiKey;
        this.apiToken = apiToken;
    }


    @Override
    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, AnswerSorting sort) throws IOException {
        String filter = "!LVBj2-meNpvsiW3UvI3lD(";
        String answersUrl = API_URL + "/answers";
        final String fromDateString = fromDate!=null?String.valueOf(fromDate.getEpochSecond()):"";
        final String toDateString = toDate!=null?String.valueOf(toDate.getEpochSecond()):"";
        JsonObject json =  HttpRequestUtils.get(answersUrl,
                "order",order.name(),
                "sort",sort.name(),
                "filter",filter,
                "page",Integer.toString(page),
                "pagesize",Integer.toString(pageSize),
                "fromdate", fromDateString,
                "todate", toDateString,
                "site",site,
                "key",apiKey,
                "access_token",apiToken);
        handleBackoff(json);
        JsonArray array = json.get("items").getAsJsonArray();
        System.out.println(json);
        return  getObjectFromJson(array, Answer.class);
    }

    @Override
    public List<Question> getQuestions(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, QuestionSorting sort, String[] tags) throws IOException, StackExchangeApiException {


        if (tags.length>5){
            throw new TypeSizeExceededException("Only 5 tags are allowed");
        }

        String tagString = String.join(";", tags);
        String filter = "!)5KmYd6AIAe7rRRfKQY65WhiSpIV";
        String questionsUrl = API_URL + "/questions";
        final String fromDateString = fromDate!=null?String.valueOf(fromDate.getEpochSecond()):"";
        final String toDateString = toDate!=null?String.valueOf(toDate.getEpochSecond()):"";
        JsonObject json =  HttpRequestUtils.get(questionsUrl,
                "order",order.name(),
                "sort",sort.name(),
                "filter",filter,
                "page",Integer.toString(page),
                "pagesize",Integer.toString(pageSize),
                "fromdate",fromDateString,
                "todate",toDateString,
                "site",site,
                "tags",tagString,
                "key",apiKey,
                "access_token",apiToken);
        handleBackoff(json);
        JsonArray array = json.get("items").getAsJsonArray();
        System.out.println(json);
        System.out.println(array.get(0).getAsJsonObject());
        return  getObjectFromJson(array, Question.class);
    }

    @Override
    public List<Comment> getComments(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, CommentSorting sort) throws IOException {
        String filter = "!-*jbN*LhFh6F";
        String commentsUrl = API_URL + "/comments";
        final String fromDateString = fromDate!=null?String.valueOf(fromDate.getEpochSecond()):"";
        final String toDateString = toDate!=null?String.valueOf(toDate.getEpochSecond()):"";
        JsonObject json =  HttpRequestUtils.get(commentsUrl,
                "order",order.name(),
                "sort",sort.name(),
                "filter",filter,
                "page",Integer.toString(page),
                "pagesize",Integer.toString(pageSize),
                "fromdate",fromDateString,
                "todate",toDateString,
                "site",site,
                "key",apiKey,
                "access_token",apiToken);
        handleBackoff(json);
        JsonArray array = json.get("items").getAsJsonArray();
        System.out.println(json);
        System.out.println(array.get(0).getAsJsonObject());
        return  getObjectFromJson(array, Comment.class);
    }

    private <T> List<T> getObjectFromJson(JsonArray array, Class<T> classOfT) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                registerTypeAdapter(Instant.class, new JsonDeserializer<Instant>() {
                    @Override
                    public Instant deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return Instant.ofEpochSecond(json.getAsJsonPrimitive().getAsLong());
                    }
                }).create();
        return StreamSupport.stream(array.spliterator(), false).map(j -> gson.fromJson(j.getAsJsonObject(), classOfT)).collect(Collectors.toList());
    }

    private void handleBackoff(JsonObject root) {
        if (root.has("backoff")) {
            int backoff = root.get("backoff").getAsInt();
            //System.out.println("Backing off for " + backoff+ " seconds. Quota left "+root.get("quota_remaining").getAsString());
            try {
                Thread.sleep(1000 * backoff);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
