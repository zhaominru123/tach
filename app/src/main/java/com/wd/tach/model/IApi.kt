package com.wd.tach.model

import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable


/*
 *@Auther:赵敏如
 *@Date: 2019年
 *@Time: 
 *@Description:
 * */interface IApi {

    //登录
    @FormUrlEncoded
    @POST("techApi/user/v1/login")
    fun login(@Field("phone") phone:String,@Field("pwd") pwd:String) : Observable<LoginBean>

    //注册
    @FormUrlEncoded
    @POST("techApi/user/v1/register")
    fun register(@Field("phone") phone:String,@Field("nickName") nickName:String,@Field("pwd") pwd:String) : Observable<RegisterBean>
}