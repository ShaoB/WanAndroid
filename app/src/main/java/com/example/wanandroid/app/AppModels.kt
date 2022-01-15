package com.example.wanandroid.app

import com.example.home.di.homeModels
import com.example.home.viewmodel.FaqModel
import com.example.login.di.loginModel
import okhttp3.internal.immutableListOf

/**
 *    author : Bin
 *    date   : 2022/1/1316:15
 *    desc   :
 */

val appModule = immutableListOf(loginModel, homeModels)