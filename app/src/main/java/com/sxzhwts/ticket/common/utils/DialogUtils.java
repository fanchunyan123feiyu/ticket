package com.sxzhwts.ticket.common.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.sxzhwts.ticket.R;


/**
 * Created by bibinet on 2017-4-22.
 */

public class DialogUtils {

    private static Dialog dialog;

    public static void showProgressDialog(Activity activity, String showMsg) {
       /* dialog = new ProgressDialog(activity);
        dialog.setMessage(content);
      */
        Log.e("TAG","显示dialog");
        if(dialog!=null){
           if(!dialog.isShowing()) {
               Log.e("TAG","没有正在显示的   开始显示");
               dialog.show();
           }
        }else{
            Log.e("TAG","创建dialog显示");
            dialog = new Dialog(activity, R.style.loading_dialog_style);
            LayoutInflater inflater = LayoutInflater.from(activity);
            View view = inflater.inflate(R.layout.loading_layout_dialog, null);
            AppCompatTextView textView=(AppCompatTextView)view.findViewById(R.id.tv_load_dialog);
            textView.setText(showMsg);
            dialog.setContentView(view);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setGravity(Gravity.CENTER);
                window.setDimAmount(0.1f);
            }
            //dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
        }

    }


    public static void disProgressDialog() {
        Log.e("TAG","隐藏dialog");
        if (dialog != null&&dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
    public  static  void  showAlertDialog(Context context,String message,AletOnClickListener aletOnClickListener){
        new AlertDialog.Builder(context).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                aletOnClickListener.sureOnClickListener();
            }
        }).setTitle("温馨提示").setMessage(message).create().show();
    }

    public interface AletOnClickListener{
       void sureOnClickListener();
    }
}
