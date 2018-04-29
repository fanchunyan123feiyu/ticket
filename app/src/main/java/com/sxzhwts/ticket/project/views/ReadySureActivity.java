package com.sxzhwts.ticket.project.views;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.DialogUtils;
import com.sxzhwts.ticket.project.adapter.OrderAdaper;
import com.sxzhwts.ticket.project.adapter.base.BaseAdapter;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.OrderListContract;
import com.sxzhwts.ticket.project.prenster.OrderListPrenster;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：fcy on 2018/4/21 13:45
 */

public class ReadySureActivity extends BaseMvpActivity<OrderListPrenster> implements OrderListContract.SureOrderView {
    @BindView(R.id.readSureRecylerView)
    RecyclerView readSureRecylerView;
    @BindView(R.id.emptyView)
    TextView emptyView;
    private List<OrderResult.DataEntityX.OrderlistEntity.DataEntity> datas ;
    private OrderAdaper orderAdaper;
    private AppCompatTextView stateView;
    @Override
    public void getOrderListSucess(OrderResult orderResult) {
        if (orderResult.getData().getOrderlist().getData().size() == 0) {
            if(!isLoadMore) {
                showEmpty();
            }
        } else {
            if (emptyView.getVisibility() == View.VISIBLE) {
                emptyView.setVisibility(View.GONE);
            }
        }

        datas.addAll(orderResult.getData().getOrderlist().getData());
        if(orderAdaper==null){
            orderAdaper= new OrderAdaper(mContext, datas);
            orderAdaper.setOnItemClickListeners(new BaseAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {//详情
                    Intent intent= new Intent(mContext,OrderDetailActivity.class);
                    intent.putExtra("orderid",datas.get(position).getId());
                    startActivity(intent);
                }
            }, new BaseAdapter.OnItemClickListener() {//核销
                @Override
                public void onItemClick(View view, int position) {
                    stateView= (AppCompatTextView)view;
                    String str= stateView.getText().toString().trim();
                    Log.e("TAG","点击了核销按钮"+str);
                    DialogUtils.showAlertDialog(mContext, "确认出票吗？", new DialogUtils.AletOnClickListener() {
                        @Override
                        public void sureOnClickListener() {
                            mPrenster.orderfirmyes(Constant.userToken,datas.get(position).getId());
                        }
                    });
                   /* if("核销".equals(str)){
                        mPrenster.verication(Constant.userToken,datas.get(position).getId());
                    }else if("确认".equals(str)){
                        Log.e("TAG","确认"+str);
                        mPrenster.orderfirmyes(Constant.userToken,datas.get(position).getId());
                    }*/
                }
            });
            readSureRecylerView.setAdapter(orderAdaper);
        }else{
            orderAdaper.notifyDataSetChanged();
        }
        if(isLoadMore){
            getSmartRefreshLayout().finishLoadmore();
        }else{
            getSmartRefreshLayout().finishRefresh();
        }
    }

    @Override
    public void showEmpty() {
        super.showEmpty();
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void sure(Result result) {
        datas.clear();
        loadData(false);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_readysure;
    }

    @Override
    protected void initViewAndEvent() {
        titleText.setText("待确认");

        datas = new ArrayList<OrderResult.DataEntityX.OrderlistEntity.DataEntity>();
        loadData(false);
        getSmartRefreshLayout().setEnableRefresh(true);
        getSmartRefreshLayout().setEnableLoadmore(true);
        readSureRecylerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected void loadData(boolean isLoadMore) {
        super.loadData(isLoadMore);
        if(!isLoadMore){
            datas.clear();
        }
        mPrenster.getOrderList(Constant.userToken, Constant.resourceId, "1", pageNumb + "");
    }

}
