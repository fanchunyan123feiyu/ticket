package com.sxzhwts.ticket.project.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.project.bean.response.SceneryResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2017-6-15.
 */

public class SceneryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SceneryResult.DataEntity> datas = new ArrayList<>();
    private Context context;
    private OnItemClickListener mOnItemClickListener,onItemClickListenerSure;
    private final int TYPE_ITEM = 0;
    private final int TYPE_SURE = 1;
    private int selectedPosition = -1; //默认一个参数
    public SceneryAdapter(List<SceneryResult.DataEntity> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener,OnItemClickListener onItemClickListenerSure) {
        this.mOnItemClickListener = mOnItemClickListener;
        this.onItemClickListenerSure=onItemClickListenerSure;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPE_SURE:
                view = LayoutInflater.from(context).inflate(R.layout.item_sure, parent, false);
                RecyclerView.ViewHolder moreViewHolder = new SureViewHolder(view);
                return moreViewHolder;
            case TYPE_ITEM:
                view = LayoutInflater.from(context).inflate(R.layout.item_scenery, parent, false);
                RecyclerView.ViewHolder oneViewHolder = new OneViewHolder(view);
                return oneViewHolder;
        }
        return holder;

    }

    @Override
    public int getItemViewType(int position) {
       if(position==datas.size()-1){
           return  TYPE_SURE;
       }else{
           return  TYPE_ITEM;
       }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        SceneryResult.DataEntity result = datas.get(position);
        if(holder instanceof OneViewHolder){
            OneViewHolder oneViewHolder=(OneViewHolder)holder;
            oneViewHolder.sceneryName.setText(result.getName());
           if(selectedPosition==position){
               oneViewHolder.isSelect.setVisibility(View.VISIBLE);
               oneViewHolder.itemView.setBackgroundColor(context.getResources().getColor(R.color.background));
           }else{
               oneViewHolder.isSelect.setVisibility(View.GONE);
           }
            //判断是否设置了监听器
            if (mOnItemClickListener != null) {
               holder.itemView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       mOnItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                       selectedPosition=position;
                       notifyDataSetChanged();
                   }
               });
            }
        }else  if(holder instanceof SureViewHolder){
           ((SureViewHolder) holder).sure.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   onItemClickListenerSure.onItemClick(holder.itemView,holder.getLayoutPosition());
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return datas==null?0:datas.size();
    }

    class SureViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sure)
        AppCompatTextView sure;

        public SureViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sceneryName)
        AppCompatTextView sceneryName;
        @BindView(R.id.isSelect)
        AppCompatImageView isSelect;

        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
