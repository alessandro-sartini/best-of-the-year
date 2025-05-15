package com.bestoftheyears.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bestoftheyears.best_of_the_year.classes.Song;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/songs/{id}")
    public String getSongsById(Model model, @PathVariable("id") int id) {
        Song foundSong = null;
        for (Song song : getBestSongs()) {
            if (song.getId() == id) {
                foundSong = song;
                break;
            }
        }

        if (foundSong != null) {
            model.addAttribute("song", foundSong);
        } else {
            String fail = "Elemento non trovato";
            model.addAttribute("errorMessage", fail);

        }
        return "singleSong";
    }

}
