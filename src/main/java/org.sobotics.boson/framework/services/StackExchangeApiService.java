package org.sobotics.boson.framework.services;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.api.PostOrdering;
import org.sobotics.boson.framework.model.stackexchange.api.PostSorting;
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
    public List<Answer> getAnswers(String site, int page, int pageSize, Instant fromDate, Instant toDate, PostOrdering order, PostSorting sort) throws IOException {
        String filter = "!LVBj2-meNpvsiW3UvI3lD(";
        String answersUrl = API_URL + "/answers";
        JsonObject json =  HttpRequestUtils.get(answersUrl,
                "order",order.name(),
                "sort",sort.name(),
                "filter",filter,
                "page",Integer.toString(page),
                "pagesize",Integer.toString(pageSize),
                "fromdate",String.valueOf(fromDate.getEpochSecond()),
                "todate",String.valueOf(toDate.getEpochSecond()),
                "site",site,
                "key",apiKey,
                "access_token",apiToken);
        handleBackoff(json);
        JsonArray array = json.get("items").getAsJsonArray();
        System.out.println(json);
        System.out.println(array.get(0).getAsJsonObject());
        return  getObjectFromJson(array, Answer.class);
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
