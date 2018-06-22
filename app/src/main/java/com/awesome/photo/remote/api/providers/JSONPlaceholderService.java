package com.awesome.photo.remote.api.providers;

import com.awesome.photo.remote.api.models.AlbumsModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholderService {
    @GET("/photos")
    Call<AlbumsModel[]> getAlbums();
}
