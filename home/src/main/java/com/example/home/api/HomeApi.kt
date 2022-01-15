package com.example.home.api

import com.example.common.base.BasePagingResult
import com.example.home.bean.ArticleBean
import com.example.net.model.BaseResult
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 *    author : Bin
 *    date   : 2022/1/1511:20
 *    desc   :
 */
interface HomeApi {

    //获取问答列表
    @GET("wenda/list/{page}/json ")
    suspend fun wendaList(@Path("page") page: Int): BaseResult<BasePagingResult<List<ArticleBean>>>

    //收藏站内文章 文章id，拼接在链接中。
    @POST("/lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int?): BaseResult<String>
    
    //取消收藏  文章列表 文章id，拼接在链接中。
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun unCollect(@Path("id") id: Int?): BaseResult<String>
}