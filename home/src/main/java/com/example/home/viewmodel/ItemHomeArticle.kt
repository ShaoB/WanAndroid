package com.example.home.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.home.bean.ArticleBean

/**
 *    author : Bin
 *    date   : 2022/1/1513:38
 *    desc   :
 */
class ItemHomeArticle(private val bean: ArticleBean) {

    var title = ObservableField("")

    var time = ObservableField("")

    var collect = ObservableBoolean()
        set(value) {
            bean.collect = value.get()
            field = value
        }

    var author = ObservableField("")

    var category = ObservableField("")

    init {
        title.set(bean.title)
        time.set(bean.niceDate)
        author.set(
            if (!bean.author.isNullOrEmpty()) {
                "作者：${bean.author}"
            } else {
                "分享人：${bean.shareUser}"
            }
        )
        category.set("分类：${bean.superChapterName}")
        collect.set(bean.collect)
    }
    /*fun bingData(bean: ArticleBean) {
        title.set(bean.title)
        time.set(bean.niceDate)
        author.set(
            if (!bean.author.isNullOrEmpty()) {
                "作者：${bean.author}"
            } else {
                "分享人：${bean.shareUser}"
            }
        )
        category.set("分类：$bean.superChapterName")
        collect.set(bean.collect)
    }*/
}