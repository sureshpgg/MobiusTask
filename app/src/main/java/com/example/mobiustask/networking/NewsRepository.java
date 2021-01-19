package com.example.mobiustask.networking;


import androidx.lifecycle.MutableLiveData;

import com.example.mobiustask.model.DataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private static NewsRepository newsRepository;

    public static NewsRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private NewsApi newsApi;

    public NewsRepository(){
        newsApi = RetrofitService.cteateService(NewsApi.class);
    }

    public MutableLiveData<DataModel> getNews(){
        final MutableLiveData<DataModel> newsData = new MutableLiveData<>();
        newsApi.getNewsList().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call,
                                   Response<DataModel> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
