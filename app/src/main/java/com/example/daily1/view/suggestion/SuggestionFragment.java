package com.example.daily1.view.suggestion;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daily1.R;
import com.example.daily1.base.ObserverFragment;
import com.example.daily1.components.image.ImageLoadingSerrviceInjector;
import com.example.daily1.http.ApiServiceContainer;
import com.example.daily1.model.data.Pack;
import com.example.daily1.model.repo.PackCloudDataSource;
import com.example.daily1.model.repo.PackRepository;
import com.example.daily1.view.suggestion.adapter.PackAdapterSuggestion;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class SuggestionFragment extends ObserverFragment {

    private SuggestionViewModel suggestionViewModel;
    private static final String TAG = "SuggestionFragment";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        suggestionViewModel=new SuggestionViewModel(new PackRepository(new PackCloudDataSource(ApiServiceContainer.getApiService())));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_suggestion;
    }




    @Override
    public void subscribe() {
        suggestionViewModel.getPacks()
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

                        RecyclerView recyclerView=getView().findViewById(R.id.rv_pack_suggestion);
                        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
                        recyclerView.setAdapter(new PackAdapterSuggestion(packs, ImageLoadingSerrviceInjector.getImageLoadingService()));
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e(TAG, "onError: "+e.toString() );
                    }
                });
    }
}
