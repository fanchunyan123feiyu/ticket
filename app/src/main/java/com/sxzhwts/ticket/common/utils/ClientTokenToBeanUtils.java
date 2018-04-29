package com.sxzhwts.ticket.common.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.sxzhwts.ticket.common.Constant;


/**
 * Created by fcy on 2017/7/5.
 * 获取客户端token
 */

public class ClientTokenToBeanUtils {
    private Activity activity;
    private  String clientToken;
    private TokenUtils tokenUtils;
    public ClientTokenToBeanUtils(Activity activity) {
        this.activity=activity;
        tokenUtils= new TokenUtils(activity);
    }
    public   String getClientToken(){
        if (TextUtils.isEmpty(Constant.clientToken) || System.currentTimeMillis() / 1000 - Constant.clientTokenTime > 3000) {

            tokenUtils.getTokenFromServer(new TokenUtils.tokenSuccessListenter() {
                @Override
                public void tokenSuccess() {
                    clientToken = Constant.clientToken;
                    Log.e("TAG","为token赋值");
                }
                @Override
                public void tokenFial() {
                    //// TODO: 2017/6/29
                    clientToken="";
                }
            });
        } else {
            clientToken = Constant.clientToken;
        }
     return clientToken;
    }
   /* public JSONObject getToken(){
       final JSONObject jsonObject = new JSONObject();
       if (TextUtils.isEmpty(Constant.clientToken) || System.currentTimeMillis() / 1000 - Constant.clientTokenTime > 3000) {
          tokenUtils.getTokenFromServer(new TokenUtils.tokenSuccessListenter() {
               @Override
               public void tokenSuccess() {
                   try {
                       jsonObject.put("clientToken", Constant.clientToken);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }

                   clientToken = Constant.clientToken;
               }

               @Override
               public void tokenFial() {
                   //// TODO: 2017/6/29
               }
           });
       } else {
           clientToken = Constant.clientToken;
           try {
               jsonObject.put("clientToken", Constant.clientToken);
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
       return  jsonObject;
    }*/

}
