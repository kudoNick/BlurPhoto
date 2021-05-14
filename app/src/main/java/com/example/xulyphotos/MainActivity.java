package com.example.xulyphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imgPhoto);

        // thêm thư viện " implementation 'com.github.bumptech.glide:glide:3.7.0' " để sự dụng Glide
        Glide.with(this)
                .load(R.drawable.photos)
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!check) {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.photos)
                            .asBitmap()
                            .transform(new BlurTransformation(getApplicationContext()))
                            .into(imageView);
                    check = true;
                }else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.photos)
                            .into(imageView);
                    check = false;
                }
            }
        });
    }
}