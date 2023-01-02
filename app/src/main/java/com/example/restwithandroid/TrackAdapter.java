package com.example.restwithandroid;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restwithandroid.models.Track;

import java.util.List;
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

    List<Track> trackList;
    Context context;

    public TrackAdapter(Context context , List<Track> tracks){
        this.context = context;
        trackList = tracks;
    }
    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        Track track = trackList.get(position);
        holder.id.setText("id : " + track.getId());
        holder.singer.setText("singer :" + track.getSinger());
        holder.title.setText("title : " + track.getTitle());

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder{
        TextView id , singer, title ;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.infoId);
            singer = itemView.findViewById(R.id.infoSinger);
            title = itemView.findViewById(R.id.infoTitle);


        }
    }
}
