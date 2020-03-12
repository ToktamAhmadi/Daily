package com.example.daily1.model.repo;

import com.example.daily1.http.ApiService;
import com.example.daily1.model.data.Pack;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * this class for get data from server
 * and request to server
 */
public class PackCloudDataSource implements PackDataSource {
    //for request to server we need apiService
    //and write constructor
    private ApiService apiService;
    public PackCloudDataSource(ApiService apiService)
    {
        this.apiService=apiService;
    }

    @Override
    public Single<Pack> get(Integer id) {
        return null;
    }

    @Override
    public Completable delete(Pack item) {
        return null;
    }

    @Override
    public Single<List<Pack>> getAll(int page) {
        return apiService.packs();
    }

    @Override
    public Single<Pack> insert(Pack item) {
        return null;
    }

    @Override
    public Single<Pack> update(Pack item) {
        return null;
    }
}
