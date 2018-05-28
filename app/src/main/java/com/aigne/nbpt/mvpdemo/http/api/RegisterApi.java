package com.aigne.nbpt.mvpdemo.http.api;

import com.aigne.nbpt.mvpdemo.http.ResponseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @auther litie
 * @date 2018/5/25 0025
 */
public interface RegisterApi {
    @FormUrlEncoded
    @POST("/device/register")
    Observable<ResponseBean> register(@Field("params") String params);

}
