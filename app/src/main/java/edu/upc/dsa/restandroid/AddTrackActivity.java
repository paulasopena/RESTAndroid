package edu.upc.dsa.restandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import edu.upc.dsa.restandroid.models.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTrackActivity extends AppCompatActivity {
    Api APIservice;
    TextInputEditText titleAddedTrack;
    TextInputEditText singerAddedTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_track_activity);
    }
    public void clickAddButton(View view){
        titleAddedTrack=findViewById(R.id.titleTxt);
        singerAddedTrack=findViewById(R.id.singerTxt);

        Track track= new Track(titleAddedTrack.getText().toString(),singerAddedTrack.getText().toString());
        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<Track> call=APIservice.newTrack(track);
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()) {
                    case 201:
                        Snackbar snaky201 = Snackbar.make(view, "The track has been correctly added!", 3000);
                        snaky201.show();
                        break;
                    case 409:
                        Snackbar snaky409 = Snackbar.make(view, "The track has not been added correctly!", 3000);
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
    public void goBackAdd(View view){
        Intent intentRegister = new Intent(AddTrackActivity.this, MainActivity.class);
        AddTrackActivity.this.startActivity(intentRegister);
    }

}
