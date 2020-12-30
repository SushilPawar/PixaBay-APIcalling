package com.example.advancetopics.Json_parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.advancetopics.R;
import com.squareup.picasso.Picasso;

public class Pixabay_details extends AppCompatActivity {
    ImageView pixaimage;
    TextView pixacreator,pixalikes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pixabay_details);

        pixaimage = findViewById(R.id.pixaimage);
        pixacreator = findViewById(R.id.pixacreator);
        pixalikes = findViewById(R.id.pixalike);

        Intent intent = getIntent();
//        String url = intent.getStringExtra("image");
//        String creator = intent.getStringExtra("creator");
        int likes = intent.getIntExtra("likes",0);


        //Picasso.with(this).load(url).fit().centerInside().into(pixaimage);
       // pixacreator.setText(creator);
        pixalikes.setText("Likes: "+likes);

        pixacreator.setText(getIntent().getStringExtra("creator"));
        Picasso.with(this).load(getIntent().getStringExtra("image")).fit().centerInside().into(pixaimage);
    }
}