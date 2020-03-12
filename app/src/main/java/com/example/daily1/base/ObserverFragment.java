package com.example.daily1.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * for fragment use of RxJava and subscribe event such as data from server
 */
public abstract class ObserverFragment extends BaseFragment{

    //all of subscriptions get in compositeDisposable
    //protected because of show all of child
    protected CompositeDisposable compositeDisposable= new CompositeDisposable();

    //in start of fragment subscribe
    @Override
    public void onStart() {
        super.onStart();
        subscribe();
    }

    //in stop of fragment unSubscribe
    @Override
    public void onStop() {
        super.onStop();
        unSubscribe();
    }

    //subscribe is specific every fragment because every fragment known subscribe on which
    //every time view create data subscribe
    public abstract void subscribe();

    //clear compositeDisposable because every time view gone clear data
    public void unSubscribe(){
        compositeDisposable.clear();
    }
}
