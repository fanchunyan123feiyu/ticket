package com.sxzhwts.ticket.project.views;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sxzhwts.ticket.R;
import com.sxzhwts.ticket.common.utils.EventUtil;
import com.sxzhwts.ticket.project.event.CodeEvent;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

/**
 * 作者：fcy on 2018/4/18 09:23
 */

public class ScanCodeActivity extends AppCompatActivity implements QRCodeView.Delegate {


    @BindView(R.id.zxingview)
    ZBarView mQRCodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scancode);
        ButterKnife.bind(this);
        mQRCodeView.setDelegate(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

      private void vibrate() {
          Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
          vibrator.vibrate(200);
      }
    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i("TAG", "扫描result:" + result);
       // Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        EventUtil.sendEvent(new CodeEvent(result));
        vibrate();
        mQRCodeView.startSpot();
        finish();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e("TAG", "打开相机出错");
    }



}
