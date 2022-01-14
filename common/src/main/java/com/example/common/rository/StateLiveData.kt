package com.example.common.rository

import androidx.lifecycle.MutableLiveData
import com.example.net.model.BaseResult

/**
 *    author : Bin
 *    date   : 2022/1/1414:49
 *    desc   : 数据
 */
class StateLiveData<T> : MutableLiveData<BaseResult<T>>() {
}