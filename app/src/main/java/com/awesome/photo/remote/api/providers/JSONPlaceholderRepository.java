package com.awesome.photo.remote.api.providers;

import com.awesome.photo.remote.api.models.AlbumsModel;
import retrofit2.Response;

import java.io.IOException;

public class JSONPlaceholderRepository {

    JSONPlaceholderService service;


    public JSONPlaceholderRepository(JSONPlaceholderService service){
        this.service = service;
    }

    public AlbumsModel[] retrieve(){
        Response<AlbumsModel[]> response = null;
        try {
          response  = service.getAlbums().execute();
        } catch (IOException e) {
            //doNothingForNow
            //e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        else{
            return response.body();
        }
    }

    public AlbumsModel[] retrieve(int id){
        Response<AlbumsModel[]> response = null;
        try {
            response  = service.getAlbum(id).execute();
        } catch (IOException e) {
            //doNothingForNow
            //e.printStackTrace();
        }
        if(response == null){
            return null;
        }
        else{
            return response.body();
        }
    }
}
