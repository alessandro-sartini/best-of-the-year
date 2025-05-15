package com.bestoftheyears.best_of_the_year.classes;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private int id;
    private String title;
    public static List<Song> listOfSongs = new ArrayList<>();

    public Song (String title, int id){
        this.title=title;
        this.id=id;
        
    }




    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
