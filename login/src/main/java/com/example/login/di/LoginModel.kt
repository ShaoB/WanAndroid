package com.example.login.di

import com.example.login.api.LoginApi
import com.example.login.repo.LoginRepository
import com.example.login.viewmodel.LoginViewModel
import com.example.net.net.RetrofitManager
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *    author : Bin
 *    date   : 2022/1/1316:15
 *    desc   :
 */
val loginModel = module {

    single {
        RetrofitManager.instance.create(LoginApi::class.java)
    }

    single {
        LoginRepository(get())
    }

    viewModel {
        LoginViewModel(androidApplication(), get())
    }
}