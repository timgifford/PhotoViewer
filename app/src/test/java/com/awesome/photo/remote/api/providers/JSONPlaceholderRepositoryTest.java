package com.awesome.photo.remote.api.providers;

import com.awesome.photo.remote.api.models.AlbumsModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class JSONPlaceholderRepositoryTest {

    JSONPlaceholderRepository classUnderTest;

    @Mock
    private JSONPlaceholderService serviceMock;
    @Mock
    private Call<AlbumsModel[]> callMock;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(serviceMock.getAlbums()).thenReturn(callMock);
        Mockito.when(serviceMock.getAlbum(1)).thenReturn(callMock);
        classUnderTest = new JSONPlaceholderRepository(serviceMock);
    }

    @Test
    public void retrieveDoesNothingWhenExceptionThrownByService() throws IOException {
        Mockito.when(callMock.execute()).thenThrow(new IOException("Oh No, bad IO"));
        classUnderTest.retrieve(albumsLiveData);
    }

    @Test
    public void retrieveReturnsNullWhenFailToParseResponse() throws IOException {
        Mockito.when(callMock.execute()).thenReturn(null);

        AlbumsModel[] albumsModels = classUnderTest.retrieve(albumsLiveData);
        assertNull(albumsModels);
    }

    @Test
    public void retrieveReturnsAPIResponseBodyWhenCallSuccessful() throws IOException {
        AlbumsModel[] expectedModel = getValidModelArray();
        Response<AlbumsModel[]> expected = Mockito.mock(Response.class);
        Mockito.when(expected.body()).thenReturn(expectedModel);
        Mockito.when(callMock.execute()).thenReturn(expected);

        AlbumsModel[] albumsModels = classUnderTest.retrieve(albumsLiveData);
        assertNotNull(albumsModels);
        assertEquals(expectedModel, albumsModels);
    }

    @Test
    public void getAlbumDoesNothingWhenExceptionThrownByService() throws IOException {
        Mockito.when(callMock.execute()).thenThrow(new IOException("Oh No, bad IO"));
        classUnderTest.retrieve(1);
    }

    @Test
    public void getAlbumReturnsNullWhenFailToParseResponse() throws IOException {
        Mockito.when(callMock.execute()).thenReturn(null);

        AlbumsModel[] albumsModels = classUnderTest.retrieve(1);
        assertNull(albumsModels);
    }

    @Test
    public void getAlbumReturnsAPIResponseBodyWhenCallSuccessful() throws IOException {
        AlbumsModel[] expectedModel = getValidModelArray();
        Response<AlbumsModel[]> expected = Mockito.mock(Response.class);
        Mockito.when(expected.body()).thenReturn(expectedModel);
        Mockito.when(callMock.execute()).thenReturn(expected);

        AlbumsModel[] albumsModels = classUnderTest.retrieve(1);
        assertNotNull(albumsModels);
        assertEquals(expectedModel, albumsModels);
    }

    private AlbumsModel[] getValidModelArray() {
        AlbumsModel[] models = new AlbumsModel[1];
        models[0] = new AlbumsModel(1, 1, "slsls", "ddddddd", "jjjj");
        return models;
    }
}