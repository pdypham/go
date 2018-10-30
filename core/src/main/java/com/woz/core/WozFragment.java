package com.woz.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class WozFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(setLayoutView(),container,false);
        initView(viewRoot);
        loadData();

        return viewRoot;
    }


    public abstract int setLayoutView();
    public abstract void initView(View viewRoot);

    public abstract void loadData();

}
