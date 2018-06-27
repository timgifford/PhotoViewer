package com.awesome.photo.remote.api.providers;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.awesome.photo.remote.api.models.AlbumsModel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

import static org.junit.Assert.*;

public class JSONPlaceholderRepositoryTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    JSONPlaceholderRepository classUnderTest;

    @Mock
    private JSONPlaceholderService serviceMock;
    @Mock
    private Call<AlbumsModel[]> callMock;
    @Mock
    MutableLiveData<AlbumsModel[]> albumsLiveData;
    @Mock
    Callback<AlbumsModel[]> callbackMock;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(serviceMock.getAlbums()).thenReturn(callMock);
        Mockito.when(serviceMock.getAlbum(1)).thenReturn(callMock);
        classUnderTest = new JSONPlaceholderRepository(serviceMock, callbackMock);
    }

    @Test
    public void retrieveCreatesGetAlbumsNoParamCallAndEnqueuesIt() throws IOException {


        classUnderTest.retrieve();
        // TG: I only see this used in @Mock declaration. Does this
        // test anything other than the Mockito.initMocks call? If so, we don't
        // need to test that since it's not our code.
        assertNotNull(albumsLiveData);
        Mockito.verify(serviceMock).getAlbums();
        Mockito.verify(callMock).enqueue(callbackMock);
    }

    @Test
    public void getAlbumCallsGetAlbumByIdAndEnqueuesTheCall() throws IOException {
        int id = 1;


        classUnderTest.retrieve(id);
        // TG: needed?
        assertNotNull(albumsLiveData);
        Mockito.verify(serviceMock).getAlbum(id);
        Mockito.verify(callMock).enqueue(callbackMock);
    }

    private AlbumsModel[] getValidModelArray() {
        AlbumsModel[] models = new AlbumsModel[1];
        models[0] = new AlbumsModel(1, 1, "slsls", "ddddddd", "jjjj");
        return models;
    }
}