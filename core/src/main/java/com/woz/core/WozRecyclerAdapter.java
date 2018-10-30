package com.woz.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by woz on 3/25/18.
 */

public abstract class WozRecyclerAdapter<T> extends RecyclerView.Adapter<WozRecyclerHolder>{

    protected List<T> mDataList;
    private Context mContext;

    public WozRecyclerAdapter(Context context) {
        this.mContext = context;
        mDataList = new ArrayList<>();
    }



    public void addListItem(List<T> itemList){
        mDataList.addAll(itemList);
        this.notifyDataSetChanged();
    }

    public void addItem(T item){
        mDataList.add(item);
        this.notifyDataSetChanged();
    }

    public void resetData(){
        mDataList = new ArrayList<>();
    }


    public void clearAll(){
        if(mDataList != null) {
            mDataList.clear();
            this.notifyDataSetChanged();
        }
    }

    public void setDataList(List<T> itemList){
        List<T> clone = new ArrayList<>(itemList);
        if(mDataList != null) {
            mDataList.clear();
        }else {
            mDataList = new ArrayList<>();
        }
        mDataList.addAll(clone);
        this.notifyDataSetChanged();

    }

    protected Context getContext(){
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
