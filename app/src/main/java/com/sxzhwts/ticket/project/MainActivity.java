package com.sxzhwts.ticket.project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.Constant;
import com.sxzhwts.ticket.common.base.BaseAcivity;
import com.sxzhwts.ticket.common.utils.PermmisionUtils;
import com.sxzhwts.ticket.common.utils.UserTokenUtils;
import com.sxzhwts.ticket.common.utils.VersionUpdateNotifyUtils;
import com.sxzhwts.ticket.project.views.HomeFragment2;
import com.sxzhwts.ticket.project.views.ReadySureActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：fcy on 2018/4/16 15:57
 */

public class MainActivity extends BaseAcivity {
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homeButton)
    RadioButton homeButton;
    @BindView(R.id.readySureButton)
    RadioButton readySureButton;
    private HomeFragment2 homeFragment;
    public String resourceId;

   private VersionUpdateNotifyUtils versionUpdateUtils;
    @Override
    protected int getChildlayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initViewAndEvent() {
        titleLayout.setVisibility(View.GONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        10001);//自定义的code
            }
        }
        resourceId = getIntent().getStringExtra("resourceId");
        homeFragment = new HomeFragment2();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, homeFragment).show(homeFragment).commit();
        homeButton.setChecked(true);

       /* versionUpdateUtils= new VersionUpdateUtils(mContext);
        versionUpdateUtils .checkVersion(Constant.clientToken);*/
        versionUpdateUtils= new VersionUpdateNotifyUtils(mContext);
        if(!TextUtils.isEmpty(Constant.clientToken)){
            versionUpdateUtils .checkVersion(Constant.clientToken);
        }else{
            new UserTokenUtils(mContext).getUserToken(new UserTokenUtils.UserTokenSuccessListenter() {
                @Override
                public void tokenSuccess() {
                    versionUpdateUtils .checkVersion(Constant.clientToken);
                }
            });
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10001) {
            if (grantResults.length >= 1) {
                PermmisionUtils permmisionUtils = new PermmisionUtils(mContext);
                if (grantResults[0] == PackageManager.PERMISSION_DENIED)
                    if (grantResults[1] == PackageManager.PERMISSION_DENIED) {
                        permmisionUtils.permissionDialog("当前应用缺少必要权限。请点击“设置”-“权限”打开获取sd卡读写权限");
                    }
                if (grantResults[2] == PackageManager.PERMISSION_DENIED) {
                    permmisionUtils.permissionDialog("当前应用缺少必要权限。请点击“设置”-“权限”打开获取相机权限");
                }
            }
        }
    }

    @OnClick({R.id.homeButton, R.id.readySureButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homeButton:
                break;
            case R.id.readySureButton:
                startActivity(new Intent(mContext, ReadySureActivity.class));
                break;
        }
    }

    //双击退出程序
    long exitTime = 0;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN
                    && event.getRepeatCount() == 0) {
                if (System.currentTimeMillis() - exitTime > 2000) {
                    Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                    finish();
                }
            }
            return false;
        } else {
            return super.dispatchKeyEvent(event);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(versionUpdateUtils!=null){
            versionUpdateUtils=null;
        }
    }
}
