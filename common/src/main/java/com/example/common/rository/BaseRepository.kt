package com.example.common.rository

import com.example.net.exception.DealException
import com.example.net.exception.ResultException
import com.example.net.model.BaseResult
import com.example.net.model.DataStatus
import com.example.net.model.ResultState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 *    author : Bin
 *    date   : 2022/1/1414:54
 *    desc   : 数据仓库基类
 */
open class BaseRepository {

    /**
     * 请求
     */
    suspend fun <T : Any> callRequest(
        call: suspend () -> ResultState<T>
    ): ResultState<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            ResultState.Error(DealException.handlerException(e))
        }
    }

    /**
     * 处理返回结果
     */
    suspend fun <T : Any> handleResponse(
        response: BaseResult<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): ResultState<T> {
        return coroutineScope {
            if (response.errorCode != 0) {
                //返回不成功
                errorBlock?.let {
                    it()
                }
                //结果回调
                ResultState.Error(
                    ResultException(
                        response.errorCode.toString(),
                        response.errorMsg ?: ""
                    )
                )
            } else {
                //返回成功
                successBlock?.let { it() }
                //结果回调
                ResultState.Success(response.data)
            }
        }
    }

    suspend fun <T : Any> executeRequest(
        block: suspend () -> BaseResult<T>,
        stateLiveData: StateLiveData<T>
    ) {
        var baseResp = BaseResult<T>()
        try {
            baseResp.dataStatus = DataStatus.STATE_LOADING
            stateLiveData.postValue(baseResp)
            //将结果复制给baseResp
            baseResp = block.invoke()
            if (baseResp.errorCode == 0) {
                //成功
                baseResp.dataStatus = DataStatus.STATE_SUCCESS
            } else {
                //服务器请求失败
                baseResp.dataStatus = DataStatus.STATE_ERROR
                baseResp.exception =
                    ResultException(baseResp.errorCode.toString(), baseResp.errorMsg ?: "")
            }
        } catch (e: java.lang.Exception) {
            //非后台返回错误，捕捉到的异常
            baseResp.dataStatus = DataStatus.STATE_ERROR
            baseResp.exception = DealException.handlerException(e)
        } finally {
            stateLiveData.postValue(baseResp)
        }
    }
}