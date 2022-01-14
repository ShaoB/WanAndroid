package com.example.wanandroid

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.LogUtils
import com.example.common.base.BaseVMActivity
import com.example.common.route.LoginServiceUtils
import com.example.wanandroid.databinding.ActivityTestBinding

class TestActivity : BaseVMActivity<ActivityTestBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_test

    override fun initView(savedInstanceState: Bundle?) {

        mBinding.btJump.setOnClickListener {
            ARouter.getInstance().build("/app/mainActivity").navigation()
            /*val navigation = ARouter.getInstance().navigation(LoginService::class.java)
            LogUtils.eTag("是否登录", navigation.isLogin())*/
            LogUtils.eTag("是否登录", LoginServiceUtils.isLogin())
        }
    }
}