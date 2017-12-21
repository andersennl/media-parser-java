package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HtmlGenerator {
    private Library library;
    private final String path = "/Users/andersennl/Desktop/media.html";
    private final String mediaServerUrl = "http://mediaserver.local:32400/web/index.html";

    HtmlGenerator(Library library) {
        this.library = library;
    }

    public void generateHtml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<HTML>");
        builder.append("<head>");
        builder.append("<title>Mediaserver Java, NGINX</title>");
        builder.append("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        builder.append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' crossorigin='anonymous'>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<div class='container fluid'>");

        builder.append("<div class='row'>");
        builder.append("<div class='col-md-12'>");
        builder.append("<h1>Mediaserver</h1>");
        builder.append("<p>");
        builder.append("Last updated at: ");
        builder.append(getCurrentDatetime());
        builder.append("</p>");
        builder.append(String.format("<p><a href='%s' target='_self'>Plex Media Server</a></p>", mediaServerUrl));
        builder.append("</div>");
        builder.append("</div>");

        builder.append("<div class='row'>");
        builder.append("<div class='col-md-12'>");
        builder.append("<h2>Filme</h2>");
        for(Movie movie : library.getMovies()) {
            builder.append(movie.toString() + "<br>");
        }
        builder.append("</div>");
        builder.append("</div>");

        builder.append("<div class='row'>");
        builder.append("<div class='col-md-12'>");
        builder.append("<h2>Serien</h2>");
        for(Series series : library.getSeries()) {
            builder.append("<p>");
            builder.append("<b>" + series.toString() + "</b><br>");

            for(Season season : series.getSeasons()) {
                builder.append(season.toString() + "<br>");
            }
            builder.append("</p>");
        }
        builder.append("</div>");
        builder.append("</div>");

        builder.append("</div>");
        builder.append("</body>");
        builder.append("</HTML>");

        String html = builder.toString();

        try {
            Files.write(Paths.get(path), html.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentDatetime() {
        return getCurrentTime().concat(getCurrentDate());
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        return time.format(cal.getTime()).concat(" Uhr, ");
    }
}
