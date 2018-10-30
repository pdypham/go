package com.woz.wozpi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SlidePageAdapter extends FragmentStatePagerAdapter {

    public List<SlidePageFragment> slidePageFragmentList;

    private final static int MAX_ITEM = 3;
    private FragmentManager mFragmentManager;

    public SlidePageAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
//        this.slidePageFragmentList = slidePageFragmentList;

    }

    @Override
    public Fragment getItem(int i) {
       return slidePageFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return slidePageFragmentList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        SlidePageFragment sl = (SlidePageFragment) object;
        Log.e("WOW","destroy item");
//        mFragmentManager.beginTransaction().remove(sl).commit();
    }
}
