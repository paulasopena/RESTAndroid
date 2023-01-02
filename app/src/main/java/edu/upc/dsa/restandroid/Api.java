package edu.upc.dsa.restandroid;

import java.util.List;

import edu.upc.dsa.restandroid.models.Track;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {


    @POST("tracks/addNew")
    Call<Track> newTrack(@Body Track newTrack);

    @GET("tracks/all")
    Call<List<Track>> getTracks();

    @DELETE("tracks/{titleTrack}")
    Call<Track> deleteTrack(@Path("titleTrack") String titleTrack);

    @PUT("tracks/updateTrack")
    Call<Track> updateTrack(@Body Track newTrack);


}
