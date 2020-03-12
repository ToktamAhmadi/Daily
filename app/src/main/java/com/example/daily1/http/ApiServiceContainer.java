package com.example.daily1.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * this is a retrofit that implements from instance of ApiService once
 * hold it in flow of app
 * result of it one time instance of ApiService
 * don't need every time create object
 */
public class ApiServiceContainer {

    //instance of ApiService
    //private because of control for create apiservice
    private static ApiService apiService;

    //lazy loading = every time we need it instance apiService create
    public static ApiService getApiService() {
        if(apiService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.myjson.com/bins/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
