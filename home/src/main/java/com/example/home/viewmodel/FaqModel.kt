package com.example.home.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.common.base.BasePagingResult
import com.example.common.base.BaseViewModel
import com.example.common.model.TitleViewModel
import com.example.common.rository.StateLiveData
import com.example.home.bean.ArticleBean
import com.example.home.repo.HomeRepo
import kotlinx.coroutines.launch

/**
 *    author : Bin
 *    date   : 2022/1/1510:46
 *    desc   :
 */
class FaqModel(application: Application, private val homeRepo: HomeRepo) : BaseViewModel(application) {

    val mTitleVM = TitleViewModel(leftDrawable = null)

    /**
     * 设置标题
     */
    fun setTitle(title: String) {
        mTitleVM.mTitle.set(title)
    }

    fun setLeftIconNull() {
        mTitleVM.leftDrawable = null
    }

    //问答数据
    val mFaqList = StateLiveData<BasePagingResult<List<ArticleBean>>>()

    /**
     * 获取问答数据
     */
    fun getFaqList(position: Int) {
        viewModelScope.launch {
            homeRepo.getFaqList(position, mFaqList)
        }
    }

    /**
     * 收藏
     */
    suspend fun collect(id: Int?): Boolean {
        return homeRepo.collect(id)
    }

    /**
     * 取消收藏
     */
    suspend fun unCollect(id: Int?): Boolean {
        return homeRepo.unCollect(id)
    }
}