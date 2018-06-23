package com.awesome.photo.photoviewer.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.awesome.photo.remote.api.models.AlbumsModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class MainActivityViewModel extends ViewModel {

    private JSONPlaceholderRepository albumsRepository;


    public MainActivityViewModel(JSONPlaceholderRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    //TODO mapAlbumsModel[] to Album
    public void retrieveAllAlbums(){
        AlbumsModel[] albumsModel = albumsRepository.retrieve();
    }

    //TODO map AlbumsModel[] to Album
    public void retrieveAlbumFor(int id){
        AlbumsModel[] albumsModel = albumsRepository.retrieve(id);
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
