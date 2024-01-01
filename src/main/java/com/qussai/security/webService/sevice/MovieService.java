package com.qussai.security.webService.sevice;

import com.qussai.security.webService.entity.Movie;
import com.qussai.security.webService.entity.MovieRequest;
import com.qussai.security.webService.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    // Repository for accessing Movie data.
    private final MovieRepository repository;


    // Save a new movie or update an existing one based on the request.
    public void save(MovieRequest request) {
        var movie = Movie.builder()
                .id(request.getId())
                .title(request.getTitle())
                .rating(request.getRating())
                .description(request.getDescription())
                .build();
        repository.save(movie);
    }

    // Retrieve a list of all movies.
    public List<Movie> findAll() {
        return repository.findAll();
    }

    // Retrieve a movie by its unique identifier.
    public Optional<Movie> findById(Integer id) {
        return repository.findById(id);
    }

    // Delete a movie by its unique identifier.
    public void deleteMovie(Integer id) {
        repository.deleteById(id);
    }

    // Update an existing movie based on the provided request.
    public void updateMovie(Integer id, MovieRequest request) {
        Optional<Movie> optionalMovie = repository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(request.getTitle());
            existingMovie.setRating(request.getRating());
            existingMovie.setDescription(request.getDescription());

            repository.save(existingMovie);
        } else {
            System.out.println("Movie not found with id: " + id);
        }
    }



}
