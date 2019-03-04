package org.sobotics.boson.framework.services.dashboard;


import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.BotApi;
import io.swagger.client.model.AquireTokenRequest;
import io.swagger.client.model.AquireTokenResponse;
import io.swagger.client.model.RegisterPostReason;
import io.swagger.client.model.RegisterPostRequest;
import org.jsoup.Jsoup;
import org.sobotics.boson.framework.model.stackexchange.*;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

import java.util.ArrayList;
import java.util.List;

public class HiggsService implements DashboardService<Content> {

    private String url;
    private String api_url;
    private String key;
    private String botName;
    private BotApi botApi;



    public HiggsService(String url, String api_url, String key, String botName) throws ApiException {
        this.url = url;
        this.api_url = api_url;
        this.key = key;
        this.botName = botName;
        initialize();
    }

    private void initialize() throws ApiException {
        botApi = new BotApi(Configuration.getDefaultApiClient().setBasePath(this.api_url));
        AquireTokenRequest atr = new AquireTokenRequest();
        atr.dashboardId(8);
        atr.setSecret(key);
        AquireTokenResponse token = botApi.botAquireTokenPost(atr);
        Configuration.getDefaultApiClient().setAccessToken(token.getToken());
    }

    @Override
    public String createReport(Content content) throws ApiException {

        if (content instanceof Question)
            return  addNewQuestion((Question) content);
        if (content instanceof Answer)
            return  addNewAnswer((Answer) content);
        if (content instanceof Comment)
            return  addNewComment((Comment) content);
        if (content instanceof Post)
            return  addNewPost((Post) content);

        return null;
    }

    private String addNewPost(Post post) throws ApiException {
        RegisterPostRequest rpr = new RegisterPostRequest();
        rpr.authorName(post.getOwner().getDisplayName());
        rpr.authorReputation(post.getOwner().getReputation());
        rpr.setTitle(post.getTitle());
        rpr.setContentId((long)post.getPostId());
        rpr.setContent(Jsoup.parse(post.getBody()).text());
        rpr.setContentSite(post.getLink().split("/")[2]);
        rpr.setContentType("answer");
        rpr.setContentUrl(post.getLink());
        rpr.setDetectionScore(1.0);
        Instant cDate = Instant.ofEpochSecond(post.getCreationDate().getEpochSecond());
        rpr.setContentCreationDate(org.threeten.bp.OffsetDateTime.ofInstant(cDate, ZoneOffset.UTC));
        return addHiggs(rpr);
    }

    private String addNewComment(Comment comment) throws ApiException {
        RegisterPostRequest rpr = new RegisterPostRequest();
        rpr.authorName(comment.getOwner().getDisplayName());
        rpr.authorReputation(comment.getOwner().getReputation());
        String title = Jsoup.parse(comment.getBody()).text();
        if (title.length()>80){
            int index = title.indexOf(' ',60);
            if (index>0 && index<80){
                title = title.substring(0,index);
            }else{
                title = title.substring(0,80);
            }
        }
        if (title.length()<=1){
            title = "Empty";
        }
        rpr.setTitle(title);
        rpr.setContentId(comment.getCommentId());
        rpr.setContent(Jsoup.parse(comment.getBody()).text());
        rpr.setContentSite(comment.getLink().split("/")[2]);
        rpr.setContentType("comment");
        rpr.setContentUrl(comment.getLink());
        rpr.setDetectionScore(1.0);
        Instant cDate = Instant.ofEpochSecond(comment.getCreationDate().getEpochSecond());
        rpr.setContentCreationDate(org.threeten.bp.OffsetDateTime.ofInstant(cDate, ZoneOffset.UTC));
        return addHiggs(rpr);
    }

    private String addNewAnswer(Answer answer) throws ApiException {
        RegisterPostRequest rpr = new RegisterPostRequest();
        rpr.authorName(answer.getOwner().getDisplayName());
        rpr.authorReputation(answer.getOwner().getReputation());
        rpr.setTitle(answer.getTitle());
        rpr.setContentId((long)answer.getAnswerId());
        rpr.setContent(Jsoup.parse(answer.getBody()).text());
        rpr.setContentSite(answer.getLink().split("/")[2]);
        rpr.setContentType("answer");
        rpr.setContentUrl(answer.getLink());
        rpr.setDetectionScore(1.0);
        Instant cDate = Instant.ofEpochSecond(answer.getCreationDate().getEpochSecond());
        rpr.setContentCreationDate(org.threeten.bp.OffsetDateTime.ofInstant(cDate, ZoneOffset.UTC));
        return addHiggs(rpr);
    }

    private String addNewQuestion(Question question) throws ApiException {
        RegisterPostRequest rpr = new RegisterPostRequest();
        rpr.authorName(question.getOwner().getDisplayName());
        rpr.authorReputation(question.getOwner().getReputation());
        rpr.setTitle(question.getTitle());
        rpr.setContentId((long)question.getQuestionId());
        rpr.setContent(Jsoup.parse(question.getBody()).text());
        rpr.setContentSite(question.getLink().split("/")[2]);
        rpr.setContentType("answer");
        rpr.setContentUrl(question.getLink());
        rpr.setDetectionScore(1.0);
        Instant cDate = Instant.ofEpochSecond(question.getCreationDate().getEpochSecond());
        rpr.setContentCreationDate(org.threeten.bp.OffsetDateTime.ofInstant(cDate, ZoneOffset.UTC));
        return addHiggs(rpr);
    }

    private String addHiggs(RegisterPostRequest rpr) throws ApiException {
        Instant detected = Instant.ofEpochSecond(System.currentTimeMillis() / 1000);
        rpr.setDetectedDate(OffsetDateTime.ofInstant(detected, ZoneId.systemDefault()));

        List<RegisterPostReason> reasons = new ArrayList<>();
        RegisterPostReason reason = new RegisterPostReason();
        reason.setReasonName(botName);
        reason.setConfidence(1.0);
        reason.setTripped(true);
        reasons.add(reason);

        rpr.setReasons(reasons);

        Integer higgsId = botApi.botRegisterPostPost(rpr);

        return "[Higgs](" + url + "/" + higgsId + ")";
    }

}


