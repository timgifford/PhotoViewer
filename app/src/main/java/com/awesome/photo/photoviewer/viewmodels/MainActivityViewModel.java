package com.awesome.photo.photoviewer.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.awesome.photo.photoviewer.AlbumViewerActivity;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;


public class MainActivityViewModel extends ViewModel {

    private JSONPlaceholderRepository albumsRepository;

    public MainActivityViewModel(JSONPlaceholderRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    public View.OnClickListener viewAlbumsClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), AlbumViewerActivity.class));
    }
    //TODO need to update destination to PhotosViewerActivity when created
    public View.OnClickListener viewPhotosClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), AlbumViewerActivity.class));
    }

}
