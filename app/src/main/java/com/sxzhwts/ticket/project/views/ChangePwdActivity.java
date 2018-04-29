package com.sxzhwts.ticket.project.views;

import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.ChangePwdContract;
import com.sxzhwts.ticket.project.prenster.ChangePwdPrenster;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/17 09:06
 */

public class ChangePwdActivity extends BaseMvpActivity <ChangePwdPrenster> implements ChangePwdContract.View{
    @BindView(R.id.etOldPwd)
    EditText etOldPwd;
    @BindView(R.id.resetPwdSecond)
    EditText resetPwdSecond;
    @BindView(R.id.etnewPwd)
    EditText etnewPwd;
    @BindView(R.id.sureChange)
    AppCompatTextView sureChange;

    @Override
    protected void initInject() {
      getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_changepwd;
    }

    @Override
    protected void initViewAndEvent() {
        titleText.setText("修改密码");
        titleBack.setOnClickListener(view -> {
            finishedActivity();
        });
    }

    @OnClick(R.id.sureChange)
    public void onViewClicked() {
        String oldPwd=etOldPwd.getText().toString().trim();
        String newPwd=etnewPwd.getText().toString().trim();
        String secondPwd=resetPwdSecond.getText().toString().trim();

        if(!TextUtils.isEmpty(oldPwd)&& !TextUtils.isEmpty(newPwd)&&!TextUtils.isEmpty(secondPwd)&&newPwd.equals(secondPwd)){
            Log.e("TAG","修改密码");
            mPrenster.changePwd(Constant.userToken,oldPwd,newPwd);
        }else{
            if(TextUtils.isEmpty(oldPwd)){
                ToastUtils.showToast(mContext,"请输入原密码");
                return;
            }
            if(TextUtils.isEmpty(newPwd)){
                ToastUtils.showToast(mContext,"请输入新密码");
                return;
            }
            if(TextUtils.isEmpty(secondPwd)){
                ToastUtils.showToast(mContext,"请再次输入新密码");
                return;
            }
            if(!newPwd.equals(secondPwd)){
                ToastUtils.showToast(mContext,"两次密码输入不一致");

            }
        }

    }

    @Override
    public void changeSucess(Result result) {
        if(result.code==1){
            ToastUtils.showToast(mContext,"修改成功，请您牢记");
        }else {
            ToastUtils.showToast(mContext,result.message);
        }
        finishedActivity();
    }
}
