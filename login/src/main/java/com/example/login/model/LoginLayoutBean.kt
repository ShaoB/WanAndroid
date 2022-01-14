package com.example.login.model

import androidx.databinding.BaseObservable
import com.example.login.BR

/**
 *    author : Bin
 *    date   : 2022/1/1411:30
 *    desc   :
 */
class LoginLayoutBean : BaseObservable() {

    /**
     * 是否是登录页面
     */
    var isLogin: Boolean = true
        set(value) {
            if (value == field) {
                return
            }
            field = value
            //刷新所有
            notifyPropertyChanged(BR._all)
        }


    var tips = if (isLogin) {
        "账号登录"
    } else {
        "账号注册"
    }

    var btnText = if (isLogin) {
        "登录"
    } else {
        "注册"
    }

    val featureName = if (isLogin) {
        "注册"
    } else {
        "登录"
    }

}