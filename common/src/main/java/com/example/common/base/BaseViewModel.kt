package com.example.common.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 *    author : Bin
 *    date   : 2022/1/1414:38
 *    desc   : viewModel 基类
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    // 是否显示 dialog
    var isDialogShow = MutableLiveData<Boolean>()

    fun dialogState(activity: BaseActivity) {
        val weakReference = WeakReference(activity)
        isDialogShow.observe(activity, {
            if (it) weakReference.get()?.showLoading()
            else weakReference.get()?.dismissLoading()
        })
    }

    fun dialogState(fragment: BaseFragment) {
        val weakReference = WeakReference(fragment)
        isDialogShow.observe(fragment, {
            if (it) weakReference.get()?.showLoading()
            else weakReference.get()?.dismissLoading()
        })
    }

    suspend fun toast(message: String) {
        withContext(Dispatchers.Main) {
            if (message.isNotEmpty()) {
                ToastUtils.showShort(message)
            }
        }
    }
}