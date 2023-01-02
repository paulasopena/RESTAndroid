package edu.upc.dsa.restandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import edu.upc.dsa.restandroid.models.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateTrack extends AppCompatActivity {
    TextInputEditText titleTrackUpdated;
    TextInputEditText titleSingerUpdated;
    Api APIservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("REACHED:","THI POINT");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
    }
    public void sendUpdate(View view){
        titleTrackUpdated=findViewById(R.id.updateTitleTxt);
        titleSingerUpdated=findViewById(R.id.updateSingerTxt);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Track track=new Track(titleTrackUpdated.getText().toString(),titleSingerUpdated.getText().toString());
        Call<Track> call=APIservice.updateTrack(track);
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()) {
                    case 201:
                        Snackbar snaky201 = Snackbar.make(view, "The UPDATE has been correctly done!", 3000);
                        snaky201.show();
                        break;
                    case 404:
                        Snackbar snaky409 = Snackbar.make(view, "The track has not been found!", 3000);
                        snaky409.show();
                        break;
                }
            }
            @Override
            public void onFailure(Call<Track> call, Throwable t) {

            }
        });
    }


}
