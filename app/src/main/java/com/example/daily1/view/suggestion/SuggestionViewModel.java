package com.example.daily1.view.suggestion;

import com.example.daily1.base.BaseViewModel;
import com.example.daily1.model.data.Pack;
import com.example.daily1.model.repo.PackRepository;

import java.util.List;

import io.reactivex.Single;

/**
 * this class for send parameter to repository
 * that decide for request
 */
public class SuggestionViewModel extends BaseViewModel {
    //for send parameter to repository then need repository in constructor
    private PackRepository packRepository;
    public SuggestionViewModel(PackRepository packRepository){
        this.packRepository= packRepository;
    }

    public Single<List<Pack>> getPacks(){
        return packRepository.getPacks();
    }
}
