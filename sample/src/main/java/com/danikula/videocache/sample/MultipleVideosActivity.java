package com.danikula.videocache.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_multiple_videos)
public class MultipleVideosActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        if (state == null) {
            // Preload some videos before showing them
            preloadVideos();
            
            addVideoFragment(Video.ORANGE_1, R.id.videoContainer0);
            addVideoFragment(Video.ORANGE_2, R.id.videoContainer1);
            addVideoFragment(Video.ORANGE_3, R.id.videoContainer2);
            addVideoFragment(Video.ORANGE_4, R.id.videoContainer3);
        }
    }

    private void preloadVideos() {
        // Preload videos that will be shown later
        // This starts caching in background before user actually plays them
        App.getProxy(this).preload(Video.ORANGE_2.url);
        App.getProxy(this).preload(Video.ORANGE_3.url);
        App.getProxy(this).preload(Video.ORANGE_4.url);
    }

    private void addVideoFragment(Video video, int containerViewId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, VideoFragment.build(video.url))
                .commit();
    }
}
