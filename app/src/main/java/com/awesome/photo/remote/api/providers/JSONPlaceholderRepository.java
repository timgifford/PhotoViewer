package com.awesome.photo.remote.api.providers;

import android.arch.lifecycle.MutableLiveData;

import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.remote.api.models.AlbumsModel;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collection;

public class JSONPlaceholderRepository {

    JSONPlaceholderService service;


    public JSONPlaceholderRepository(JSONPlaceholderService service){
        this.service = service;
    }

    public void retrieve(MutableLiveData<AlbumsModel[]> albumsLiveData){
        service.getAlbums().enqueue(new JSONPlaceholderServiceCallback(albumsLiveData));
    }

    public void retrieve(int id, MutableLiveData<AlbumsModel[]> albumsLiveData){
        service.getAlbum(id).enqueue(new JSONPlaceholderServiceCallback(albumsLiveData));
    }
}
