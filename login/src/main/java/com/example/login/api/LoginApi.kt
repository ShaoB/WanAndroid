package com.example.login.api

import com.example.common.bean.User
import com.example.net.model.BaseResult
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *    author : Bin
 *    date   : 2022/1/1415:28
 *    desc   : 登录模块 相关接口
 */
interface LoginApi {

    /**
     * 登录
     * 登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。
     */
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseResult<User>
}