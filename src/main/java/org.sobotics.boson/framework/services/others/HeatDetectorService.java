package org.sobotics.boson.framework.services.others;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.sobotics.boson.framework.model.heatdetector.request.Content;
import org.sobotics.boson.framework.model.heatdetector.request.HeatDetectorRequest;
import org.sobotics.boson.framework.model.heatdetector.response.HeatDetectorResponse;
import org.sobotics.boson.framework.model.heatdetector.response.Result;
import org.sobotics.boson.framework.utils.HttpRequestUtils;

import java.io.IOException;
import java.util.List;

public class HeatDetectorService {

    private final String URL = "https://jdd.cloud/heatdetector-api/api/classify/";

    private int limit;

    private String domain;


    public HeatDetectorService(int limit, String domain) {
        this.limit = limit;
        this.domain = domain;
    }

    public List<Result> getHeatDetectorData(List<Content> inputData){

        HeatDetectorRequest request = new HeatDetectorRequest();
        request.setContents(inputData);
        request.setDomain(domain);
        request.setMinScore(limit);
        JsonObject returnData;

        try {
            returnData = HttpRequestUtils.postJson(URL, new Gson().toJson(request));
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

        HeatDetectorResponse response = new Gson().fromJson(returnData, HeatDetectorResponse.class);

        // TODO: Add Back off logic here

        return response.getResult();

    }

}
