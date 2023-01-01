package com.example.restwithandroid;

import java.util.List;

import com.example.restwithandroid.models.Track;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;

public interface Api {

    @GET("/")
    Call<List<Track>> getTracks();

    @GET("/{id}")
    Call<Track> getTrack(@Body String id);

    @DELETE("/{id}")
    Call<Track> deleteTrack(@Body String id);

    @PUT("/")
    Call<Track> updateTrack(@Body Track track);

    @POST("/")
    Call<Track> newTrack(@Body Track track);

}
