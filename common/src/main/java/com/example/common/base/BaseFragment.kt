package com.example.common.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.common.view.LoadingDialog

/**
 *    author : Bin
 *    date   : 2022/1/1216:49
 *    desc   : fragment 基类
 */
abstract class BaseFragment : Fragment() {

    private lateinit var mLoadingDialog: LoadingDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * show 加载中
     */
    fun showLoading() {
        mLoadingDialog.showDialog(requireContext())
    }

    /**
     * dismiss loading dialog
     */
    fun dismissLoading() {
        mLoadingDialog.dismissDialog()
    }
}