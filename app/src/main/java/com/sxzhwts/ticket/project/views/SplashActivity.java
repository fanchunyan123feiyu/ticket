package com.sxzhwts.ticket.project.views;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseMvpActivity;
import com.sxzhwts.ticket.common.utils.ClientTokenToBeanUtils;
import com.sxzhwts.ticket.common.utils.SharedPresUtils;
import com.sxzhwts.ticket.common.utils.ToastUtils;
import com.sxzhwts.ticket.common.utils.TokenUtils;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.bean.response.LoginResult;
import com.sxzhwts.ticket.project.bean.response.UserInfo;
import com.sxzhwts.ticket.project.contract.LoginContract;
import com.sxzhwts.ticket.project.prenster.LoginPrenster;
import com.sxzhwts.ticket.project.receiver.TagAliasOperatorHelper;

import java.util.Map;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;

/**
 * 作者：fcy on 2018/4/14 16:34
 */

public class SplashActivity extends BaseMvpActivity<LoginPrenster> implements LoginContract.View{
    @BindView(R.id.launcherIv)
    ImageView launcherIv;

    private ObjectAnimator anim;
    private String username,userpwd;

    @Override
    protected int getChildlayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewAndEvent() {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        titleLayout.setVisibility(View.GONE);

        if (Build.VERSION.SDK_INT >= 23) {
          Log.e("TAG","获取权限");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA},
                    10001);

        }else{
            login();
        }
        anim = ObjectAnimator.ofFloat(launcherIv, "alpha", 0.5f, 1.0f).setDuration(1000);
        anim.start();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10001 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("温馨提示");
            builder.setMessage("当前应用缺少必要权限。请点击“设置”-“权限”");
            // 拒绝, 退出应用
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    login();
                }
            });
            builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    startAppSettings();
                }
            });
            builder.show();
        }else{
           login();
        }
    }

    private void login() {
        Log.e("TAG","login1");
        new TokenUtils(mContext).getTokenFromServer(new TokenUtils.tokenSuccessListenter() {
            @Override
            public void tokenSuccess() {
                autoLogin();
            }
            @Override
            public void tokenFial() {
                Log.e("TAG","login1  tokenFial");
                ToastUtils.showToast(mContext, "网络错误，请检查您的网络");
            }
        });
    }

    // 启动应用的设置
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
    private void autoLogin() {
        Log.e("TAG","autoLogin");
        SharedPresUtils loginPres = SharedPresUtils.getSharedPresUtils(mContext);
        Map map = loginPres.loadUserInfo();
         username = (String) map.get("username");
         userpwd = (String) map.get("userpwd");
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(userpwd)) {
            Log.e("TAG", "enterLogin1");
            enterLogin();
        } else {
            Log.e("TAG", "enterLogin2" + username + userpwd);
            dologin(username, userpwd);//自动登录
        }
    }


    private void enterLogin() {
        startActivity(new Intent(mContext, LoginActivity.class));
        finishedActivity();
    }

    @Override
    public void showNoNet() {
        super.showNoNet();
        startActivity(new Intent(mContext,LoginActivity.class));
    }

    private void dologin(final String account, final String password) {
        String clientToken = new ClientTokenToBeanUtils(mContext).getClientToken();
        if (!TextUtils.isEmpty(clientToken)) {
           mPrenster.login(account, password, clientToken);
        } else {
            Log.e("TAG", "enterLogin5");
            enterLogin();
        }

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void loginSucess(LoginResult loginResult) {
        ToastUtils.showToast(mContext,"登录成功");
        Constant.userToken=loginResult.getData().getAccess_token();
        Constant.userInfo = new UserInfo(username, userpwd);
        if (JPushInterface.isPushStopped(getApplicationContext())) {
            JPushInterface.resumePush(getApplicationContext());
        }

        String resourceId=SharedPresUtils.getSharedPresUtils(mContext).getString("resourceId","");
               if(!TextUtils.isEmpty(resourceId)){
                   Intent intent=new Intent(mContext, MainActivity.class);
                   Constant.resourceId=resourceId;
                   intent.putExtra("resourceId",resourceId);
                   Log.e("TAG","resourceId"+resourceId);
                  // setStyleBasic();
                  // setAlias(resourceId.replace("-", ""));
                  // setTag(resourceId);
                   TagAliasOperatorHelper.getInstance().setTag(getApplicationContext(),resourceId);
                   startActivity(intent);
               }else{
                   startActivity(new Intent(mContext,SelectSceneryActivity.class));
               }
        finishedActivity();
    }

    @Override
    public void connectTime() {
        super.connectTime();
        dologin(username, userpwd);
    }
}
