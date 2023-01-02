package edu.upc.dsa.restandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import edu.upc.dsa.restandroid.models.Track;
import retrofit2.Call;

public class ListOfTracks extends AppCompatActivity {
    Api APIservice;

    Button logout;

    private RecyclerView recyclerViewGadgets;
    private RecyclerViewAdapter adaptadorGadgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        //recyclerViewGadgets= new RecyclerView(this);
        recyclerViewGadgets=(RecyclerView)findViewById(R.id.recyclerTracks);
        Log.d("DDDD", ""+recyclerViewGadgets);
        recyclerViewGadgets.setLayoutManager(new LinearLayoutManager(this));
        //tableLayout = findViewById(R.id.tableLayout);
        //logout =findViewById(R.id.logOutBtn);
        APIservice = RetrofitClient.getInstance().getMyApi();
        Call<List<Track>> call = APIservice.getTracks();
        try {
            adaptadorGadgets= new RecyclerViewAdapter(call.execute().body());
            //buildTable(call);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recyclerViewGadgets.setAdapter(adaptadorGadgets);
    }


    public void goBackList(View view){
        Intent intentRegister = new Intent(ListOfTracks.this, MainActivity.class);
        ListOfTracks.this.startActivity(intentRegister);
    }
    public void updateCard(View view){
        Log.i("FIRST ACCOMPLISHMENT:","CLOSER TO GET THE UPDATE");
        Intent intent = new Intent(ListOfTracks.this, UpdateTrack.class);
        ListOfTracks.this.startActivity(intent);
    }

}


