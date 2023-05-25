package com.example.itube2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import android.content.Intent;
import android.os.Bundle;

public class playpage extends AppCompatActivity {

    PlayerView playerView;

    String url;

    String url1 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    String url2 = "https://www.youtube.com/watch?v=LK0p8CLZnMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playpage);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");

        ExoPlayer player = new ExoPlayer.Builder(this).build();
        playerView = findViewById(R.id.playerview);

        playerView.setPlayer(player);

        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri(url);
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        // Prepare the player.
        player.prepare();
        // Start the playback.
        player.play();
    }
}