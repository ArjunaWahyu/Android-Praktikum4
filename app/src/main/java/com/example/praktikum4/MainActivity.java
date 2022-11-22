package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private ArrayList<Movie> listMovies = new ArrayList<>();
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        change the title of the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Movies");
        }

        listMovies.addAll(MoviesData.getMovies());

        rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(listMovies, movie -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TITLE, movie.getTitle());
            intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, movie.getDescription());
            intent.putExtra(DetailActivity.EXTRA_POSTER, movie.getPosterImage());
            startActivity(intent);
            Toast.makeText(this, movie.getTitle(), Toast.LENGTH_SHORT).show();
        });

        rvMovies.setAdapter(listMovieAdapter);

    }
}