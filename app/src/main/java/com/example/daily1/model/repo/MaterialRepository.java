package com.example.daily1.model.repo;

import com.example.daily1.model.data.Material;
import com.example.daily1.model.data.Pack;

import java.util.List;

import io.reactivex.Single;

/**
 * in this class decided get data from what source such as'cloud,local,file'
 */
public class MaterialRepository {

    private MaterialDataSource materialCloudDataSource;

    public MaterialRepository(MaterialDataSource materialCloudDataSource)
    {
        this.materialCloudDataSource = materialCloudDataSource;
    }

    //method for return list of packs
   public Single<List<Material>> getMatrials(){
        return materialCloudDataSource.getAll(0);
   }
}
