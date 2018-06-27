package com.awesome.photo.photoviewer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.awesome.photo.photoviewer.databinding.ActivityPhotoListViewerBinding;
import com.awesome.photo.photoviewer.fragments.PhotoFragment;
import com.awesome.photo.photoviewer.presenters.Album;

public class PhotoListViewerActivity extends AppCompatActivity {
    private Album album;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        album = (Album)getIntent().getSerializableExtra(Constants.ALBUM);
        ActivityPhotoListViewerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_list_viewer);
        mPager = binding.viewPager;
        mPagerAdapter = new PhotoAlbumPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        super.onCreate(savedInstanceState);
    }

    private class PhotoAlbumPagerAdapter extends FragmentStatePagerAdapter {

        public PhotoAlbumPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return  PhotoFragment.getInstance(album.getPhotos().get(i));
        }

        @Override
        public int getCount() {
            return album.getPhotos().size();
        }
    }
}
