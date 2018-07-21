package org.sobotics.boson.framework.services.chat.filters;

import com.google.gson.JsonObject;
import org.sobotics.boson.framework.model.stackexchange.Tag;
import org.sobotics.boson.framework.utils.HttpRequestUtils;

import java.io.IOException;

public class BurnedTagFilter implements Filter<Tag> {
    private String name;

    public BurnedTagFilter(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Tag data) {


        String tagdorApi = "http://tagdor-tagdor.193b.starter-ca-central-1.openshiftapps.com/tags/";

        try {
            JsonObject json = HttpRequestUtils.get(tagdorApi+data.getName());
            return json.get("burninated").getAsBoolean();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


    }
}
