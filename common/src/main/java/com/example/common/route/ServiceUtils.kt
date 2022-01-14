package com.example.common.route

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.bean.User

/**
 *    author : Bin
 *    date   : 2022/1/1310:59
 *    desc   :
 */
class LoginServiceUtils {

    companion object {


        fun isLogin(): Boolean {
            return ARouter.getInstance().navigation(LoginService::class.java).isLogin()
        }

        fun getUserInfo(): User? {
            return ARouter.getInstance().navigation(LoginService::class.java).getUserInfo()
        }

        fun removeUserInfo() {
            ARouter.getInstance().navigation(LoginService::class.java).removeUserInfo()
        }

        fun startLoginActivity(context: Context) {
            ARouter.getInstance().navigation(LoginService::class.java).startLoginActivity(context)
        }

        fun getLiveData(): LiveData<User> {
            return ARouter.getInstance().navigation(LoginService::class.java).getLiveData()
        }
    }
}