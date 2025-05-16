package com.bestoftheyears.best_of_the_year.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bestoftheyears.best_of_the_year.classes.Movie;

@Controller
@RequestMapping("/")
public class MovieController {

    private List <Movie> getBestMovies() {
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("Il Padrino", 1));
        moviesList.add(new Movie("Inception", 2));
        moviesList.add(new Movie("Pulp Fiction", 3));
        return moviesList;
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }
    @GetMapping("/movies/{id}")
    public String getSingleMovies(Model model, @PathVariable int id) {
        Movie foundMovie=null;
        for (Movie movie : getBestMovies()) {
            
            if (movie.getId()==id) {
                foundMovie=movie;
                break;
            }

        }

        if (foundMovie!=null) {
            model.addAttribute("movie",foundMovie);
        }else{
            String notFound="nessun film trovato";
            model.addAttribute("errorMessage",notFound);
        }

        return "singleMovie";
    }

}
