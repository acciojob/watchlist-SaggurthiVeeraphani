package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieservice;

    //add movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        movieservice.addmovie(movie);
      return new ResponseEntity<>("Movie successfully added", HttpStatus.CREATED);
    }

    //add director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        movieservice.addirector(director);
        return new ResponseEntity<>("Director succesfully created",HttpStatus.CREATED);
    }

    //add Movie director pair
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("director")String director, @RequestParam("movie")String movie){
      movieservice.addmoviedirectorPair(director,movie);
      return new ResponseEntity<>("Pair created successfully",HttpStatus.CREATED);
    }

    // get movie by name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){
        Movie mov = movieservice.getMoviebyname(movie);
        return new ResponseEntity<>(mov, HttpStatus.CREATED);
    }

    //get Director by name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String director){
        Director direct = movieservice.getdirectorbyname(director);
        return new ResponseEntity<>(direct,HttpStatus.CREATED);
    }

    //get list of movies with director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieservice.getmoviedbydirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    //get all movies in the database
    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieservice.getallmovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director")String director){
        movieservice.deletedirector(director);
        return new ResponseEntity<>(director+"removed successfully",HttpStatus.CREATED);
    }
     @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieservice.removealldirector();
        return new ResponseEntity<>("All directors are removed successfully",HttpStatus.CREATED);
     }






}
