package com.woz.wozpi;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.woz.core.WozFragment;

public class SlidePageFragment extends WozFragment {

    private static String linkImg;

    public static SlidePageFragment getInstance(String link){
        linkImg = link;
        return new SlidePageFragment();
    }

    @Override
    public int setLayoutView() {
        return R.layout.fragment_slide_page;
    }

    @Override
    public void initView(View viewRoot) {
        ImageView imgSlide = viewRoot.findViewById(R.id.imgSlide);
        Log.e("WOW",linkImg);
        Picasso.get().load(linkImg).into(imgSlide);
    }

    @Override
    public void loadData() {

    }
}
