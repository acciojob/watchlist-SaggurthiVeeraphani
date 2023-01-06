package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movierepository;
    public void addmovie(Movie movie){

        movierepository.addmovieinDB(movie);
    }
    public void addirector(Director director){

        movierepository.adddirectorinDB(director);
    }
    public void addmoviedirectorPair(String director,String movie){
        movierepository.adddirectorMovieInDB(director,movie);
    }
    public Movie getMoviebyname(String movie){
        Movie movi = movierepository.getMovieFromDB(movie);
        return movi;

    }

    public Director getdirectorbyname(String director){
        Director direct1 = movierepository.getdirectorFromDB(director);
        return direct1;
    }
    public List<String> getmoviedbydirector(String director){
        List<String> movielist = movierepository.getmoviesbyDirectorINDB(director);
        return movielist;
    }

    public List<String> getallmovies(){
        List<String> movieLIst = movierepository.getallmoviesinDB();
        return movieLIst;
    }
    public void deletedirector(String director){
        movierepository.deletedirectorfromDB(director);
    }
    public void removealldirector(){
        movierepository.deletealldirectorinDB();

    }

}
