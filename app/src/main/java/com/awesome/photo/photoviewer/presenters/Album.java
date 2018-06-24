package com.awesome.photo.photoviewer.presenters;

import com.awesome.photo.remote.api.models.AlbumsModel;

import java.util.List;

public class       Album {
    private int id;
    //This is lazy I should have a Photo Object
    private List<AlbumsModel> photos;

    public Album(int baseId, List<AlbumsModel> albumsList) {
        this.id = baseId;
        this.photos = albumsList;
    }

    public List<AlbumsModel> getPhotos() {
        return photos;
    }

    public void setPhotos(List<AlbumsModel> photos) {
        this.photos = photos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
