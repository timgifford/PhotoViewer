package com.awesome.photo.remote.api.providers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

public class JSONPlaceHolderServiceBuilderTest {

    JSONPlaceHolderServiceBuilder classUnderTest;

    @Before
    public void setUp(){
        classUnderTest = new JSONPlaceHolderServiceBuilder();
    }

    @Test
    public void builderHasJSONPlaceHolderServiceBaseURL() {
        String expctedURL = "https://jsonplaceholder.typicode.com";
        assertTrue(expctedURL.equalsIgnoreCase(classUnderTest.BASE_URL));
    }

    @Test
    public void builderHasGsonConverterFactoryToAddToService(){
        assertNotNull(classUnderTest.CONVERTER_FACTORY);
        assertTrue(classUnderTest.CONVERTER_FACTORY instanceof GsonConverterFactory);
    }
}