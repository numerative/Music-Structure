package com.michaelhat.musicstructureplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    ArrayList<Song> songsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        generateSongList(); //Generate Songs ArrayList

        //Create an instance of SongListAdapter
        SongListAdapter songListAdapter = new SongListAdapter(this, songsList);
        ListView songListView = findViewById(R.id.song_list_view);

        songListView.setAdapter(songListAdapter);
    }

    private void generateSongList() {
        songsList = new ArrayList<>();
        songsList.add(new Song(
                "Pehla Nasha",
                "Jo Jeeta Wohi Sikandar",
                "Udit Narayan, Sadhana Sargam"));
        songsList.add(new Song(
                "Chhaiya Chhaiya",
                "Dil Se...",
                "Sukhwinder Singh, Sapna Awasthi"));
        songsList.add(new Song(
                "Chhupana Bhi Nahin Aata",
                "Baazigar",
                "Vinod Rathod"));
        songsList.add(new Song(
                "Nazar Ke Samne",
                "Aashiqui",
                "Kumar Sanu"));
        songsList.add(new Song(
                "Do Dil Mil Rahe Hai",
                "Pardes",
                "Kumar Sanu"));
        songsList.add(new Song(
                "Tu Hi Re",
                "Bombay",
                "Hariharan, Kavita Krishnamurthy"));
    }
}
