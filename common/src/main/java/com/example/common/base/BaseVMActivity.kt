package com.example.common.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *    author : Bin
 *    date   : 2022/1/1110:27
 *    desc   : 这里只传入 dataBinding 是由于 viewModel要使用的话 可以直接通过koin注解
 */
abstract class BaseVMActivity<T : ViewDataBinding> : BaseActivity() {

    lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.lifecycleOwner = this
        initView(savedInstanceState)
        initListener()
        initData()
        startObserver()
    }

    /**
     * 对应布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化事件
     */
    open fun initListener() {}

    /**
     * 初始化数据
     */
    open fun initData() {}

    /**
     * 监听
     */
    open fun startObserver() {}

    override fun onDestroy() {
        super.onDestroy()
        //解绑
        mBinding.unbind()
    }

}