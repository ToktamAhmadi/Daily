package com.example.daily1.http;

import com.example.daily1.model.data.Material;
import com.example.daily1.model.data.Pack;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * ApiService is a interface for send request to database
 * and retrofit use it
 */
public interface ApiService {

    //from server response list of packs as single
    @GET("f7flg")
    Single<List<Pack>> packs();

    @GET("15r358")
    Single<List<Material>> materials();



}
