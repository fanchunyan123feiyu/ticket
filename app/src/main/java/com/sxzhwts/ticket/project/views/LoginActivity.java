package com.sxzhwts.ticket.project.views;

import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.ClientTokenToBeanUtils;
import com.sxzhwts.ticket.common.utils.SharedPresUtils;
import com.sxzhwts.ticket.project.bean.response.LoginResult;
import com.sxzhwts.ticket.project.bean.response.UserInfo;
import com.sxzhwts.ticket.project.contract.LoginContract;
import com.sxzhwts.ticket.project.prenster.LoginPrenster;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/14 14:14
 */

public class LoginActivity extends BaseMvpActivity<LoginPrenster> implements LoginContract.View {
    @BindView(R.id.userAccount)
    AppCompatEditText userAccount;
    @BindView(R.id.userPwd)
    AppCompatEditText userPwd;
    @BindView(R.id.login)
    AppCompatTextView login;
    private String account, pwd;

    @Override
    public void loginSucess(LoginResult loginResult) {
        Constant.userToken = loginResult.getData().getAccess_token();
        Constant.userInfo = new UserInfo(account, pwd);
        SharedPresUtils.getSharedPresUtils(mContext).saveUserInfo(account, pwd);
        startActivity(new Intent(mContext, SelectSceneryActivity.class));
        finishedActivity();
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViewAndEvent() {
        titleLayout.setVisibility(View.GONE);
    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        account = userAccount.getText().toString().trim();
        pwd = userPwd.getText().toString().trim();
        mPrenster.login(account, pwd, new ClientTokenToBeanUtils(mContext).getClientToken());
    }
}
