package com.awesome.photo.photoviewer.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.awesome.photo.photoviewer.Constants;
import com.awesome.photo.photoviewer.R;
import com.awesome.photo.photoviewer.databinding.FragmentPhotoBinding;
import com.awesome.photo.remote.api.models.AlbumsModel;
import com.squareup.picasso.Picasso;

public class PhotoFragment extends Fragment {

    AlbumsModel photoModel;

    public static PhotoFragment getInstance(AlbumsModel photoModel){
        PhotoFragment newInstance = new PhotoFragment();
        newInstance.photoModel = photoModel;
        return  newInstance;
    }

    public PhotoFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPhotoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false);
        binding.photoHeader.setText(photoModel.getTitle());
        Picasso.get().load(photoModel.getUrl()).into(binding.photoImageView);
        return binding.getRoot();
    }

    protected void setPhotoModel(AlbumsModel albumsModel){
        this.photoModel = photoModel;
    }
}
