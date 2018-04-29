package com.sxzhwts.ticket.common;

import com.sxzhwts.ticket.MyApplication;
import com.sxzhwts.ticket.project.bean.response.UserInfo;

import java.io.File;

/**
 * 作者：fcy on 2018/4/14 16:02
 */

public class Constant {
    public static final String PATH_DATA = MyApplication.getInstamce().getCacheDir().getAbsolutePath()
            + File.separator + "data";
    public static final long DEFAULT_CACHE_SIZE = 50 * 1024 * 1024;

    public static  String clientToken=null;
    public  static Long clientTokenTime=null;
    public static  String userToken=null;

    public static  String resourceId=null;
    static String  cachePath= MyApplication.getInstamce().getExternalCacheDir().getPath();
    public  static  String cacheHttp=cachePath+"/http";
    public static UserInfo userInfo;
}
