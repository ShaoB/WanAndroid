package com.example.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 *    author : Bin
 *    date   : 2022/1/1216:50
 *    desc   :
 */
abstract class BaseVMFragment<T : ViewDataBinding> : BaseFragment() {

    lateinit var mBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initListener()
        initData()
        startObserver()
    }

    /**
     * 布局
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    abstract fun initView(view: View)

    /**
     * 初始化监听事件
     */
    open fun initListener() {

    }

    /**
     * 初始化数据
     */
    open fun initData() {

    }

    /**
     * 开始监听
     */
    open fun startObserver() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }
}