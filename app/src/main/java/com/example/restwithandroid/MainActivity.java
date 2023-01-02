package com.example.restwithandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restwithandroid.models.Track;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    Api APIservice;
    EditText trackId;
    EditText trackSinger;
    EditText trackTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void getTracks(View view){

        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<List<Track>> call = APIservice.getTracks();

        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                switch (response.code()){
                    case 201:
                        List<Track> trackList = response.body();
                        TrackAdapter trackAdapter = new TrackAdapter(MainActivity.this , trackList);
                        recyclerView.setAdapter(trackAdapter);
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }
    public void getTrack(View view){
        trackId=findViewById(R.id.trackIdBox);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<Track> call = APIservice.getTrack(trackId.getText().toString());
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()){
                    case 201:
                        List<Track> trackList = new ArrayList<>();
                        Track track = response.body();
                        trackList.add(track);
                        TrackAdapter trackAdapter = new TrackAdapter(MainActivity.this , trackList);
                        recyclerView.setAdapter(trackAdapter);
                        break;
                    case 404:
                        Snackbar snaky409 = Snackbar.make(view, "Track doesn't exist", 3000);
                        snaky409.show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }
    public void deleteTracks(View view){
        trackId=findViewById(R.id.trackIdBox);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<Track> call = APIservice.deleteTrack(trackId.getText().toString());
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()){
                    case 201:
                        Snackbar snaky201 = Snackbar.make(view, "Track deleted", 3000);
                        snaky201.show();
                        break;
                    case 404:
                        Snackbar snaky409 = Snackbar.make(view, "Track doesn't exist", 3000);
                        snaky409.show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }
    public void updateTracks(View view){
        trackId=findViewById(R.id.trackIdBox);
        trackSinger=findViewById(R.id.trackSingerBox);
        trackTitle=findViewById(R.id.trackTitleBox);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Track track= new Track(trackId.getText().toString(),trackSinger.getText().toString(),trackTitle.getText().toString());
        Call<Track> call = APIservice.updateTrack(track);
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()){
                    case 201:
                        Track track =response.body();
                        List<Track> trackList = new ArrayList<>();
                        trackList.add(track);
                        TrackAdapter trackAdapter = new TrackAdapter(MainActivity.this , trackList);
                        recyclerView.setAdapter(trackAdapter);
                        break;
                    case 404:
                        Snackbar snaky409 = Snackbar.make(view, "Track doesn't exist", 3000);
                        snaky409.show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }
    public void createTracks(View view){
        trackId=findViewById(R.id.trackIdBox);
        trackSinger=findViewById(R.id.trackSingerBox);
        trackTitle=findViewById(R.id.trackTitleBox);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Track track= new Track(trackId.getText().toString(),trackSinger.getText().toString(),trackTitle.getText().toString());
        Call<Track> call = APIservice.newTrack(track);
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()){
                    case 201:
                        Track track =response.body();
                        List<Track> trackList = new ArrayList<>();
                        trackList.add(track);
                        TrackAdapter trackAdapter = new TrackAdapter(MainActivity.this , trackList);
                        recyclerView.setAdapter(trackAdapter);
                        break;
                    case 500:
                        Snackbar snaky500 = Snackbar.make(view, "Validation error", 3000);
                        snaky500.show();
                        break;
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                Snackbar snakyfail = Snackbar.make(view, "NETWORK FAILURE", 3000);
                snakyfail.show();
            }
        });
    }

}