package com.awesome.photo.remote.api.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlbumsModel implements Serializable
{

    @SerializedName("albumId")
    @Expose
    private int albumId;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    private final static long serialVersionUID = 725345473200455115L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AlbumsModel() {
    }

    /**
     *
     * @param id
     * @param title
     * @param albumId
     * @param thumbnailUrl
     * @param url
     */
    public AlbumsModel(int albumId, int id, String title, String url, String thumbnailUrl) {
        super();
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        // TG: I'd prefer String.format("albumId: %s id: %s", albumId, id);
        // Neither one is really easier to read...Both are equally bad.
        return new StringBuilder().append("albumId: "+ albumId).append(" id: "+ id).append(" title: "+ title).append(" url: "+ url).append(" thumbnailUrl: "+ thumbnailUrl).toString();
    }
}