package com.example.common.route

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.example.common.bean.User

/**
 *    author : Bin
 *    date   : 2022/1/1217:24
 *    desc   : 路由跳转,通过依赖注入解耦:服务管理 暴露服务
 */
// 声明登录模块接口,其他组件通过接口来调用服务
interface LoginService : IProvider {

    /**
     * 是否登录
     */
    fun isLogin() : Boolean

    /**
     * 获取用户信息
     */
    fun getUserInfo() : User?

    /**
     * 移除用户信息
     */
    fun removeUserInfo()

    /**
     * 跳转 登录页面
     */
    fun startLoginActivity(context: Context)

    fun getLiveData(): LiveData<User>
}