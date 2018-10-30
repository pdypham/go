package com.woz.wozpi;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class WozSlide extends ViewPager implements ViewPager.OnPageChangeListener {
    private List<SlidePageFragment> slidePageFragmentList;


    private CountDownTimer mCountDownTimer;
    private int positionSlide = 1;

    public WozSlide(@NonNull Context context) {
        super(context);
        init();
    }

    public WozSlide(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init(){
        setPageTransformer(true,new ZoomOutPageTransformer());
        addOnPageChangeListener(this);

    }

    @Override
    public void setAdapter(@Nullable PagerAdapter adapter) {
        super.setAdapter(adapter);
        loop();

        slidePageFragmentList = new ArrayList<>();
        slidePageFragmentList.add(SlidePageFragment.getInstance("https://i.imgur.com/hETOr6Y.jpg"));
        slidePageFragmentList.add(SlidePageFragment.getInstance("http://trainghiemso.vn/wp-content/uploads/2016/06/disney-pixar.jpg"));
        slidePageFragmentList.add(SlidePageFragment.getInstance("http://cafefcdn.com/thumb_w/650/2016/steve-jobs-31-1476758906971.jpg"));

        SlidePageAdapter holder = (SlidePageAdapter) adapter;
        holder.slidePageFragmentList = slidePageFragmentList;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mCountDownTimer.cancel();
                break;
            case MotionEvent.ACTION_UP:
                if(mCountDownTimer != null){
                    mCountDownTimer.start();
                }
                break;
        }
        performClick();
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }


    private void loop(){
        if(mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(1000, 2000) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    setCurrentItem(positionSlide, true);
                    positionSlide++;
                    loop();
                }
            }.start();
        }else {
            mCountDownTimer.start();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        if(position >= slidePageFragmentList.size() - 2){
            slidePageFragmentList.add(SlidePageFragment.getInstance("https://i.imgur.com/hETOr6Y.jpg"));
            getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
