package com.company;

public class Main {
    private static final String devMoviePath = "/Users/andersennl/Desktop/testmovies";
    private static final String devSeriesPath = "/Users/andersennl/Desktop/testseries";

    private static final String prodMoviePath = "/media/Filmplatte/Filme";
    private static final String prodSeriesPath = "/media/Filmplatte/Serien";

    public static void main(String[] args) {

        Library library = new Library();
        library.addMovieLibrary(prodMoviePath);
        library.addSeriesLibrary(prodSeriesPath);

        HtmlGenerator generator = new HtmlGenerator(library);
        generator.generateHtml();
    }
}
