package com.michaelhat.musicstructureplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.player_screen_song1)
    TextView playedSongName;
    @BindView(R.id.player_screen_album)
    TextView playedAlbumName;
    @BindView(R.id.player_screen_artist)
    TextView playedArtistName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent getIntent = getIntent();
        try {
            //Try setting the text. If intent in null, NullPointer will caught.
            playedSongName.setText(getIntent.getStringExtra("songName"));
            playedAlbumName.setText(getIntent.getStringExtra("albumName"));
            playedArtistName.setText(getIntent.getStringExtra("artistName"));
        } catch (NullPointerException e) {
            Log.e("Bundle is empty", e.toString());
        }

        //Open SongsListActivity
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
