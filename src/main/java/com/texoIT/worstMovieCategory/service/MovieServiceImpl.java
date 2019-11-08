package com.texoIT.worstMovieCategory.service;

import com.texoIT.worstMovieCategory.model.Movie;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MovieServiceImpl {

    private static List<Movie> listMovies = new ArrayList<>();
    private static AtomicInteger counterMovies = new AtomicInteger();
    static {
        try{
            InputStream inputStream = new FileInputStream("src/main/resources/csv/movielist.csv");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            boolean first = true;
            while (null != (line = bufferedReader.readLine())){
                if (first) {
                    first = false;
                    continue;
                }

                String[] row = line.split(";");
                listMovies.add(getEntity(counterMovies.incrementAndGet(), row));
            }

            bufferedReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static Movie getEntity(Integer idMovie, String[] row){
        Integer yearMovie = null;
        try{
            yearMovie = Integer.parseInt(row[0]);
        } catch (Exception e) {
        }

        String title = row[1];
        List<String> lastStudios = Arrays.asList(row[2].split(",\\s*"));
        List<String> lastProducers = Arrays.asList(row[3].split(",\\s*"));
        boolean winnerMovie = false;
        try {
            if (row[4].equalsIgnoreCase("yes")) {
                winnerMovie = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            winnerMovie = false;
        }

        Movie movie = new Movie(idMovie, yearMovie, title, lastStudios, lastProducers, winnerMovie);

        return movie;
    }

    public List<Movie> getListMovies() {
        return listMovies;
    }

}

