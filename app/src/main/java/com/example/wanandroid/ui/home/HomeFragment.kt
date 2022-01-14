package com.example.wanandroid.ui.home

import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.base.BaseVMFragment
import com.example.login.ui.LoginActivity
import com.example.wanandroid.R
import com.example.wanandroid.databinding.FragmentHomeBinding

class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initView(view: View) {
        mBinding.textHome.setOnClickListener(View.OnClickListener {
            // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
            ARouter.getInstance().build("/test/activity").navigation()
        })
    }
}