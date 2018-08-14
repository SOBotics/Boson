package org.sobotics.boson.framework.services.chat.filters;

import org.sobotics.boson.framework.model.heatdetector.request.Content;
import org.sobotics.boson.framework.model.heatdetector.response.Result;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.services.others.HeatDetectorService;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeatDetectorFilter extends SpecialFilter<Comment> {

    private Map<Long, String> messages;
    private int value;
    private List<Result> results;
    private HeatDetectorService service;

    public HeatDetectorFilter(int value, HeatDetectorService service) {
        this.value = value;
        this.service = service;
        this.results = new ArrayList<>();
        this.messages = new HashMap<>();
    }
    public HeatDetectorFilter(HeatDetectorService service) {
        this.value = service.getLimit();
        this.service = service;
        this.results = new ArrayList<>();
        this.messages = new HashMap<>();
    }

    @Override
    public Map<Long, String> getMessages() {
        return messages;
    }

    @Override
    public boolean filter(Comment data) {

        List<Content> contentList = new ArrayList<>();
        contentList.add(new Content(data.getCommentId(), data.getBodyMarkdown()));

        results = service.getHeatDetectorData(contentList);
        if (results.size()>0){
            messages.put(results.get(0).getId(), prettyPrintResult(results.get(0)));
        }

        return results.size() > 0 && results.get(0).getId() == contentList.get(0).getId();

    }

    @Override
    public List<Boolean> filterAll(List<Comment> dataList) {
        List<Boolean> returnData = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        List<Content> contentList = new ArrayList<>();

        for (Comment data: dataList){
            ids.add(data.getCommentId());
            contentList.add(new Content(data.getCommentId(), data.getBodyMarkdown()));
        }

        results = service.getHeatDetectorData(contentList);
        List<Long> resultIds = new ArrayList<>();


        for (Result result: results){
            resultIds.add(result.getId());
            messages.put(result.getId(), prettyPrintResult(result));
        }

        for(long id: ids){
            returnData.add(resultIds.contains(id));
        }

        return  returnData;
    }

    private String prettyPrintResult(Result result){

        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        return "Naïve Bayes "+ decimalFormat.format(result.getNb()) +"; " +
                "OpenNLP "+ decimalFormat.format(result.getOp()) +"; ";


    }
}
