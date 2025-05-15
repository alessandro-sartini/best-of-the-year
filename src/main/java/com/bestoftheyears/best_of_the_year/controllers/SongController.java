package com.bestoftheyears.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bestoftheyears.best_of_the_year.classes.Song;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class SongController {

    private List<Song> getBestSongs() {
        List<Song> songsList = new ArrayList<>();
        songsList.add(new Song("Bohemian Rhapsody", 1));
        songsList.add(new Song("Imagine", 2));
        songsList.add(new Song("Smells Like Teen Spirit", 3));
        return songsList;
    }

    @GetMapping("/songs")
    public String getSongs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

}
