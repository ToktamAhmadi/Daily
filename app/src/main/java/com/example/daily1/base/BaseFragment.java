package com.example.daily1.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**

 * sth repeat in all of fragment write in this fragment one time
 *every fragment extend this fragment
 */
public abstract class BaseFragment extends Fragment {

    //abstract method for get layout instead of every fragment use of onCreateView
    @LayoutRes //show warning layout false
    public abstract int getLayoutRes();

    //method for set layout
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutRes(),container,false);
    }
}
