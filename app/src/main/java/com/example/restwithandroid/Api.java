package com.example.restwithandroid;

import java.util.List;

import com.example.restwithandroid.models.Track;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;

public interface Api {

    @GET("tracks")
    Call<List<Track>> getTracks();

    @GET("tracks/{id}")
    Call<Track> getTrack(@Path("id") String id);

    @DELETE("tracks/{id}")
    Call<Track> deleteTrack(@Path("id") String id);

    @PUT("tracks")
    Call<Track> updateTrack(@Body Track track);

    @POST("tracks")
    Call<Track> newTrack(@Body Track track);

}
