package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragments.databinding.FragmentFirstBinding;
import com.example.fragments.databinding.FragmentSecondBinding;

import java.util.ArrayList;


public class secondFragment extends Fragment implements PlaylistOnClick {
    public final String KEY_SEC = "key";
    private FragmentSecondBinding binding;
    private AdapterPlaylist adapterPlaylist;
    private ArrayList<Playlist> playlist;


    public secondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()),
                container, false);
        return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();

        adapterPlaylist = new AdapterPlaylist(playlist, this);
        binding.recycler.setAdapter(adapterPlaylist);


    }

    private void loadData() {
        playlist = new ArrayList<>();
        playlist.add(new Playlist( "Dealer", "Lana Del Rey", "5:32"));
        playlist.add(new Playlist( "Die For You", "The Weekend", "5:32"));
        playlist.add(new Playlist( "Ugly Boy", "Die Antwoord", "5:32"));
        playlist.add(new Playlist( "LES", "Childish Gambino", "5:32"));
        playlist.add(new Playlist( "JoJo Pose", "Apollo Fresh", "5:32"));
        playlist.add(new Playlist( "Alystama", "Moldanazar", "5:32"));
        playlist.add(new Playlist( "The real slim shady", "Eminem", "5:32"));
        playlist.add(new Playlist( "Without me", "Eminem", "5:32"));
        playlist.add(new Playlist( "Without me", "Eminem", "5:32"));
        playlist.add(new Playlist( "Without me", "Eminem", "5:32"));

    }

    @Override
    public void OnClickPlay(Playlist playlist) {
        Bundle bundle = new Bundle();
        Fragment fragment = new ThirdFragment();
        bundle.putString(KEY_SEC, playlist.getTrack());
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .addToBackStack("back").commit();
    }
}