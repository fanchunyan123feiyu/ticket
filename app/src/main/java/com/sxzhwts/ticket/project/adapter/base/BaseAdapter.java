package com.sxzhwts.ticket.project.adapter.base;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{
    public List<T> mData;
    public Activity activity;
    private LayoutInflater inflater;
    public OnItemClickListener mOnItemClickListener;
    public BaseAdapter(Activity activity, List<T> hotelResult) {
        this.activity=activity;
        this.mData=hotelResult;
        inflater=LayoutInflater.from(activity);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=inflater.inflate(getResourcesId(),parent,false);
            return new BaseViewHolder(view);

    }



    public abstract int getResourcesId();
    @Override
    public int getItemCount() {
        return mData==null?1:mData.size();
    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

}
