package com.example.fragments;

public class Playlist {
    private String track;
    private String artist;
    private String time;

    public Playlist( String track, String artist, String time) {
        this.track = track;
        this.artist = artist;
        this.time = time;
    }


    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
