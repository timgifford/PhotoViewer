package com.awesome.photo.photoviewer.presenters.adapters;

import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.remote.api.models.AlbumsModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AlbumModelToAlbumAdapter {
    public Collection<Album> adapt(AlbumsModel[] albumsModels){
        final Map<Integer, Album> albumMap = new HashMap<>();
        if(albumsModels != null){
            Arrays.asList(albumsModels).stream().forEach(x -> {
                if(albumMap.get(x.getAlbumId())==null){
                    List<AlbumsModel> albumsModelList = new ArrayList<AlbumsModel>();
                    albumMap.put(x.getAlbumId(), new Album(x.getId(), albumsModelList));
                }
                albumMap.get(x.getAlbumId()).getPhotos().add(x);
            });
        }
    return albumMap.values().size() == 0 ? null : albumMap.values();
    }
}
