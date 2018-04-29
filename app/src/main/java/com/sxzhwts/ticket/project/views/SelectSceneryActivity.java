package com.sxzhwts.ticket.project.views;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.SharedPresUtils;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.adapter.SceneryAdapter;
import com.sxzhwts.ticket.project.bean.response.SceneryResult;
import com.sxzhwts.ticket.project.contract.SceneryContract;
import com.sxzhwts.ticket.project.prenster.SceneryPrenster;
import com.sxzhwts.ticket.project.receiver.TagAliasOperatorHelper;

import butterknife.BindView;

/**
 * 作者：fcy on 2018/4/16 10:47
 */

public class SelectSceneryActivity extends BaseMvpActivity<SceneryPrenster> implements SceneryContract.View{
    @BindView(R.id.sceneryRecyclerView)
    RecyclerView sceneryRecyclerView;

    private String resourceId;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getChildlayout() {
        return R.layout.activity_selectscenery;
    }

    @Override
    protected void initViewAndEvent() {
      titleText.setText("选择景区");
      titleBack.setVisibility(View.GONE);


      mPrenster.getScenery(Constant.userToken);
    }

    @Override
    public void getScenerySucess(SceneryResult sceneryResult) {
        sceneryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        sceneryRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        SceneryAdapter sceneryAdaper= new SceneryAdapter(sceneryResult.getData(),mContext);
        sceneryAdaper.setOnItemClickListener((view, position) -> {
            resourceId=sceneryResult.getData().get(position).getResourceId();
        },(view, position) -> {
           Intent intent= new Intent(mContext, MainActivity.class);
           intent.putExtra("resourceId",resourceId);
            //setStyleBasic();
            //setAlias(resourceId.replace("-", ""));
            TagAliasOperatorHelper.getInstance().setTag(getApplicationContext(),resourceId);
            Constant.resourceId=resourceId;
            SharedPresUtils.getSharedPresUtils(mContext).putString("resourceId",resourceId);
            startActivity(intent);
            finishedActivity();
        });
        sceneryRecyclerView.setAdapter(sceneryAdaper);

    }
    /**
     * 设置通知提示方式 - 基础属性
     */
/*    private void setStyleBasic() {
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(this);
        builder.statusBarDrawable = R.drawable.logo;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL;  //设置为点击后自动消失
        builder.notificationDefaults = Notification.DEFAULT_SOUND;  //设置为铃声（ Notification.DEFAULT_SOUND）或者震动（ Notification.DEFAULT_VIBRATE）
        JPushInterface.setPushNotificationBuilder(1, builder);
        //Toast.makeText(PushSetActivity.this, "Basic Builder - 1", Toast.LENGTH_SHORT).show();
    }
    private void setAlias(String alias) {
        if (TextUtils.isEmpty(alias)) {
            Log.e("JPush", "error_alias_empty");
            return;
        }
        Log.e("JPush", "alias:" + alias);
        // 调用 Handler 来异步设置TAG
        pushHandler.sendMessage(pushHandler.obtainMessage(MSG_SET_ALIAS, alias));

    }
    private static final int MSG_SET_ALIAS = 1001;
    private final Handler pushHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
                    Log.e("JPush", "Set alias in handler.");
                    // 调用 JPush 接口来设置别名。
                    // JPushInterface.setAliasAndTags(getApplicationContext(), (String) msg.obj, null, mAliasCallback);
                    Set<String> tagSet = new LinkedHashSet<String>();
                    tagSet.add((String) msg.obj);
                    // 调用 JPush 接口来设置TAG。
                    JPushInterface.setTags(getApplicationContext(), tagSet, mAliasCallback);
                    break;
                default:
                    Log.e("JPush", "Unhandled msg - " + msg.what);
            }
        }
    };
    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    Log.e("JPush", logs);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                case 6014:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    Log.e("JPush", logs);
                    // 延迟 60 秒来调用 Handler 设置别名
                    String tag = tags.iterator().next();
                    Log.e("JPush", tag + "二次设置");
                    pushHandler.sendMessageDelayed(pushHandler.obtainMessage(MSG_SET_ALIAS, tag), 1000 * 60);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
                    Log.e("JPush", logs);
            }
        }
    };*/
}
