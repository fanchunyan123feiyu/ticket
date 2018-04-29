package com.sxzhwts.ticket.project.views;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.DialogUtils;
import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.adapter.OrderAdaper;
import com.sxzhwts.ticket.project.adapter.base.BaseAdapter;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.OrderListContract;
import com.sxzhwts.ticket.project.prenster.OrderListPrenster;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/18 17:01
 */

public class AllOrderActivity extends BaseMvpActivity<OrderListPrenster> implements OrderListContract.AllOrderView {

    @BindView(R.id.allOrderLine)
    View allOrderLine;
    @BindView(R.id.allOder)
    LinearLayout allOder;
    @BindView(R.id.readSureLine)
    View readSureLine;
    @BindView(R.id.readSure)
    LinearLayout readSure;
    @BindView(R.id.outTicketSucessLine)
    View outTicketSucessLine;
    @BindView(R.id.outTicketSucess)
    LinearLayout outTicketSucess;
    @BindView(R.id.outTicketFialLine)
    View outTicketFialLine;
    @BindView(R.id.outTicketFial)
    LinearLayout outTicketFial;
    @BindView(R.id.haveCheckLine)
    View haveCheckLine;
    @BindView(R.id.haveCheck)
    LinearLayout haveCheck;
    @BindView(R.id.tab)
    LinearLayout tab;
    @BindView(R.id.emptyView)
    TextView emptyView;
    @BindView(R.id.introduce)
    AppCompatTextView introduce;
    @BindView(R.id.noNet)
    RelativeLayout noNet;
    @BindView(R.id.orderRecylerView)
    RecyclerView orderRecylerView;
    private int state;
    private String resourceId;

    private List<OrderResult.DataEntityX.OrderlistEntity.DataEntity> datas ;
    private OrderAdaper orderAdaper=null;
    private AppCompatTextView stateView;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_allorder;
    }

    @Override
    protected void initViewAndEvent() {

        titleLayout.setVisibility(View.VISIBLE);
        titleText.setText("全部订单");
        titleBack.setOnClickListener(view -> {finishedActivity();});

        state = getIntent().getIntExtra("type", 0);
        resourceId = getIntent().getStringExtra("resourceId");
        initLine();
        getSmartRefreshLayout().setEnableLoadmore(true);
        getSmartRefreshLayout().setEnableRefresh(true);
        datas = new ArrayList<OrderResult.DataEntityX.OrderlistEntity.DataEntity>();
        orderRecylerView.setLayoutManager(new LinearLayoutManager(mContext));
    }
