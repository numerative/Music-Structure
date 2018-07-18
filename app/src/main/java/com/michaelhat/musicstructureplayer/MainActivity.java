package com.michaelhat.musicstructureplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Song> songsList;
    @BindView(R.id.player_screen_album)
    TextView playedAlbumName;
    @BindView(R.id.player_screen_artist)
    TextView playedArtistName;
    //TextViews Displaying Song Information
    @BindView(R.id.player_screen_song1)
    TextView playedSongName;
    //Next and Previous Buttons
    @BindView(R.id.previous_button)
    Button previousButton;
    @BindView(R.id.next_button)
    Button nextButton;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateSongList(); //Generate Songs ArrayList
        ButterKnife.bind(this);
        Intent getIntent = getIntent();
        try {
            //Try setting the text. If intent in null, a NullPointerException will be caught.
            playedSongName.setText(getIntent.getStringExtra("songName"));
            playedAlbumName.setText(getIntent.getStringExtra("albumName"));
            playedArtistName.setText(getIntent.getStringExtra("artistName"));
            //Getting the position of the selected. Will be used when clicking on next and previous buttons
            position = getIntent.getIntExtra("position", 0);
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

        //SettingOnClickListeners to the Next and Previous Buttons
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchNextSong();
            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchPreviousSong();
            }
        });
    }

    private void fetchNextSong() {
        position++; //Adding a value +1 to the position
        if (position < songsList.size()) {
            fetchSong(position);
        } else {
            position = 0;
            fetchSong(position);
        }
    }

    private void fetchPreviousSong() {
        position--; //Reducing a value from the position
        if (position < 0) {
            position = songsList.size() - 1;
            fetchSong(position);
        } else {
            fetchSong(position);
        }
    }

    private void fetchSong(int position) {
        playedSongName.setText(songsList.get(position).getSongName());
        playedAlbumName.setText(songsList.get(position).getAlbumName());
        playedArtistName.setText(songsList.get(position).getArtistName());
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
