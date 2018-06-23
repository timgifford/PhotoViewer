package com.awesome.photo.photoviewer.presenters.adapters;

import com.awesome.photo.photoviewer.presenters.Album;
import com.awesome.photo.remote.api.models.AlbumsModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collection;

import static org.junit.Assert.*;

public class AlbumModelToAlbumAdapterTest {

    AlbumModelToAlbumAdapter classUnderTest;
    AlbumsModel[] toAdapt;

    @Before
    public void setUp(){
        classUnderTest = new AlbumModelToAlbumAdapter();
        toAdapt = new AlbumsModel[3];
        toAdapt[0] = new AlbumsModel(1, 1, "", "", "");
        toAdapt[1] = new AlbumsModel(2, 1, "", "", "");
        toAdapt[2] = new AlbumsModel(2, 1, "", "", "");
    }

    @Test
    public void adaptReturnsTwoAlbumsWhenGivenThreeImagesFromTwoAlbums() {
        Collection<Album> result = classUnderTest.adapt(toAdapt);
        assertNotNull(result);
        assertEquals(2, result.size());

    }

    @Test
    public void adaptreturnsNullCollectionWhenProvidedNull() {
        Collection<Album> result = classUnderTest.adapt(null);
        assertNull(result);
    }
}