package com.example.thecoachtimer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PlayersAdapter;
import com.example.Player;
import com.example.thecoachtimer.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    PlayersAdapter adapter;

    List<Player> playerList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //metto qui l adapter
        // Create the observer which updates the UI.
        final Observer<List<Player>> nameObserver = new Observer<List<Player>>() {
            @Override
            public void onChanged(@Nullable List<Player> playerList) {
                adapter = new PlayersAdapter( getContext(), playerList);
                recyclerView.setAdapter(adapter);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        homeViewModel.getCurrentplayersList().observe(getViewLifecycleOwner(), nameObserver);
        //homeViewModel.getplayersList().observe(getViewLifecycleOwner(), textView::setText);
        //
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}