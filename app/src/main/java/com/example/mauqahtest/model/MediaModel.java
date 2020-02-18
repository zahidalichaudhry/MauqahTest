package com.example.mauqahtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MediaModel {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private Double approvedForSyndication;

    @SerializedName("media-metadata")
    @Expose
    private List<MediaMetaDataModel> mediametadata;

    public List<MediaMetaDataModel> getMediametadata() {
        return mediametadata;
    }

    public void setMediametadata(List<MediaMetaDataModel> mediametadata) {
        this.mediametadata = mediametadata;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Double getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Double approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

}
