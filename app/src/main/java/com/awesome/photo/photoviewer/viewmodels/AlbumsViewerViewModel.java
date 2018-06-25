package com.awesome.photo.photoviewer.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter;
import com.awesome.photo.remote.api.models.AlbumsModel;
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

import java.util.Collection;

public class AlbumsViewerViewModel extends ViewModel{

    public MutableLiveData<AlbumsModel[]> albumsLiveData = new MutableLiveData<>();

    public void getAlbums() {
        new JSONPlaceholderRepository(new JSONPlaceHolderServiceBuilder().build()).retrieve(albumsLiveData);

    }
}
