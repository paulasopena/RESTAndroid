package edu.upc.dsa.restandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import edu.upc.dsa.restandroid.models.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteTrackActivity extends AppCompatActivity {

    Api APIservice;
    TextInputEditText titleTrackToDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_track_activity);
    }
    public void clickDelete(View view){
        APIservice = RetrofitClient.getInstance().getMyApi();
        titleTrackToDelete = findViewById(R.id.titleToDelete);
        Call<Track> call = APIservice.deleteTrack(titleTrackToDelete.getText().toString());
        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                switch (response.code()) {
                    case 201:
                        Snackbar snaky201 = Snackbar.make(view, "The track has been correctly deleted!", 3000);
                        snaky201.show();
                        break;
                    case 409:
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
    public void goBackClick(View view){
        Intent intentRegister = new Intent(DeleteTrackActivity.this, MainActivity.class);
        DeleteTrackActivity.this.startActivity(intentRegister);
    }

}
