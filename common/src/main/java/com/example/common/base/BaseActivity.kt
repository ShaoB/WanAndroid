package com.example.common.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.common.utils.ActivityUtil
import com.example.common.utils.StatusBarUtil
import com.example.common.view.LoadingDialog

open class BaseActivity : AppCompatActivity() {

    private lateinit var mLoadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoadingDialog = LoadingDialog(this)

        ActivityUtil.addActivity(this)

        //设置透明状态栏
        StatusBarUtil.setTransparentForWindow(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityUtil.removeActivity(this)
    }

    fun showLoading() {
        mLoadingDialog.showDialog(this)
    }

    fun dismissLoading() {
        mLoadingDialog.dismissDialog()
    }
}