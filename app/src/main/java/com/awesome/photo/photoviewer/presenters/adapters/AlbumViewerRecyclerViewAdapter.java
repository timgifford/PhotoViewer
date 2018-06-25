package com.awesome.photo.photoviewer.presenters.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.awesome.photo.photoviewer.presenters.Album;

import java.util.List;

public class AlbumViewerRecyclerViewAdapter extends RecyclerView.Adapter {

    List<Album> albums;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {


        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
