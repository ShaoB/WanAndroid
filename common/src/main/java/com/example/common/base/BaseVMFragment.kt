package com.example.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.common.R
import com.example.common.utils.getResString

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

    /**
     * 空数据 view
     */
    fun getMsgEmptyDataView(
        parent: RecyclerView,
        msg: String? = R.string.base_no_data.getResString()
    ): View {
        val noDataView = layoutInflater.inflate(R.layout.empty_view, parent, false)
        noDataView.findViewById<TextView>(R.id.tv_no_data).text = msg
        return noDataView
    }

    /**
     * 错误数据 view
     */
    fun getErrorEmptyDataView(
        parent: RecyclerView,
        msg: String? = R.string.base_no_data.getResString()
    ): View {
        val errorView = layoutInflater.inflate(R.layout.error_view, parent, false)
        errorView.findViewById<TextView>(R.id.tv_error_msg).text = msg
        return errorView
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding.unbind()
    }
}