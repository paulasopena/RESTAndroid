package edu.upc.dsa.restandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickToList(View view){
        Intent intentRegister = new Intent(MainActivity.this, ListOfTracks.class);
        MainActivity.this.startActivity(intentRegister);
    }
    public void clickToAdd(View view){
        Intent intentRegister = new Intent(MainActivity.this, AddTrackActivity.class);
        MainActivity.this.startActivity(intentRegister);
    }
    public void clickToDelete(View view){
        Intent intentRegister = new Intent(MainActivity.this, DeleteTrackActivity.class);
        MainActivity.this.startActivity(intentRegister);
    }


}
