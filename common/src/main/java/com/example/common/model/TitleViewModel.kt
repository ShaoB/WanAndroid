package com.example.common.model

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import com.example.common.R
import com.example.common.utils.getDrawable
import com.example.common.utils.getResColor

/**
 *    author : Bin
 *    date   : 2022/1/1510:34
 *    desc   : 公共头部
 */
class TitleViewModel(
    var leftText: String? = "",
    var leftDrawable: Drawable? = R.drawable.abc_vector_test.getDrawable(),
    var leftAction: (() -> Unit)? = null,
    var title: String = "",
    var rightText: String = "",
    var rightDrawable: Drawable? = null,
    var rightAction: (() -> Unit)? = null,
    var background: Int = R.color.theme.getResColor()
) {
    val mTitle = ObservableField(title)
    val mRightDrawable = ObservableField(rightDrawable)
}