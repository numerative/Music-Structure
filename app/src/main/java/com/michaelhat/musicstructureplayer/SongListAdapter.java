package com.michaelhat.musicstructureplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListAdapter extends ArrayAdapter<Song> {

    public SongListAdapter(@NonNull Context context, @NonNull ArrayList<Song> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_list_item, parent, false
            );
        }

        //Get the object at this position in this list
        Song currentSong = getItem(position);

        //Find Each of the TextViews and setText
        //Song Name
        TextView songNameTextView = listItemView.findViewById(R.id.list_song_name);
        songNameTextView.setText(currentSong.getSongName());

        //Artist Name
        TextView artistNameTextView = listItemView.findViewById(R.id.list_artist_name);
        artistNameTextView.setText(currentSong.getArtistName());

        //Album Name
        TextView albumNameTextView = listItemView.findViewById(R.id.list_album_name);
        albumNameTextView.setText(currentSong.getAlbumName());

        return listItemView;
    }
}
