package com.example.home.di

import com.example.home.api.HomeApi
import com.example.home.repo.HomeRepo
import com.example.home.viewmodel.FaqModel
import com.example.home.viewmodel.ItemHomeArticle
import com.example.net.net.RetrofitManager
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *    author : Bin
 *    date   : 2022/1/1511:18
 *    desc   :
 */
val homeModels = module {

    single {
        RetrofitManager.instance.create(HomeApi::class.java)
    }

    single {
        HomeRepo(get())
    }

    viewModel {
        FaqModel(androidApplication(), get())
    }
}