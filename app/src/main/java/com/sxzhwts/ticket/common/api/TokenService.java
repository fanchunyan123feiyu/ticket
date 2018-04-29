package com.sxzhwts.ticket.common.api;

import com.sxzhwts.ticket.project.bean.response.TokenResult;
import com.sxzhwts.ticket.project.bean.response.VersionResult;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 作者：fcy on 2018/4/14 17:16
 */

public interface TokenService {
    @FormUrlEncoded
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @POST("Token")
    Observable<TokenResult> getToken(@Header("authorization") String authorization, @Field("grant_type") String grant_type);

    @POST("version/now/")
    Observable<VersionResult>  getVersion(@Query("access_token") String access_token);

    @Streaming
    @GET
    Call<ResponseBody> downloadApk(@Url String apkUrl);
}
