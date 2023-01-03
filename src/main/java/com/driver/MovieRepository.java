package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movieDB = new HashMap<>();
    HashMap<String,Director> directorDB = new HashMap<>();
    HashMap<String,List<Movie>> movieDirectorDB = new HashMap<>();

    public void addmovieinDB(Movie movie){
        movieDB.put(movie.getName(),movie);
    }
    public void adddirectorinDB(Director director){
        directorDB.put(director.getName(),director);
    }
    public void adddirectorMovieInDB(Director director,Movie movie){
        List<Movie> movies = movieDirectorDB.getOrDefault(director.getName(),new ArrayList<>());
        movies.add(movie);
        movieDirectorDB.put(director.getName(),movies);
    }
    public Movie getMovieFromDB(Movie movie){
        Movie movied = movieDB.get(movie.getName());
        return movied;
    }
    public Director getdirectorFromDB(Director director){
        Director directo = directorDB.get(director.getName());
        return directo;
    }
    public List<Movie> getmoviesbyDirectorINDB(Director director){
        List<Movie> moviesL = movieDirectorDB.get(director.getName());
        return moviesL;
    }
    public List<String> getallmoviesinDB(){
        List<String> ans = new ArrayList<>();
        for(String s : movieDB.keySet()){
            ans.add(s);
        }
        return ans;
    }

    public void deletedirectorfromDB(Director director){
      List<Movie> movies = movieDirectorDB.get(director.getName());
      for(Movie m : movies){
          if(movieDB.containsKey(m.getName())){
              movieDB.remove(m.getName());
          }
          movieDirectorDB.remove(director.getName());
      }
    }

    public void deletealldirectorinDB(){
        for(String m: movieDirectorDB.keySet()){
            List<Movie> movie = movieDirectorDB.get(m);
            for(Movie s : movie) {
                if (movieDB.containsKey(s.getName())) {
                    movieDB.remove(s.getName());
                }
            }
        }
        movieDirectorDB.clear();
    }





}
