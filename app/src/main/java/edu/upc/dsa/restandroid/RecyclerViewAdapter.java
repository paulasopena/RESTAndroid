package edu.upc.dsa.restandroid;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.restandroid.models.Track;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView id, trackTitle, trackSinger;
        ImageView trackImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            trackTitle =(TextView)itemView.findViewById(R.id.trackTitle);
            trackSinger =(TextView)itemView.findViewById(R.id.trackSinger);
            trackImage =(ImageView) itemView.findViewById(R.id.imgTrack);
        }
    }
    public List<Track> tracks;

    public RecyclerViewAdapter(List<Track> tracks) {
        this.tracks = tracks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_track,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.trackSinger.setText(tracks.get(position).getTitle());
        holder.trackTitle.setText(tracks.get(position).getSinger());
        holder.trackImage.setImageResource(R.drawable.discos);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }



}
