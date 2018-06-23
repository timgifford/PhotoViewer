package com.awesome.photo.photoviewer.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

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


    public class Factory implements ViewModelProvider.Factory{
        JSONPlaceholderRepository albumsRepository;
        public Factory(JSONPlaceholderRepository albumsRepository){
            this.albumsRepository = albumsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new MainActivityViewModel(albumsRepository);
        }
    }

}
