package com.example.user.viewmodel

import androidx.databinding.BaseObservable
import com.example.common.route.LoginServiceUtils
import com.example.user.BR

/**
 *    author : Bin
 *    date   : 2022/1/1217:21
 *    desc   :
 */
class UserItem : BaseObservable() {

    var userName
        get() = if (LoginServiceUtils.isLogin()) {
            LoginServiceUtils.getUserInfo()?.username ?: "暂无用户昵称"
        } else {
            "去登录"
        }
        set(_) {}

    /**
     * 退出登录是否显示
     */
    var mBtQuitIsShow
        get() = LoginServiceUtils.isLogin()
        set(_) {}

    fun refresh() {
        notifyPropertyChanged(BR._all)
    }
}