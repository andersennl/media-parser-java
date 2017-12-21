package com.company;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addMovieLibrary("/Users/andersennl/Desktop/testmovies");
        library.addSeriesLibrary("/Users/andersennl/Desktop/testseries");

        HtmlGenerator generator = new HtmlGenerator(library);
        generator.generateHtml();
    }
}
