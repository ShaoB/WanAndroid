package com.example.common.utils

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.common.base.BaseApp

/**
 *    author : Bin
 *    date   : 2022/1/1510:38
 *    desc   :
 */

fun Int.getDrawable() = ActivityCompat.getDrawable(BaseApp.getInstance(), this)

fun Int.getResColor() = ContextCompat.getColor(BaseApp.getInstance(), this)

fun Int.getResString() = BaseApp.getInstance().getString(this)