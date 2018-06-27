package com.awesome.photo.photoviewer.presenters;

import com.awesome.photo.remote.api.models.AlbumsModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class AlbumTest {
    Album classUnderTest;
    // TG: I wouldn't mock albumsList. Just make it an empty list.
    @Mock
    List<AlbumsModel> albumsList;
    int baseId = 1;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new Album(baseId, albumsList);
    }

    @Test
    public void getPhotos() {
        assertEquals(albumsList, classUnderTest.getPhotos());
    }

    @Test
    public void setPhotos() {
        // TG: pass in a realy list, because mocks don't need to be used
        // to test 'state' based methods.
        List<AlbumsModel> expected = Mockito.mock(List.class);
        classUnderTest.setPhotos(expected);
        assertEquals(expected, classUnderTest.getPhotos());
    }

    // TG: Not much value in testing get/sets unless they have logic

    @Test
    public void getId() {
        assertEquals(baseId, classUnderTest.getId());
    }

    @Test
    public void setId() {
        int expected = 2;
        classUnderTest.setId(2);

        assertEquals(expected, classUnderTest.getId());
    }
}