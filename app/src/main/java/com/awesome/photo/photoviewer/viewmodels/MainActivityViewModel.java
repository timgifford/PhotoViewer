package com.awesome.photo.photoviewer.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.awesome.photo.photoviewer.AlbumViewerActivity;
import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter;
import com.awesome.photo.remote.api.models.AlbumsModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

import java.util.Collection;

public class MainActivityViewModel extends ViewModel {

    private JSONPlaceholderRepository albumsRepository;

    public MainActivityViewModel(JSONPlaceholderRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    //TODO Convert To Live Data
    public Collection<Album> retrieveAllAlbums(){
        AlbumsModel[] albumsModel = albumsRepository.retrieve();
        return new AlbumModelToAlbumAdapter().adapt(albumsModel);
    }

    //TODO Convert To Live Data
    public Collection<Album> retrieveAlbumFor(int id){
        AlbumsModel[] albumsModel = albumsRepository.retrieve(id);
        return new AlbumModelToAlbumAdapter().adapt(albumsModel);
    }

    public View.OnClickListener viewAlbumsClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), AlbumViewerActivity.class));
    }
    //TODO need to update destination to PhotosViewerActivity when created
    public View.OnClickListener viewPhotosClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), AlbumViewerActivity.class));
    }

}
