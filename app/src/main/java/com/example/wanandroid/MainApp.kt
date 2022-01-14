package com.example.wanandroid

import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.BuildConfig
import com.blankj.utilcode.util.LogUtils
import com.example.common.base.BaseApp
import com.example.wanandroid.app.appModule
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 *    author : Bin
 *    date   : 2022/1/1017:42
 *    desc   :
 */
class MainApp : BaseApp() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        MMKV.initialize(this)

        startKoin{
            androidContext(this@MainApp)
            modules(appModule)
        }

        LogUtils.eTag("Application", "初始化")
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (BuildConfig.DEBUG) {
            ARouter.openLog()// 打印日志
            ARouter.openDebug()// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)/* 尽可能早，推荐在Application中初始化 */
    }
}