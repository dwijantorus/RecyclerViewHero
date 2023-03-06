package com.example.latihanrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.latihanrecyclerview.databinding.ActivityDetailBinding;
import com.example.latihanrecyclerview.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        intent = getIntent();
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        int poster = intent.getIntExtra("poster",R.drawable.sukarno);

        binding.heroName.setText(name);
        binding.heroDescription.setText(description);
        binding.heroPoster.setImageResource(poster);
    }
}