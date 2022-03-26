package com.example.thecoachtimer.ui.home;

import android.util.Log;
import android.widget.Toast;

import com.example.Api;
import com.example.ApiResponse;
import com.example.Player;
import com.example.Playername;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Player>> playersList;

    LiveData<List<Player>> getCurrentplayersList() {
        if (playersList == null) {
            playersList = new MutableLiveData<>();
            loadplayersList();
        }
        return playersList;
    }

    private void loadplayersList(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ApiResponse> call = api.getPlayers();
        Log.d("","after api call");

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                //finally we are setting the list to our MutableLiveData
                Log.d("xxx","response"+response.toString());
                Log.d("xxx","response body "+response.body());

                ApiResponse apiResponse = response.body();
                List <Player> results = apiResponse.getResults();
                Log.d("xxx","results item "+results.get(0).getName());
                playersList.setValue(apiResponse.getResults());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

                Log.d("xxx","failure test");
            }
        });

    }


    public LiveData<List<Player>> getText() {
        return playersList;
    }
}