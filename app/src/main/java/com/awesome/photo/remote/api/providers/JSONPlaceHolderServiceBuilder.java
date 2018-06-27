package com.awesome.photo.remote.api.providers;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JSONPlaceHolderServiceBuilder {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final Converter.Factory CONVERTER_FACTORY = GsonConverterFactory.create();

    public JSONPlaceholderService build(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(CONVERTER_FACTORY)
                .build();
//        TG: Why not chain create(..) after build() and return it?
//        return new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(CONVERTER_FACTORY)
//                .build()
//                .crete(JSONPlaceholderService.class);
        return retrofit.create(JSONPlaceholderService.class);
    }
}
