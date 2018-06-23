package com.awesome.photo.photoviewer;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.awesome.photo.photoviewer.databinding.ActivityMainBinding;
import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }
}
