package com.michaelhat.musicstructureplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SongListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        //Create an instance of SongListAdapter
        SongListAdapter songListAdapter = new SongListAdapter(this, MainActivity.songsList);
        ListView songListView = findViewById(R.id.song_list_view);

        songListView.setAdapter(songListAdapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song song = MainActivity.songsList.get(position);

                Intent playAudio = new Intent(getApplicationContext(), MainActivity.class);
                playAudio.putExtra("songName", song.getSongName());
                playAudio.putExtra("albumName", song.getAlbumName());
                playAudio.putExtra("artistName", song.getArtistName());
                playAudio.putExtra("position", position);
                startActivity(playAudio);
            }
        });
    }
}
