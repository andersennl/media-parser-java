package com.company;

public class Movie {
    private String name;

    public Movie(String name) {
        this.name = name.replaceFirst(".mkv", "");
    }

    public String toString() {
        return this.name;
    }
}
