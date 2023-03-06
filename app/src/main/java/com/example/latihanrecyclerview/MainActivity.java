package com.example.latihanrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.latihanrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        String[] heroes = getResources().getStringArray(R.array.heroes_name);
        ArrayList<Hero> heroes = getListHeroes();
        HeroAdapter adapter = new HeroAdapter(heroes);
        binding.rvHero.setLayoutManager(new LinearLayoutManager(this));
        binding.rvHero.setAdapter(adapter);

    }

    private ArrayList<Hero> getListHeroes(){
        String[] name = getResources().getStringArray(R.array.heroes_name);
        String[] description = getResources().getStringArray(R.array.heroes_description);
        TypedArray poster = getResources().obtainTypedArray(R.array.heroes_poster);

        ArrayList<Hero> heroes = new ArrayList<>();

        for(int i = 0; i< name.length; i++){
            //Buat Objek baru, dan berikan data name, description ke objek baru tersebut
            Hero hero = new Hero();
            hero.setName(name[i]);
            hero.setDescription(description[i]);
            hero.setPoster(poster.getResourceId(i,-1));
            //tambahkan objek baru tersebut ke variabel list hero
            heroes.add(hero);
        }

        return heroes;
    }

}