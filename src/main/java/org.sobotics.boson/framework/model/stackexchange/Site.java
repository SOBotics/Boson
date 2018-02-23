package org.sobotics.boson.framework.model.stackexchange;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.Instant;
import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Site {

    private String[] aliases;
    private String apiSiteParameter;
    private String audience;
    private Instant closedBetaDate;
    private String faviconUrl;
    private String highResolutionIconUrl;
    private String iconUrl;
    private Instant launchDate;
    private String logoUrl;
    private String[] markdownExtensions;
    private String name;
    private Instant openBetaDate;
    private RelatedSite[] relatedSites;
    private String siteState;
    private String siteType;
    private String siteUrl;
    private Styling styling;
    private String twitterAccount;

    public Site(String[] aliases, String apiSiteParameter, String audience, Instant closedBetaDate, String faviconUrl, String highResolutionIconUrl, String iconUrl, Instant launchDate, String logoUrl, String[] markdownExtensions, String name, Instant openBetaDate, RelatedSite[] relatedSites, String siteState, String siteType, String siteUrl, Styling styling, String twitterAccount) {
        this.aliases = aliases;
        this.apiSiteParameter = apiSiteParameter;
        this.audience = audience;
        this.closedBetaDate = closedBetaDate;
        this.faviconUrl = faviconUrl;
        this.highResolutionIconUrl = highResolutionIconUrl;
        this.iconUrl = iconUrl;
        this.launchDate = launchDate;
        this.logoUrl = logoUrl;
        this.markdownExtensions = markdownExtensions;
        this.name = name;
        this.openBetaDate = openBetaDate;
        this.relatedSites = relatedSites;
        this.siteState = siteState;
        this.siteType = siteType;
        this.siteUrl = siteUrl;
        this.styling = styling;
        this.twitterAccount = twitterAccount;
    }

    public Site() {
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public String getApiSiteParameter() {
        return apiSiteParameter;
    }

    public void setApiSiteParameter(String apiSiteParameter) {
        this.apiSiteParameter = apiSiteParameter;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Instant getClosedBetaDate() {
        return closedBetaDate;
    }

    public void setClosedBetaDate(Instant closedBetaDate) {
        this.closedBetaDate = closedBetaDate;
    }

    public String getFaviconUrl() {
        return faviconUrl;
    }

    public void setFaviconUrl(String faviconUrl) {
        this.faviconUrl = faviconUrl;
    }

    public String getHighResolutionIconUrl() {
        return highResolutionIconUrl;
    }

    public void setHighResolutionIconUrl(String highResolutionIconUrl) {
        this.highResolutionIconUrl = highResolutionIconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Instant getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Instant launchDate) {
        this.launchDate = launchDate;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String[] getMarkdownExtensions() {
        return markdownExtensions;
    }

    public void setMarkdownExtensions(String[] markdownExtensions) {
        this.markdownExtensions = markdownExtensions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getOpenBetaDate() {
        return openBetaDate;
    }

    public void setOpenBetaDate(Instant openBetaDate) {
        this.openBetaDate = openBetaDate;
    }

    public RelatedSite[] getRelatedSites() {
        return relatedSites;
    }

    public void setRelatedSites(RelatedSite[] relatedSites) {
        this.relatedSites = relatedSites;
    }

    public String getSiteState() {
        return siteState;
    }

    public void setSiteState(String siteState) {
        this.siteState = siteState;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public Styling getStyling() {
        return styling;
    }

    public void setStyling(Styling styling) {
        this.styling = styling;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    @Override
    public String toString() {
        return "Site{" +
                "aliases=" + Arrays.toString(aliases) +
                ", apiSiteParameter='" + apiSiteParameter + '\'' +
                ", audience='" + audience + '\'' +
                ", closedBetaDate=" + closedBetaDate +
                ", faviconUrl='" + faviconUrl + '\'' +
                ", highResolutionIconUrl='" + highResolutionIconUrl + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", launchDate=" + launchDate +
                ", logoUrl='" + logoUrl + '\'' +
                ", markdownExtensions=" + Arrays.toString(markdownExtensions) +
                ", name='" + name + '\'' +
                ", openBetaDate=" + openBetaDate +
                ", relatedSites=" + Arrays.toString(relatedSites) +
                ", siteState='" + siteState + '\'' +
                ", siteType='" + siteType + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", styling=" + styling +
                ", twitterAccount='" + twitterAccount + '\'' +
                '}';
    }


}
