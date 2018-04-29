package com.sxzhwts.ticket.common.api;

import com.sxzhwts.ticket.project.bean.response.BusOrderDetailResult;
import com.sxzhwts.ticket.project.bean.response.HomeResulst;
import com.sxzhwts.ticket.project.bean.response.LoginResult;
import com.sxzhwts.ticket.project.bean.response.OrderResult;
import com.sxzhwts.ticket.project.bean.response.Result;
import com.sxzhwts.ticket.project.bean.response.SceneryResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 作者：fcy on 2018/4/14 12:32
 *

 */

public interface ApiService {
    @FormUrlEncoded
    @POST("http://datacenter.sxzhwts.com/api/admin/token")
    Observable<LoginResult> login(@Field("access_token") String access_token,@Field("admin_name") String account,@Field("admin_password") String pwd);


    @FormUrlEncoded
    @POST("permission")
    Observable<SceneryResult> getScenery(@Field("access_token") String access_token);

    @Headers("Accept-Encoding:identity")
    @FormUrlEncoded
    @POST("ordersummary")
    Observable<OrderResult> getAllOrder(
            @Field("access_token") String access_token,
            @Field("resourceId") String resourceId,
            @Field("state") String state,
            @Field("page") String page,
            @Field("begintime") String begintime,
            @Field("endtime") String endtime,
            @Field("isself") String isself
            );

    @Headers("Accept-Encoding:identity,Connection:close")
    @FormUrlEncoded
    @POST("getorderlistByrid")
    Observable<HomeResulst> getReadySureOrder(@Field("access_token") String access_token, @Field("resourceId") String resourceId);

    @Headers("Accept-Encoding:identity,Connection:close")
    @FormUrlEncoded
    @POST("orderdeatil")
    Observable<BusOrderDetailResult> getOrderDetailById(@Field("access_token") String access_token, @Field("order_id") String order_id);


    @FormUrlEncoded
    @POST("selectorderbycode")
    Observable<BusOrderDetailResult> getOrderDetailByCode(@Field("access_token") String access_token, @Field("code") String code,@Field("resourceId") String resourceId);

    @FormUrlEncoded
    @POST("verication")
    Observable<Result> verication(@Field("access_token") String access_token, @Field("order_id") String order_id);

    @FormUrlEncoded
    @POST("orderfirmyes")
    Observable<Result> orderfirmyes(@Field("access_token") String access_token, @Field("order_id") String order_id);

    @FormUrlEncoded
    @POST("http://datacenter.sxzhwts.com/api/admin/updatePassword")
    Observable<Result> changePwd(@Field("admin_access_token") String access_token, @Field("old_password") String order_id,@Field("new_password") String new_password);

    @FormUrlEncoded
    @POST("orderfirmno")
    Observable<Result> submitReason(@Field("access_token") String access_token, @Field("order_id") String order_id,@Field("remark") String remark);

    @FormUrlEncoded
    @POST("orderfirmyes")
    Observable<Result> sureOutTicket(@Field("access_token") String access_token, @Field("order_id") String order_id);


}