/*

    @Override
    protected void initData() {
        super.initData();
        loadData(false);
    }
*/

    @Override
    protected void onResume() {
        super.onResume();
        loadData(false);
    }

    @Override
    public void showNoNet() {
        super.showNoNet();
        if(!isLoadMore){
            noNet.setVisibility(View.VISIBLE);
            noNet.setOnClickListener(view -> {loadData(false);});
        }else{
            pageNumb--;
            getSmartRefreshLayout().finishLoadmore();
        }

    }

    @Override
    public void showError() {
        super.showError();
        if(isLoadMore){
            pageNumb--;
            getSmartRefreshLayout().finishLoadmore();
        }
    }

    private void initLine() {
        switch (state) {
            case 0:
                allOrderSelct();
                break;
            case 1:
                readSureSelect();
                break;
            case 2:
                outTicketSucessSelect();
                break;
            case 3:
                outTicketFialSelect();
                break;
            case 4:
                haveCheckSelect();
                break;
        }
    }

    private void haveCheckSelect() {
        haveCheckLine.setVisibility(View.VISIBLE);

        allOrderLine.setVisibility(View.INVISIBLE);
        readSureLine.setVisibility(View.INVISIBLE);
        outTicketSucessLine.setVisibility(View.INVISIBLE);
        outTicketFialLine.setVisibility(View.INVISIBLE);
    }

    private void outTicketFialSelect() {

        outTicketFialLine.setVisibility(View.VISIBLE);

        allOrderLine.setVisibility(View.INVISIBLE);
        readSureLine.setVisibility(View.INVISIBLE);
        outTicketSucessLine.setVisibility(View.INVISIBLE);
        haveCheckLine.setVisibility(View.INVISIBLE);
    }

    private void outTicketSucessSelect() {
        outTicketSucessLine.setVisibility(View.VISIBLE);

        allOrderLine.setVisibility(View.INVISIBLE);
        readSureLine.setVisibility(View.INVISIBLE);
        outTicketFialLine.setVisibility(View.INVISIBLE);
        haveCheckLine.setVisibility(View.INVISIBLE);

    }

    private void readSureSelect() {
        readSureLine.setVisibility(View.VISIBLE);

        allOrderLine.setVisibility(View.INVISIBLE);
        outTicketSucessLine.setVisibility(View.INVISIBLE);
        outTicketFialLine.setVisibility(View.INVISIBLE);
        haveCheckLine.setVisibility(View.INVISIBLE);
    }

    private void allOrderSelct() {
        allOrderLine.setVisibility(View.VISIBLE);

        readSureLine.setVisibility(View.INVISIBLE);
        outTicketSucessLine.setVisibility(View.INVISIBLE);
        outTicketFialLine.setVisibility(View.INVISIBLE);
        haveCheckLine.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getOrderListSucess(OrderResult orderResult) {
         hideLoading();
        introduce.setText("订单数：" + orderResult.getData().getOrdercount() + "张 " + "￥" + SystemUtil.formatString(orderResult.getData().getOrderamount()) + "元");
        Log.e("TAG",orderResult.getData().getOrderlist().getData()+"---------");
        if(orderResult.getData().getOrderlist().getData().size()==0){
            Log.e("TAG","为空");
            showEmpty();
        }else{
            if(emptyView.getVisibility()==View.VISIBLE){
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
                   if("核销".equals(str)){
                       DialogUtils.showAlertDialog(mContext, "确认核销吗？", new DialogUtils.AletOnClickListener() {
                           @Override
                           public void sureOnClickListener() {
                               mPrenster.verication(Constant.userToken,datas.get(position).getId());
                           }
                       });
                   }else if("确认".equals(str)){
                       Log.e("TAG","确认"+str);
                       DialogUtils.showAlertDialog(mContext, "确认出票吗？", new DialogUtils.AletOnClickListener() {
                           @Override
                           public void sureOnClickListener() {
                               mPrenster.orderfirmyes(Constant.userToken,datas.get(position).getId());
                           }
                       });

                   }
                }
            });
            orderRecylerView.setAdapter(orderAdaper);
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
    public void verication(Result result) {//核销
        if(result.code==1){
            stateView.setVisibility(View.GONE);
        }
    }

    @Override
    public void sure(Result result) {//确认
        Log.e("TAG","确认成功");
        if(result.code==1){
            stateView.setText("核销");
        }
    }

    @Override
    public void showEmpty() {
        super.showEmpty();
        Log.e("TAG","显示空数据");
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void loadData(boolean isLoadMore) {
        super.loadData(isLoadMore);
        showLoading();
        if(!isLoadMore){
            datas.clear();
        }
        mPrenster.getOrderList(Constant.userToken, resourceId, state + "", pageNumb + "");
    }

    @OnClick({R.id.allOder, R.id.readSure, R.id.outTicketSucess, R.id.outTicketFial, R.id.haveCheck})
    public void onViewClicked(View view) {
        datas.clear();
        switch (view.getId()) {
            case R.id.allOder:
                allOrderSelct();
                state=0;
                loadData(false);
                break;
            case R.id.readSure:
                readSureSelect();
                state=1;
                loadData(false);
                break;
            case R.id.outTicketSucess:
                outTicketSucessSelect();
                state=2;
                loadData(false);
                break;
            case R.id.outTicketFial:
                outTicketFialSelect();
                state=8;
                loadData(false);
                break;
            case R.id.haveCheck:
                haveCheckSelect();
                state=5;
                loadData(false);
                break;
        }
    }


}
