package com.awesome.photo.photoviewer;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.awesome.photo.photoviewer.databinding.ActivityAlbumViewerBinding;
import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumViewerRecyclerViewAdapter;
import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel;
import com.awesome.photo.remote.api.models.AlbumsModel;

import java.util.Collection;
import java.util.List;

public class AlbumViewerActivity extends AppCompatActivity {

    private AlbumsViewerViewModel albumsViewerViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityAlbumViewerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_album_viewer);
        albumsViewerViewModel = ViewModelProviders.of(this).get(AlbumsViewerViewModel.class);
        binding.albumViewerRv.setLayoutManager(new LinearLayoutManager(this));

        observeAlbumsEndpoint(binding);
        albumsViewerViewModel.getAlbums();
        super.onCreate(savedInstanceState);
    }

    private void observeAlbumsEndpoint(ActivityAlbumViewerBinding activityAlbumViewerBinding) {
        albumsViewerViewModel.albumsLiveData.observe(this, new Observer<AlbumsModel[]>() {
            @Override
            public void onChanged(@Nullable AlbumsModel[] albumsModels) {
                activityAlbumViewerBinding.albumViewerRv.setAdapter(new AlbumViewerRecyclerViewAdapter(new AlbumModelToAlbumAdapter().adapt(albumsModels)));
            }
        });
    }
}
