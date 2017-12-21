package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Library {
    private ArrayList<Movie> movies;
    private ArrayList<Series> series;

    Library() {
        this.movies = new ArrayList<>();
        this.series = new ArrayList<>();
    }

    void addMovieLibrary(String path) {
        File folder = new File(path);

        for(File file : folder.listFiles()) {
            String name = file.getName();

            if(!name.startsWith(".")) {
                Movie movie = new Movie(name);
                this.movies.add(movie);
            }
        }
    }

    void addSeriesLibrary(String path) {
        File folder = new File(path);

        for(File file : folder.listFiles()) {
            if(file != null &&!file.getName().startsWith(("."))) {
                Series series = new Series(file);
                this.series.add(series);
            }
        }
    }

    public ArrayList<Series> getSeries() {
        series.sort(Comparator.comparing(Series::toString));
        return series;
    }

    public ArrayList<Movie> getMovies() {
        movies.sort(Comparator.comparing(Movie::toString));
        return movies;
    }
}
