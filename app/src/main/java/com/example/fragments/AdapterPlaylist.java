package com.example.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.databinding.ItemPlaylistBinding;

import java.util.ArrayList;

public class AdapterPlaylist extends RecyclerView.Adapter<AdapterPlaylist.PlaylistViewHolder> {

    private ArrayList<Playlist> playlist ;
    private PlaylistOnClick playlistOnClick;

    public AdapterPlaylist(ArrayList<Playlist> playlist, PlaylistOnClick playlistOnClick) {
        this.playlist = playlist;
        this.playlistOnClick = playlistOnClick;
    }



    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPlaylistBinding binding = ItemPlaylistBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlaylistViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(playlist.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playlistOnClick.OnClickPlay(playlist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return playlist.size();
    }


    public class PlaylistViewHolder extends RecyclerView.ViewHolder  {
       private ItemPlaylistBinding binding;

        public PlaylistViewHolder(@NonNull ItemPlaylistBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;

        }

        public void bind(Playlist playlist) {
           binding.number.setText(String.valueOf(getAdapterPosition() + 1));
            binding.track.setText(playlist.getTrack());
            binding.artist.setText(playlist.getArtist());
            binding.time.setText(playlist.getTime());

        }


    }
}
