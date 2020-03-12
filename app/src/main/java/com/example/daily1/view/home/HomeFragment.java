package com.example.daily1.view.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daily1.R;
import com.example.daily1.base.BaseFragment;
import com.example.daily1.base.ObserverFragment;
import com.example.daily1.components.image.ImageLoadingSerrviceInjector;
import com.example.daily1.http.ApiService;
import com.example.daily1.http.ApiServiceContainer;
import com.example.daily1.model.data.Material;
import com.example.daily1.model.data.Pack;
import com.example.daily1.model.repo.MaterialCloudDataSource;
import com.example.daily1.model.repo.MaterialRepository;
import com.example.daily1.model.repo.PackCloudDataSource;
import com.example.daily1.model.repo.PackRepository;
import com.example.daily1.view.home.adapter.MaterialAdapterHome;
import com.example.daily1.view.home.adapter.PackAdapterHome;
import com.example.daily1.view.suggestion.adapter.PackAdapterSuggestion;

import java.util.List;


public class HomeFragment extends ObserverFragment {

    //get instance from viewModel
    private HomeViewModel homeViewModel;

    private static final String TAG = "HomeFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel= new HomeViewModel(new PackRepository(new PackCloudDataSource(ApiServiceContainer.getApiService())),
                new MaterialRepository(new MaterialCloudDataSource(ApiServiceContainer.getApiService() )));
    }


    @Override
    public void subscribe() {
        homeViewModel.getPacks()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Pack>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<Pack> packs) {
                        Log.i(TAG, "onSuccess: ");
                        RecyclerView recyclerView2 = getView().findViewById(R.id.rv_main_our_pack);
                        recyclerView2.setLayoutManager(new LinearLayoutManager(
                                getContext(), RecyclerView.HORIZONTAL, false
                        ));
                        recyclerView2.setAdapter(new PackAdapterHome(packs, ImageLoadingSerrviceInjector.getImageLoadingService()));


                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e(TAG, "onError: "+e.toString() );
                    }
                });
        //---------
        homeViewModel.getMaterials()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Material>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Material> materials) {
                        Log.i(TAG, "onSuccess: ");
                        RecyclerView recyclerView = getView().findViewById(R.id.rv_coustom_pack);
                        recyclerView.setLayoutManager(new GridLayoutManager(
                                getContext(),1, RecyclerView.VERTICAL, false
                        ));
                        recyclerView.setAdapter(new MaterialAdapterHome(materials, ImageLoadingSerrviceInjector.getImageLoadingService()));


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.toString() );

                    }
                });

    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }
}
