package com.sxzhwts.ticket.project.ui;

import android.text.TextUtils;

/**
 * 作者：fcy on 2018/4/27 10:39
 *     支付方式工具类
 */

public class PayMethodUtil {
    private static String str;

    public static String getMethod(String paymethond){
        if(!TextUtils.isEmpty(paymethond)){
            switch (paymethond){
                case "1":
                    str= "支付方式：微信支付";
                    break;
                case "2":
                    str="支付方式：支付宝支付";
                    break;
                case "3":
                    str="支付方式：余额支付";
                    break;
                default:
                    str="支付方式：未支付";
            }
        }
        return str;
    }
}
