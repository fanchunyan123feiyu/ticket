package com.sxzhwts.ticket.project.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpFragment;
import com.sxzhwts.ticket.common.utils.DialogUtils;
import com.sxzhwts.ticket.common.utils.EventUtil;
import com.sxzhwts.ticket.common.utils.SharedPresUtils;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.adapter.NewOrderAdaper;
import com.sxzhwts.ticket.project.adapter.base.BaseAdapter;
import com.sxzhwts.ticket.project.bean.response.HomeResulst;
import com.sxzhwts.ticket.project.contract.HomeContract;
import com.sxzhwts.ticket.project.event.CodeEvent;
import com.sxzhwts.ticket.project.prenster.HomePrenster;
import com.sxzhwts.ticket.project.ui.IconTextView;
import com.sxzhwts.ticket.project.ui.MyTextWatcher;
import com.trello.rxlifecycle2.LifecycleTransformer;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;

/**
 * 作者：fcy on 2018/4/16 16:14
 */

public class HomeFragment2 extends BaseMvpFragment<HomePrenster> implements HomeContract.View {

    Unbinder unbinder;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_left)
    IconTextView title_left;
    @BindView(R.id.hexiaoCode)
    AppCompatEditText hexiaoCode;
    @BindView(R.id.setting)
    LinearLayout setting;
    @BindView(R.id.changePwd)
    LinearLayout changePwd;
    @BindView(R.id.allOrderSum)
    AppCompatTextView allOrderSum;
    @BindView(R.id.allOrder)
    LinearLayout allOrder;
    @BindView(R.id.drwerLayout)
    DrawerLayout drwerLayout;
    @BindView(R.id.scanBtn)
    AppCompatImageView scanBtn;
    @BindView(R.id.allOrderSum2)
    AppCompatTextView allOrderSum2;
    @BindView(R.id.readSureSum)
    AppCompatTextView readSureSum;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.newOrder)
    RecyclerView newOrder;
    @BindView(R.id.loginOut)
    AppCompatTextView loginOut;


    @OnClick({R.id.title_left, R.id.setting, R.id.changePwd, R.id.allOrder, R.id.scanBtn, R.id.loginOut, R.id.allOrderll, R.id.readSurell, R.id.sureCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_left:
                Log.e("TAG", "打开侧滑");
                drwerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.setting:
                startActivity(new Intent(getActivity(), SelectSceneryActivity.class));
                drwerLayout.closeDrawers();
                break;
            case R.id.changePwd:
                startActivity(new Intent(getActivity(), ChangePwdActivity.class));
                drwerLayout.closeDrawers();
                break;
            case R.id.allOrder:
                allOrder();
                drwerLayout.closeDrawers();
                break;
            case R.id.scanBtn:
                startActivity(new Intent(getActivity(), ScanCodeActivity.class));
                break;
            case R.id.loginOut:
                new AlertDialog.Builder(getActivity()).setTitle("退出").setMessage("确定要退出登录吗？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        JPushInterface.stopPush(getActivity().getApplicationContext());
                        Constant.userToken = null;
                        SharedPresUtils.getSharedPresUtils(getActivity()).saveUserInfo("", "");
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                        drwerLayout.closeDrawers();
                        ((MainActivity) getActivity()).finishedActivity();
                    }
                }).show();
                break;
            case R.id.allOrderll:
                allOrder();
                break;
            case R.id.readSurell:
                startActivity(new Intent(mContext, ReadySureActivity.class));
                break;
            case R.id.sureCode:
                if (hexiaoCode.getText().toString().trim().length() != 16) {
                    ToastUtils.showToast(mContext, "核销码输入有误，请重新输入！！！");
                } else {
                    Log.e("TAG", "核销码" + hexiaoCode.getText().toString().trim());
                    codeDetail(hexiaoCode.getText().toString().trim());
                }

                break;
        }
    }

    @Subscribe
    public void scanSucess(CodeEvent codeEvent) {
        codeDetail(codeEvent.result);
    }

    private void allOrder() {
        Intent intent = new Intent(mContext, AllOrderActivity.class);
        intent.putExtra("resourceId", ((MainActivity) getActivity()).resourceId);
        intent.putExtra("type", 0);
        startActivity(intent);
    }


    @Override
    public <T> LifecycleTransformer<T> bind2Lifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    protected boolean registerEvent() {
        return true;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewAndEvent() {
        drwerLayout.setScrimColor(Color.TRANSPARENT);
        EventUtil.register(this);
        refreshLayout.setEnableHeaderTranslationContent(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                loadData();
            }
        });
        hexiaoCode.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 16&&!charSequence.toString().contains("-")) {
                    String code = charSequence.toString();
                    String code1 = code.substring(0, 4);
                    String code2 = code.substring(4, 8);
                    String code3 = code.substring(8, 12);
                    String code4 = code.substring(12);
                    StringBuilder stringBuilder= new StringBuilder();
                    stringBuilder.append(code1).append("-").append(code2).append("-").append(code3).append("-").append(code4);
                   // String codeSend = code1 + "-" + code2 + "-" + code3 + "-" + code4;
                    codeDetail(stringBuilder.toString());
                }else if(charSequence.length()==19&&charSequence.toString().contains("-")){
                    codeDetail(charSequence.toString());
                }
            }
        });
        newOrder.setLayoutManager(new LinearLayoutManager(mContext));
        newOrder.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    private void codeDetail(String charSequence) {
        Log.e("TAG","进入订单详情");
        Intent intent = new Intent(mContext, OrderDetailActivity.class);
        intent.putExtra("ordercode", charSequence);
        startActivity(intent);
    }

    private void loadData() {
        //  mPresenter.getAllOrder(Constant.userToken, ((MainActivity) getActivity()).resourceId);
        Log.e("TAG", Constant.userToken + "---99999---" + ((MainActivity) getActivity()).resourceId);
        mPresenter.getReadySureOrder(Constant.userToken, ((MainActivity) getActivity()).resourceId);
    }

 /*   @Override
    protected void initData(boolean needShowLoading) {
        Log.e("TAG","加载数据");
       *//* DialogUtils.showProgressDialog(getActivity(), "正在加载...");
        loadData();*//*
    }*/

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void showLoading() {
        DialogUtils.showProgressDialog(getActivity(), "正在加载");
    }

    @Override
    public void hideLoading() {
        DialogUtils.disProgressDialog();
        if (refreshLayout.isRefreshing()) {
            refreshLayout.finishRefresh();
        }

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showNoNet() {

    }


    @Override
    public void getReadySureOrderSucess(HomeResulst homeResulst) {
        readSureSum.setText(homeResulst.getData().getConfirmsum() + "");
        allOrderSum2.setText(homeResulst.getData().getSumcount() + "");
        allOrderSum.setText(homeResulst.getData().getSumcount() + "");
        List<HomeResulst.DataEntity.ListEntity> datas = homeResulst.getData().getList();
        NewOrderAdaper newOrderAdaper = new NewOrderAdaper((Activity) mContext, datas);
        newOrderAdaper.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("orderid", datas.get(position).getId());
                startActivity(intent);
            }
        });
        newOrder.setAdapter(newOrderAdaper);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
