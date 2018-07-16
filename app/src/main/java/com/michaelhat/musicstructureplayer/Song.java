package com.michaelhat.musicstructureplayer;

public class Song {
    private String mSongName, mAlbumName, mArtistName;

    public Song(String songName, String albumName, String artistName) {
        mSongName = songName;
        mAlbumName = albumName;
        mArtistName = artistName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getAlbumName() {
        return mAlbumName;
    }

    public String getArtistName() {
        return mArtistName;
    }
}
