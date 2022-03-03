package com.example.thecoachtimer.ui.home;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<String>> playersList;

    LiveData<List<String>> getplayersList() {
        if (playersList == null) {
            playersList = new MutableLiveData<>();
            loadplayersList();
        }
        return playersList;
    }

    private void loadplayersList(){
        List<String> playersListString = new ArrayList<>();
        playersListString.add("giocatore 1");
        playersListString.add("giocatore 2");
        playersListString.add("giocatore 3");
        playersList.setValue(playersListString);
    }
    

    public LiveData<List<String>> getText() {
        return playersList;
    }
}