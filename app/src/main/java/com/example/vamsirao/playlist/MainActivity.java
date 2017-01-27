package com.example.vamsirao.playlist;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends Activity {

    VideoView videoView;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      final ArrayList<String> videoList= new ArrayList<String>();
        videoList.add("android.resource://"+getPackageName()+"/"+R.raw.video_one);
        videoList.add("android.resource://"+getPackageName()+"/"+R.raw.video_two);
        videoList.add("android.resource://"+getPackageName()+"/"+R.raw.video_three);

        videoView= (VideoView)findViewById(R.id.video_view);

        videoView.setMediaController(null);
        //when you set a video path, media player is automatically set to the view
        videoView.setVideoPath(videoList.get(0));
        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
              i++;
               // mp.start();
                if (i > videoList.size() - 1) {
                    i = 0;
                }

                videoView.setVideoPath(videoList.get(i));
              videoView.start();

            }
        });

    }

}
