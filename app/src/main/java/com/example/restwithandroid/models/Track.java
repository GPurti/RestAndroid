package com.example.restwithandroid.models;

import com.example.restwithandroid.util.RandomUtils ;
public class Track {

    String id;
    String title;
    String singer;

    public Track() {
        //this.id = RandomUtils.getId();
    }

    public Track(String id, String singer,String title ) {
        this.setId(id);
        this.setSinger(singer);
        this.setTitle(title);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Track [id="+id+", title=" + title + ", singer=" + singer +"]";
    }
}
