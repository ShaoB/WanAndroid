package com.example.login.route

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common.bean.User
import com.example.common.route.LoginService
import com.example.login.ui.LoginActivity
import com.example.login.utils.UserManager

/**
 *    author : Bin
 *    date   : 2022/1/1314:49
 *    desc   :
 */
// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = "/login/login", name = "登录服务")
class LoginServiceImpl : LoginService {

    override fun isLogin(): Boolean {
        return UserManager.isLogin()
    }

    override fun getUserInfo(): User? {
        return UserManager.getUser()
    }

    override fun removeUserInfo() {
        UserManager.removeUser()
    }

    override fun startLoginActivity(context: Context) {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

    override fun getLiveData(): LiveData<User> {
        return UserManager.getLoginLiveData()
    }

    override fun init(context: Context?) {

    }
}