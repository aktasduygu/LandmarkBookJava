package com.example.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.landmarkbookjava.databinding.ActivityDetailsBinding;
import com.example.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        landmarkArrayList = new ArrayList<>();

        //Data
        Landmark pisa = new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark collosseum = new Landmark("Collosseum", "Italy",R.drawable.colosseum);
        Landmark bridge = new Landmark("Bridge","UK",R.drawable.bridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(collosseum);
        landmarkArrayList.add(bridge);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

      /*  //Adapter
        //List View

        ArrayAdapter arrayAdapter =new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())  //landmarkı landmark.name dönüştür demek.
        );
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,landmarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                startActivity(intent);


            }
        });

*/


    }
}