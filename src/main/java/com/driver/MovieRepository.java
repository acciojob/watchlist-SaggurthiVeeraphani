package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieDB;
    private HashMap<String,Director> directorDB ;
    private HashMap<String,List<String>> movieDirectorDB;

    //initialization
    public MovieRepository(){
        this.movieDB = new HashMap<String,Movie>();
        this.directorDB = new HashMap<String,Director>();
        this.movieDirectorDB = new HashMap<String,List<String>>();
    }

    public void addmovieinDB(Movie movie){

        movieDB.put(movie.getName(),movie);
    }
    public void adddirectorinDB(Director director){
        directorDB.put(director.getName(),director);
    }
    public void adddirectorMovieInDB(String director,String movie){
       if(movieDB.containsKey(movie)  &&  directorDB.containsKey(director)){
           List<String> movies = new ArrayList<>();
           if(movieDirectorDB.containsKey(director)){
               movies = movieDirectorDB.get(director);
           }
           movies.add(movie);
           movieDirectorDB.put(director,movies);
       }
    }
    public Movie getMovieFromDB(String movie){
        return movieDB.get(movie);
    }
    public Director getdirectorFromDB(String director){
        return directorDB.get(director);
    }

    public List<String> getmoviesbyDirectorINDB(String director){
        List<String> moviesL = new ArrayList<>();
        if(movieDirectorDB.containsKey(director)){
            moviesL = movieDirectorDB.get(director);
        }
        return moviesL;
    }
    public List<String> getallmoviesinDB(){
       return new ArrayList<>(movieDB.keySet());
    }

    public void deletedirectorfromDB(String director){
      List<String> movies = new ArrayList<>();
      if(movieDirectorDB.containsKey(director)){
          movies = movieDirectorDB.get(director);
          for(String movie : movies){
              if(movieDB.containsKey(movie)){
                  movieDB.remove(movie);
              }
          }
      }
      movieDirectorDB.remove(director);
      if(directorDB.containsKey(director)){
          directorDB.remove(director);
      }
    }

    public void deletealldirectorinDB(){
        HashSet<String> fullmovielist = new HashSet<String>();

        directorDB = new HashMap<>();
        for(String director : movieDirectorDB.keySet()){
            for(String movie : movieDirectorDB.get(director)){
                fullmovielist.add(movie);
            }
        }
        for(String movie : fullmovielist) {
            if (movieDB.containsKey(movie)) {
                movieDB.remove(movie);
            }
        }
        //clearing the pair
        movieDirectorDB = new HashMap<>();

    }





}
