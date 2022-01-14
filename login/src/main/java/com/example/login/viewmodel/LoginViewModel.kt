package com.example.login.viewmodel

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.common.base.BaseViewModel
import com.example.common.bean.User
import com.example.common.rository.StateLiveData
import com.example.login.repo.LoginRepository
import kotlinx.coroutines.launch

/**
 *    author : Bin
 *    date   : 2022/1/1414:35
 *    desc   :
 */
class LoginViewModel(application: Application, private val loginRepository: LoginRepository) :
    BaseViewModel(application) {

    //登录用户
    val mLoginUser = StateLiveData<User>()

    /**
     * 登录
     */
    fun login(userName: String, password: String) {
        viewModelScope.launch {
            loginRepository.login(userName, password, mLoginUser)
        }
    }
}