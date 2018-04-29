package com.sxzhwts.ticket.project.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sxzhwts.ticket.common.utils.SystemUtil;
import com.sxzhwts.ticket.project.MainActivity;
import com.sxzhwts.ticket.project.views.OrderDetailActivity;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by fcy on 2017/10/30.
 */

public class JPushNotifyReceiver extends BroadcastReceiver {

    private JSONObject jsonObject;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("TAG", "极光推送------" + intent.getAction());

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了自定义消息。消息内容是：" + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            // 自定义消息不会展示在通知栏，完全要开发者写代码去处理

            Log.d("TAGx-JPush", "Msg title:" + bundle.getString(JPushInterface.EXTRA_TITLE));
            Log.d("TAGx-JPush", "Msg content:" + bundle.getString(JPushInterface.EXTRA_MESSAGE));

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            System.out.println("收到了通知");
            // 在这里可以做些统计，或者做些其他工作
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
           // EventBus.getDefault().post(new JpushEvent(title,content));
            //判断app进程是否存活

            Log.d("TAGx-JPush", "notify title:" + title);
            Log.d("TAGx-JPush", "notify content:" + content);
            Log.d("TAGx-JPush", "notify extras:" + extras);
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            System.out.println("用户点击打开了通知");
            // 在这里可以自己写代码去定义用户点击后的行为
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
            Log.e("TAGx-JPush", "title:" + title);
            Log.e("TAGx-JPush", "content:" + content);
            Log.e("TAGx-JPush", "extras:" + extras);
            if(SystemUtil.isAppAlive(context, "com.sxzhwts.ticket")){
                Log.i("NotificationReceiver", "the app process is alive");
                Intent mainIntent = new Intent(context, MainActivity.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Intent detailIntent = new Intent(context, OrderDetailActivity.class);
                try {
                    jsonObject=new JSONObject(extras);
                    mainIntent.putExtra("resourceId",jsonObject.getString("res_id"));
                    detailIntent.putExtra("orderid",jsonObject.getString("id"));
                    Intent[] intents = {mainIntent, detailIntent};
                    context.startActivities(intents);
                } catch (JSONException e) {

                    e.printStackTrace();
                }

            }else {
                Log.i("NotificationReceiver", "the app process is dead");
                Intent launchIntent = context.getPackageManager().
                        getLaunchIntentForPackage("cn.com.zhwts");
                launchIntent.setFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                context.startActivity(launchIntent);
            }
        } else {
            Log.d("TAG", "Unhandled intent - " + intent.getAction());
        }
    }

}

