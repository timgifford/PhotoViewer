package com.awesome.photo.photoviewer.viewmodels.factories;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;


import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class AlbumsViewerViewModelFactory implements ViewModelProvider.Factory {

        JSONPlaceholderRepository albumsRepository;

        public AlbumsViewerViewModelFactory(JSONPlaceholderRepository albumsRepository){
            this.albumsRepository = albumsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new AlbumsViewerViewModel(albumsRepository);
        }
}
