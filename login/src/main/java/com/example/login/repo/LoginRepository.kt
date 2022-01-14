package com.example.login.repo

import com.example.common.bean.User
import com.example.common.rository.BaseRepository
import com.example.common.rository.StateLiveData
import com.example.login.api.LoginApi

/**
 *    author : Bin
 *    date   : 2022/1/1415:14
 *    desc   :
 */
class LoginRepository(private val service: LoginApi) : BaseRepository() {

    /**
     * 登录
     */
    suspend fun login(userName: String, password: String, result: StateLiveData<User>) {
        executeRequest({ service.login(userName, password) }, result)
    }
}