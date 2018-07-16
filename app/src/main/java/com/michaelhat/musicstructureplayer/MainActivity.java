package com.michaelhat.musicstructureplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView playlistIcon = findViewById(R.id.playlist_icon);
        playlistIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSongsListActivity = new Intent(getApplicationContext(),
                        SongListActivity.class);
                startActivity(openSongsListActivity);
            }
        });
    }
}
