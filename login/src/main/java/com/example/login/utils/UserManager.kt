package com.example.login.utils

import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.LogUtils
import com.example.common.bean.User
import com.example.common.utils.SpUtils

/**
 *    author : Bin
 *    date   : 2022/1/1314:51
 *    desc   : 用户管理类
 */
object UserManager {

    private const val USER_DATA: String = "user_data"

    private val liveDataUserInfo = MutableLiveData<User>()

    fun getLoginLiveData(): MutableLiveData<User> {
        return liveDataUserInfo
    }

    fun getUser(): User? {
        return SpUtils.getParcelable(USER_DATA)
    }

    fun saveUser(user: User) {
        SpUtils.put(USER_DATA, user)
        if (liveDataUserInfo.hasObservers()) {
            liveDataUserInfo.postValue(user)
        }
    }

    fun isLogin(): Boolean {
        return getUser() != null
    }

    fun removeUser() {
        SpUtils.removeKey(USER_DATA)
    }
}