package com.example.daily1.view.home;

import com.example.daily1.base.BaseViewModel;
import com.example.daily1.model.data.Material;
import com.example.daily1.model.data.Pack;
import com.example.daily1.model.repo.MaterialRepository;
import com.example.daily1.model.repo.PackRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * this class for send parameter to repository
 * that decide for request
 */
public class HomeViewModel extends BaseViewModel {
    //for send parameter to repository then need repository in constructor
    private PackRepository packRepository;
    private MaterialRepository materialRepository;
    public HomeViewModel(PackRepository packRepository, MaterialRepository materialRepository){
        this.packRepository= packRepository;
        this.materialRepository = materialRepository;
    }

    public Single<List<Pack>> getPacks(){
        return packRepository.getPacks();
    }
    public Single<List<Material>> getMaterials(){
        return materialRepository.getMatrials();
    }
}
