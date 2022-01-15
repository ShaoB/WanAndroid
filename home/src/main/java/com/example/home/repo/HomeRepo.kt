package com.example.home.repo

import com.example.common.base.BasePagingResult
import com.example.common.rository.BaseRepository
import com.example.common.rository.StateLiveData
import com.example.home.api.HomeApi
import com.example.home.bean.ArticleBean
import com.example.net.model.ResultState

/**
 *    author : Bin
 *    date   : 2022/1/1511:23
 *    desc   :
 */
class HomeRepo(private val homeApi: HomeApi) : BaseRepository() {

    /**
     * 获取问答数据
     */
    suspend fun getFaqList(
        position: Int, data: StateLiveData<BasePagingResult<List<ArticleBean>>>
    ) {
        executeRequest({ homeApi.wendaList(position) }, data)
    }

    /**
     * 收藏
     */
    suspend fun collect(id: Int?): Boolean {
        val result = callRequest { handleResponse(homeApi.collect(id)) }
        return result is ResultState.Success
    }

    /**
     * 取消收藏
     */
    suspend fun unCollect(id: Int?): Boolean {
        val result = callRequest { handleResponse(homeApi.unCollect(id)) }
        return result is ResultState.Success
    }
}