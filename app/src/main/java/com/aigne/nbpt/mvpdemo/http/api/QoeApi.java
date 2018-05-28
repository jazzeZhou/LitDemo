package com.aigne.nbpt.mvpdemo.http.api;

import com.aigne.nbpt.mvpdemo.http.ResponseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author jazzeZhou
 * @date 2018/5/25
 */
public interface QoeApi {

    @FormUrlEncoded
    @POST("manage/service/getQoeCollectionData")
    Observable<ResponseBean> getQoeCollectionData(@Field("params") String params);

}
