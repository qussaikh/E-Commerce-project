package com.qussai.security.webService.controller;

import com.qussai.security.webService.entity.Movie;
import com.qussai.security.webService.entity.MovieRequest;
import com.qussai.security.webService.sevice.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    // Service for managing Movie entities.
    private final MovieService service;

    // Endpoint to save a new movie or update an existing one based on the request.
    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody MovieRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    // Endpoint to retrieve a list of all movies.
    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Endpoint to retrieve a movie by its unique identifier.
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Integer id){
           return ResponseEntity.ok(service.findById(id));
    }

    // Endpoint to update an existing movie based on the provided request.
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
                                           @RequestBody MovieRequest request) {
        service.updateMovie(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Endpoint to delete a movie by its unique identifier.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteMovie(id);

    }
}
