package com.awesome.photo.photoviewer.viewmodels.factories;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class MainActivityViewModelFactory implements ViewModelProvider.Factory {
        JSONPlaceholderRepository albumsRepository;
        public MainActivityViewModelFactory(JSONPlaceholderRepository albumsRepository){
            this.albumsRepository = albumsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new MainActivityViewModel(albumsRepository);
        }
}
