package com.example.mobiustask.networking;

import com.example.mobiustask.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("4c663239-03af-49b5-bcb3-0b0c41565bd2")
    Call<DataModel> getNewsList();
}
