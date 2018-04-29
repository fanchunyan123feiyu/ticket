package com.sxzhwts.ticket.project.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.utils.TimesUtils;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.adapter.base.BaseAdapter;
import com.sxzhwts.ticket.project.adapter.base.BaseViewHolder;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.ui.PayMethodUtil;

import java.util.List;

/**
 * 作者：fcy on 2018/4/16 13:48
 */

public class OrderAdaper extends BaseAdapter<OrderResult.DataEntityX.OrderlistEntity.DataEntity> {
    private OnItemClickListener hexiaoOnItemClickListener;

    public void setOnItemClickListeners(OnItemClickListener mOnItemClickListener, OnItemClickListener hexiaoOnItemClickListener) {
        setOnItemClickListener(mOnItemClickListener);
        this.hexiaoOnItemClickListener = hexiaoOnItemClickListener;
    }

    public OrderAdaper(Activity activity, List<OrderResult.DataEntityX.OrderlistEntity.DataEntity> hotelResult) {
        super(activity, hotelResult);
    }

    @Override
    public int getResourcesId() {
        return R.layout.item_order;
    }

    public void onBindViewHolder(BaseViewHolder holder, int position) {
        OrderResult.DataEntityX.OrderlistEntity.DataEntity result = (OrderResult.DataEntityX.OrderlistEntity.DataEntity) mData.get(position);
        holder.setText(R.id.orderId, "订单号：" + result.getOrder_code());
        holder.setText(R.id.orderTime, "下单时间：" + TimesUtils.parse2YHM(Long.parseLong(result.getCreate_time())));
      /*  if(!TextUtils.isEmpty(result.getPay_method())){
            switch (result.getPay_method()){
                case "1":
                    holder.setText(R.id.orderPayStyle, "支付方式：" +"微信支付" );
                    break;
                case "2":
                    holder.setText(R.id.orderPayStyle, "支付方式：" +"支付宝支付" );
                    break;
                case "3":
                    holder.setText(R.id.orderPayStyle, "支付方式：" +"余额支付" );
                    break;
                default:
                    holder.setText(R.id.orderPayStyle, "支付方式：未支付"  );


            }

        }*/
        holder.setText(R.id.orderPayStyle, PayMethodUtil.getMethod(result.getPay_method()));
        holder.setText(R.id.orderName, "名称：" + result.getName());
        holder.setText(R.id.orderIntro, "备注：" + result.getRemark());
        holder.setText(R.id.tickePeople, Html.fromHtml(result.getGeter_name() + "（取票人）<font color=\"#528ff6\">" + result.getGeter_tel() + "</font>"));
        holder.setText(R.id.iIDcard, "身份证：" + result.getGeter_card_id());
        holder.findViewById(R.id.callphone).setOnClickListener(view -> {
            if (!TextUtils.isEmpty(result.getGeter_tel())) {
                Intent intent2 = new Intent(Intent.ACTION_DIAL);//弹出拨号面板
                Uri datas = Uri.parse("tel:" + result.getGeter_tel());
                intent2.setData(datas);
                activity.startActivity(intent2);
            } else {
                ToastUtils.showToast(activity, "电话号码有误");
            }
        });
        holder.setText(R.id.money, Html.fromHtml("共计：" + result.getCount() + "张（<font color=\"#f03a1e\">￥" + result.getAmount() + "</font>）"));
        holder.setOnClickListener(R.id.desp, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(holder.findViewById(R.id.desp), position);
            }
        });
        holder.setOnClickListener(R.id.state, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hexiaoOnItemClickListener.onItemClick(holder.findViewById(R.id.state), position);
            }
        });

        switch (result.getState()) {
            case "0"://未支付
                holder.setText(R.id.stateShow, "未支付");
                holder.findViewById(R.id.state).setVisibility(View.GONE);
                break;
            case "1"://待确认
                holder.setText(R.id.stateShow, "待确认");
                holder.findViewById(R.id.state).setVisibility(View.VISIBLE);
                holder.setText(R.id.state, "确认");
                holder.findViewById(R.id.state).setBackground(activity.getResources().getDrawable(R.drawable.shape_sure));
                break;
            case "2"://待核销
                holder.setText(R.id.stateShow, "待核销");
                holder.findViewById(R.id.state).setVisibility(View.VISIBLE);
               /* if ("1".equals(result.getPay_state()) && "1".equals(result.getPay_method())) {//待核销
                    holder.setText(R.id.state, "核销");
                    holder.findViewById(R.id.state).setBackground(activity.getResources().getDrawable(R.drawable.shape_sure));
                } else if ("0".equals(result.getPay_state()) && "2".equals(result.getPay_method())) {//到点支付
                    holder.setText(R.id.state, "核销");
                    holder.findViewById(R.id.state).setBackground(activity.getResources().getDrawable(R.drawable.shape_sure));
                }*/
                holder.setText(R.id.state, "核销");
                holder.findViewById(R.id.state).setBackground(activity.getResources().getDrawable(R.drawable.shape_sure));
                break;
            case "3"://退票中
                holder.setText(R.id.stateShow, "退票中");
                holder.findViewById(R.id.state).setVisibility(View.VISIBLE);
                break;
            case "4"://退票完成
                holder.setText(R.id.stateShow, "退票完成");
                break;
            case "5"://已使用
                holder.setText(R.id.stateShow, "已使用");
                holder.findViewById(R.id.state).setVisibility(View.GONE);
                break;
            case "8"://已关闭
                holder.setText(R.id.stateShow, "已关闭");
                holder.findViewById(R.id.state).setBackground(activity.getResources().getDrawable(R.drawable.shape_grey));
                holder.findViewById(R.id.state).setVisibility(View.VISIBLE);
                holder.setText(R.id.state, "出票失败");
                break;
            case "9"://已取消
                holder.setText(R.id.stateShow, "已取消");
                break;

        }
    }
}
