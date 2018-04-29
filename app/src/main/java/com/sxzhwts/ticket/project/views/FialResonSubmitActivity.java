package com.sxzhwts.ticket.project.views;

import android.support.v7.widget.AppCompatTextView;
import android.widget.EditText;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.EventUtil;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.contract.ReasonSubmitContract;
import com.sxzhwts.ticket.project.event.SubmitEvent;
import com.sxzhwts.ticket.project.prenster.ReasonSubmitPrenster;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/20 16:11
 */

public class FialResonSubmitActivity extends BaseMvpActivity<ReasonSubmitPrenster> implements ReasonSubmitContract.View {
    @BindView(R.id.reasonEt)
    EditText reasonEt;
    @BindView(R.id.submit)
    AppCompatTextView submit;
    private String orderId;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_submitreson;
    }

    @Override
    protected void initViewAndEvent() {
        orderId=getIntent().getStringExtra("orderId");
        titleText.setText("失败原因");
    }

    @Override
    public void submitSucess(Result result) {
            if(result.code==1){
                ToastUtils.showToast(mContext,"提交成功");
                EventUtil.sendEvent(new SubmitEvent(result.code));
            }else{
                ToastUtils.showToast(mContext,"提交失败");
            }
            finishedActivity();
    }

    @OnClick(R.id.submit)
    public void onViewClicked() {
        mPrenster.submit(Constant.userToken,orderId,reasonEt.getText().toString().trim());
    }
}
