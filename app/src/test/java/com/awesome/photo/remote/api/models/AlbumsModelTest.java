package com.awesome.photo.remote.api.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumsModelTest {
    AlbumsModel classUnderTest;
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;


    @Before
    public void setUp() {
        initValidAlbumsModel();
    }

    private AlbumsModel createInitializedAlbumsModel(){
        albumId = 1;
        id = 1;
        title = "awesome";
        url = "http://somePhoto";
        thumbnailUrl = "http://someThumb";

        return new AlbumsModel(albumId, id, title, url, thumbnailUrl);
    }


    private void initValidAlbumsModel() {
        classUnderTest = createInitializedAlbumsModel();
    }

    @Test
    public void getAlbumId() {
        classUnderTest = createInitializedAlbumsModel();
        assertEquals(albumId, classUnderTest.getAlbumId());
    }

    @Test
    public void setAlbumId() {
        int expctedAlbumId = 5;
        classUnderTest.setAlbumId(expctedAlbumId);
        assertEquals(expctedAlbumId, classUnderTest.getAlbumId());
    }

    @Test
    public void getId() {
        assertEquals(id, classUnderTest.getId());
    }

    @Test
    public void setId() {
        int expectedId = 100;
        classUnderTest.setId(expectedId);
        assertEquals(expectedId, classUnderTest.getId());
    }

    @Test
    public void getTitle() {
        assertEquals(title, classUnderTest.getTitle());
    }

    @Test
    public void setTitle() {
        String expectedTitle = "junkTitle";
        classUnderTest.setTitle(expectedTitle);
        assertEquals(expectedTitle, classUnderTest.getTitle());
    }

    @Test
    public void getUrl() {
        assertEquals(url, classUnderTest.getUrl());
    }

    @Test
    public void setUrl() {
        String expectedUrl = "someURLOfGreatness";
        classUnderTest.setUrl(expectedUrl);
        assertEquals(expectedUrl, classUnderTest.getUrl());
    }

    @Test
    public void getThumbnailUrl() {
        assertEquals(thumbnailUrl, classUnderTest.getThumbnailUrl());
    }

    @Test
    public void setThumbnailUrl() {
        String expectedThumbnailUrl = "SuperSweetURL";
        classUnderTest.setThumbnailUrl(expectedThumbnailUrl);
        assertEquals(expectedThumbnailUrl, classUnderTest.getThumbnailUrl());
    }

    @Test
    public void toStringFormatTest(){
        String expectedToString = "albumId: 1 id: 1 title: awesome url: http://somePhoto thumbnailUrl: http://someThumb";
        assertTrue(expectedToString.equalsIgnoreCase(classUnderTest.toString()));
    }

}