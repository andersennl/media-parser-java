package com.company;

import java.io.File;
import java.util.ArrayList;

public class Series {
    private File seriesFolder;
    private ArrayList<Season> seasons;

    public Series(File file) {
        this.seriesFolder = file;
        this.seasons = new ArrayList<>();

        for(File folder : this.seriesFolder.listFiles()) {
            if(folder != null) {
                if(!folder.getName().startsWith(".")) {
                    Season season = new Season(folder);
                    this.seasons.add(season);
                }
            }
        }
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public String toString() {
        return seriesFolder.getName();
    }
}
