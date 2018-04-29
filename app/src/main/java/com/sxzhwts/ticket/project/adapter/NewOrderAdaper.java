package com.sxzhwts.ticket.project.adapter;

import android.app.Activity;
import android.view.View;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.utils.TimesUtils;
import com.sxzhwts.ticket.project.adapter.base.BaseAdapter;
import com.sxzhwts.ticket.project.adapter.base.BaseViewHolder;
import com.sxzhwts.ticket.project.bean.response.HomeResulst;

import java.util.List;

/**
 * 作者：fcy on 2018/4/16 13:48
 */

public class NewOrderAdaper extends BaseAdapter<HomeResulst.DataEntity.ListEntity>{
    public NewOrderAdaper(Activity activity, List<HomeResulst.DataEntity.ListEntity> hotelResult) {
        super(activity, hotelResult);
    }
    @Override
    public int getResourcesId() {
        return R.layout.item_neworder;
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        HomeResulst.DataEntity.ListEntity result=(HomeResulst.DataEntity.ListEntity)mData.get(position);
        holder.setText(R.id.orderInfo,result.getName()+" "+result.getCount()+"张 "+ TimesUtils.parse2HM(Long.parseLong(result.getCreate_time())));
        if(mOnItemClickListener!=null){
            holder.findViewById(R.id.scenery).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.findViewById(R.id.scenery),position);
                }
            });
        }
    }
}
