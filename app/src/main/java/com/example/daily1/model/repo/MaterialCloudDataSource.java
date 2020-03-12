package com.example.daily1.model.repo;

import com.example.daily1.http.ApiService;
import com.example.daily1.model.data.Material;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * this class for get data from server
 * and request to server
 */
public class MaterialCloudDataSource implements MaterialDataSource {
    //for request to server we need apiService
    //and write constructor
    private ApiService apiService;
    public MaterialCloudDataSource(ApiService apiService)
    {
        this.apiService=apiService;
    }

    @Override
    public Single<Material> get(Integer id) {
        return null;
    }

    @Override
    public Completable delete(Material item) {
        return null;
    }

    @Override
    public Single<List<Material>> getAll(int page) {
        return apiService.materials();
    }

    @Override
    public Single<Material> insert(Material item) {
        return null;
    }

    @Override
    public Single<Material> update(Material item) {
        return null;
    }
}
