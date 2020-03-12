package com.example.daily1.model.repo;

import com.example.daily1.model.data.Pack;

import java.util.List;

import io.reactivex.Single;

/**
 * in this class decided get data from what source such as'cloud,local,file'
 */
public class PackRepository {

    private PackDataSource packCloudDataSource;

    public PackRepository(PackDataSource packCloudDataSource)
    {
        this.packCloudDataSource = packCloudDataSource;
    }

    //method for return list of packs
   public Single<List<Pack>> getPacks(){
        return packCloudDataSource.getAll(0);
   }
}
