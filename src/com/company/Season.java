package com.company;

import java.io.File;

public class Season {
    private File folder;
    private int episodes;

    Season(File folder) {
        this.folder = folder;
        this.episodes = 0;

        for(File file : folder.listFiles()) {
            if(file != null && !file.getName().startsWith(".")) {
                this.episodes++;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s Episoden", episode(folder.getName()), episodes);
    }

    private String episode(String alt) {
        return alt.replaceFirst("season", "Staffel");
    }
}
