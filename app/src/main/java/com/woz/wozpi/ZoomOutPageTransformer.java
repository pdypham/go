package com.woz.wozpi;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class ZoomOutPageTransformer implements ViewPager.PageTransformer{

    @Override
    public void transformPage(@NonNull View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        //     [-Infinity,-1]
        if(position < -1){
            view.setAlpha(0);
        }else {
//            [-1,0]
            if(position <= 0){
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);
            }else
//                (0,1]
                if(position <= 1){
                    view.setAlpha(1 - position);
                    view.setTranslationX(pageWidth * -position);

                    float scaleFactor = 0.75f + 0.25f * (1 - Math.abs(position));
                    view.setScaleX(scaleFactor);
                    view.setScaleY(scaleFactor);
                }else{
                    view.setAlpha(0);
                }
        }

//        Log.e("WOW",position+"");


    }
}
