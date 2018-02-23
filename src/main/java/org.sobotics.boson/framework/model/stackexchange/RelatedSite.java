package org.sobotics.boson.framework.model.stackexchange;

import com.google.gson.JsonObject;

public class RelatedSite {
    private String apiSiteParameter;
    private String name;
    private String relation;
    private String siteUrl;


    public RelatedSite(String apiSiteParameter, String name, String relation, String siteUrl) {
        this.apiSiteParameter = apiSiteParameter;
        this.name = name;
        this.relation = relation;
        this.siteUrl = siteUrl;
    }

    public RelatedSite() {
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    public String toString() {
        return "RelatedSite{" +
                "apiSiteParameter='" + apiSiteParameter + '\'' +
                ", name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                '}';
    }

    public RelatedSite getRelatedSiteFromJson(JsonObject relatedSite){
        RelatedSite site = new RelatedSite();
        site.setName(relatedSite.has("name")?relatedSite.get("name").getAsString():"");
        site.setRelation(relatedSite.has("relation")?relatedSite.get("relation").getAsString():"");
        site.setSiteUrl(relatedSite.has("site_url")?relatedSite.get("site_url").getAsString():"");
        site.setApiSiteParameter(relatedSite.has("api_site_parameter")?relatedSite.get("api_site_parameter").getAsString():"");
        return site;
    }
}
