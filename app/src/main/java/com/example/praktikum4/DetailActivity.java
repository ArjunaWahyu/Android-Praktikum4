package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_POSTER = "extra_poster";

    private String title;
    private String description;
    private int posterImage;

    private ImageView imgPoster;
    private TextView tvTitle;
    private TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        change the title of the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Movie");
        }

        imgPoster = findViewById(R.id.img_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvDescription = findViewById(R.id.tv_description);

        title = getIntent().getStringExtra(EXTRA_TITLE);
        description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        posterImage = getIntent().getIntExtra(EXTRA_POSTER, 0);

        tvTitle.setText(title);
        tvDescription.setText(description);
        imgPoster.setImageResource(posterImage);
    }
}