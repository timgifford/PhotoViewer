package com.awesome.photo.photoviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
