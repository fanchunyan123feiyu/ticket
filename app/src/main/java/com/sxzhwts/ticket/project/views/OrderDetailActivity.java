package com.sxzhwts.ticket.project.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.DialogUtils;
import com.sxzhwts.ticket.common.utils.TimesUtils;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.bean.response.BusOrderDetailResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.OrderDetailContract;
import com.sxzhwts.ticket.project.event.SubmitEvent;
import com.sxzhwts.ticket.project.prenster.OrderDetailPrenster;
import com.sxzhwts.ticket.project.ui.PayMethodUtil;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/18 14:44
 */

public class OrderDetailActivity extends BaseMvpActivity<OrderDetailPrenster> implements OrderDetailContract.View {

    @BindView(R.id.busName)
    AppCompatTextView busName;
    @BindView(R.id.busType)
    AppCompatTextView busType;
    @BindView(R.id.busPrice)
    AppCompatTextView busPrice;
    @BindView(R.id.busDate)
    AppCompatTextView busDate;
    @BindView(R.id.busTime)
    AppCompatTextView busTime;
    @BindView(R.id.busView)
    LinearLayout busView;
    @BindView(R.id.tickePeople)
    AppCompatTextView tickePeople;
    @BindView(R.id.callphone)
    ImageView callphone;
    @BindView(R.id.iIDcard)
    AppCompatTextView iIDcard;
    @BindView(R.id.money)
    AppCompatTextView money;
    @BindView(R.id.state)
    AppCompatTextView state;
    @BindView(R.id.orderId)
    AppCompatTextView orderId;
    @BindView(R.id.stateShow)
    AppCompatTextView stateShow;
    @BindView(R.id.orderTime)
    AppCompatTextView orderTime;
    @BindView(R.id.orderPayStyle)
    AppCompatTextView orderPayStyle;
    @BindView(R.id.ticketDes)
    AppCompatTextView ticketDes;
    @BindView(R.id.sceneyTime)
    AppCompatTextView sceneyTime;
    @BindView(R.id.sceneyRemark)
    AppCompatTextView sceneyRemark;
    /* @BindView(R.id.sceneyName)
     AppCompatTextView sceneyName;*/
    @BindView(R.id.ticketType)
    LinearLayout ticketType;
    @BindView(R.id.fial)
    AppCompatTextView fial;
    @BindView(R.id.ticketName)
    AppCompatTextView ticketName;
    @BindView(R.id.normalView)
    LinearLayout normalView;
    @BindView(R.id.passengerll)
    LinearLayout passengerll;
    @BindView(R.id.passengerView)
    View passengerView;
    private String orderid, ordercode;
    private String strChaoTai = "";

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_orderdetail;
    }

    @Override
    protected void initViewAndEvent() {
        titleText.setText("订单详情");
        orderid = getIntent().getStringExtra("orderid");
        ordercode = getIntent().getStringExtra("ordercode");
        Log.e("TAG","接收到的核销码"+ordercode);
        Log.e("TAG","接收到的订单id"+orderid);
        loadData();
    }

    private void loadData() {
        if (!TextUtils.isEmpty(ordercode)) {
            mPrenster.getOrderDetailByOrderCode(Constant.userToken, ordercode);
        }
        if (!TextUtils.isEmpty(orderid)) {
            mPrenster.getOrderDetailById(Constant.userToken, orderid);
        }
    }

    @Override
    public void showError() {
        super.showError();
        loadData();
    }

    @Override
    public void getBusOrderDetailSucess(BusOrderDetailResult busOrderDetailResult) {
        orderId.setText("订单号：" + busOrderDetailResult.getData().getOrder_code());
        orderTime.setText("下单时间：" + TimesUtils.parse2YHM(Long.parseLong(busOrderDetailResult.getData().getCreate_time())));
        orderPayStyle.setText( PayMethodUtil.getMethod(busOrderDetailResult.getData().getPay_method()));

        if (busOrderDetailResult.getData().getShifts() != null) {//大巴详情
            busName.setText(busOrderDetailResult.getData().getStart_place().getName()+"-"+busOrderDetailResult.getData().getEnd_place().getName());
            busType.setText("车型：旅游大巴车");
            busPrice.setText("票价：1张 ￥" + busOrderDetailResult.getData().getShifts().getPrice());
            busDate.setText("出发日期：" + busOrderDetailResult.getData().getDate());
            busTime.setText("车次：" + busOrderDetailResult.getData().getShifts().getTime());

            passengerll.removeAllViews();
            passengerView.setVisibility(View.VISIBLE);
            for(BusOrderDetailResult.DataEntity.DetailEntity detailEntity:busOrderDetailResult.getData().getDetail()){
               View view= LayoutInflater.from(mContext).inflate(R.layout.layout_bottom,null);
                AppCompatTextView passengerName=view.findViewById(R.id.tickePeople);
                ImageView callphone=view.findViewById(R.id.callphone);
                AppCompatTextView passengerId=view.findViewById(R.id.iIDcard);
                passengerName.setText(detailEntity.getTruename()+"(乘客)");
                callphone.setOnClickListener(view1 -> {
                    callPhone(detailEntity.getTelphone());
                });
                passengerId.setText("身份证："+detailEntity.getIdcard());
                passengerll.addView(view);
            }
            normalView.setVisibility(View.GONE);
        } else {
            busView.setVisibility(View.GONE);
        }
        tickePeople.setText(busOrderDetailResult.getData().getGeter_name() + "(取票人)" + busOrderDetailResult.getData().getGeter_tel());//todo
        iIDcard.setText("身份证：" + busOrderDetailResult.getData().getGeter_card_id());
        money.setText(Html.fromHtml("共计：" + busOrderDetailResult.getData().getSumcount() + "张（<font color=\"#f03a1e\">￥" + busOrderDetailResult.getData().getAmount() + "</font>）"));
        callphone.setOnClickListener(view -> {
            if (!TextUtils.isEmpty(busOrderDetailResult.getData().getGeter_tel())) {
                callPhone(busOrderDetailResult.getData().getGeter_tel());
            } else {
                ToastUtils.showToast(mContext, "电话号码有误");
            }
        });
        if (busOrderDetailResult.getData().getDetail().size() != 0) {
            for (BusOrderDetailResult.DataEntity.DetailEntity detailEntity1 : busOrderDetailResult.getData().getDetail()) {
                if (TextUtils.isEmpty(strChaoTai)) {
                    strChaoTai += detailEntity1.getTicketname() + detailEntity1.getCount() + "张 ￥" + detailEntity1.getPrice();
                } else {
                    strChaoTai += "\n\n" + detailEntity1.getTicketname() + detailEntity1.getCount() + "张 ￥" + detailEntity1.getPrice();
                }
            }
            ticketDes.setText(strChaoTai);
        } else {
            ticketType.setVisibility(View.GONE);
        }
        if (busOrderDetailResult.getData().getScenic() != null) {
            ticketName.setText("名称：" + busOrderDetailResult.getData().getScenic().getName());
        }

        sceneyTime.setText("游玩时间：" + busOrderDetailResult.getData().getDate());
        sceneyRemark.setText("备注：" + busOrderDetailResult.getData().getRemark());
        Log.e("TAG","状态"+busOrderDetailResult.getData().getState());
        switch (busOrderDetailResult.getData().getState()) {
            case "0"://未支付
                stateShow.setText("未支付");
                break;
            case "1"://待确认
                stateShow.setText("待确认");
                state.setText("确认出票");
                state.setVisibility(View.VISIBLE);
                state.setBackground(mContext.getResources().getDrawable(R.drawable.shape_sure));

                state.setOnClickListener(view -> {
                    DialogUtils.showAlertDialog(mContext, "确认出票吗？", new DialogUtils.AletOnClickListener() {
                        @Override
                        public void sureOnClickListener() {
                            mPrenster.sureOutTicket(Constant.userToken, orderid);
                        }
                    });
                });
                fial.setVisibility(View.VISIBLE);
                break;
            case "2"://待核销
                stateShow.setText("待核销");
                state.setText("核销");
                state.setVisibility(View.VISIBLE);
                state.setBackground(mContext.getResources().getDrawable(R.drawable.shape_sure));

                state.setOnClickListener(view -> {
                    DialogUtils.showAlertDialog(mContext, "确认核销吗？", new DialogUtils.AletOnClickListener() {
                        @Override
                        public void sureOnClickListener() {
                            mPrenster.verication(Constant.userToken, orderid);
                        }
                    });
                });
                break;
            case "3"://退票中
                stateShow.setText("退票中");
                break;
            case "4"://退票完成
                stateShow.setText("退票完成");
                break;
            case "5"://已使用
                stateShow.setText("已使用");
                fial.setVisibility(View.GONE);
                break;
            case "8"://已关闭
                stateShow.setText("已关闭");
                viewGone();
                break;
            case "9"://已取消
                stateShow.setText("已取消");
                break;
        }

    }

    private void viewGone() {
        fial.setVisibility(View.GONE);
        state.setVisibility(View.GONE);
    }

    private void callPhone(String phone) {
        Intent intent2 = new Intent(Intent.ACTION_DIAL);//弹出拨号面板
        Uri datas = Uri.parse("tel:" + phone);
        intent2.setData(datas);
        startActivity(intent2);
    }

    @Override
    public void verication(Result result) {
        if (result.code == 1) {
            state.setVisibility(View.GONE);
            stateShow.setText("已使用");
        }
    }

    @Override
    public void sureTicket(Result result) {
        if (result.code == 1) {
            Log.e("TAG","确认成功");
            loadData();

            ToastUtils.showToast(mContext, "确认成功");

        } else {
            ToastUtils.showToast(mContext, "确认失败");
        }
    }

    @Subscribe
    public void refreshData(SubmitEvent submitEvent) {
        if (submitEvent.result == 1) {
            Log.e("TAG","失败原因提交成功  刷新数据");
            loadData();
        }
    }

    @Override
    protected boolean registerEventBus() {
        return true;
    }

    @OnClick({R.id.fial, R.id.state})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fial:
                Intent intent = new Intent(mContext, FialResonSubmitActivity.class);
                intent.putExtra("orderId", orderid);
                startActivity(intent);
                break;
            case R.id.state:

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
