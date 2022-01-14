package com.example.common.view

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.common.R
import com.example.common.databinding.LayoutLoadingViewBinding

/**
 *    author : Bin
 *    date   : 2022/1/119:29
 *    desc   : 加载框
 */
class LoadingDialog(context: Context) : Dialog(context, R.style.LoadingDialog) {

    private var loadingDialog: LoadingDialog? = null

    init {
        val binding = LayoutLoadingViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rotateAnimation = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimation.duration = 2000
        rotateAnimation.repeatCount = 10
        rotateAnimation.fillAfter = true

        binding.ivImage.startAnimation(rotateAnimation)
    }

    fun showDialog(context: Context) {
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(context)
        }
        loadingDialog?.show()
    }

    fun dismissDialog() {
        loadingDialog?.dismiss()
    }
}