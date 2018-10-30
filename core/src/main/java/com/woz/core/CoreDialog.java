package com.woz.core;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by pdypham on 4/4/18.
 */

public abstract class CoreDialog extends Dialog {

    public CoreDialog(@NonNull Context context) {
        super(context);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(resContentView());

        if(getWindow() != null) {
            getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        }

        setCancelable(cancelable());
        setCanceledOnTouchOutside(cancelTouchOutside());

        initView();
    }

    protected abstract void initView();
    protected abstract int resContentView();

    protected boolean cancelTouchOutside(){
        return false;
    }

    protected boolean cancelable(){
        return true;
    }

}
