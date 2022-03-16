package com.example;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://randomuser.me/api/?";

    @GET("?seed=empatica&inc=name")
    Call< ApiResponse> getPlayers();
}