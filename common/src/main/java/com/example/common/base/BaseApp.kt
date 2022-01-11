package com.example.common.base

import android.app.Application

/**
 *    author : Bin
 *    date   : 2022/1/1017:43
 *    desc   :
 */
open class BaseApp : Application() {

    companion object {
        private lateinit var instance: Application
        fun getInstance(): Application {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}