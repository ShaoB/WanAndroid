package com.example.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.home.bean.ArticleBean

/**
 *    author : Bin
 *    date   : 2022/1/1516:00
 *    desc   :
 */
class ArticleDiffCallback : DiffUtil.ItemCallback<ArticleBean>() {

    /**
     * 判断是否是同一个item
     */
    override fun areItemsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * 当是同一个item时，再判断内容是否发生改变
     */
    override fun areContentsTheSame(oldItem: ArticleBean, newItem: ArticleBean): Boolean {
        return oldItem.collect == newItem.collect && oldItem.title == newItem.title
    }

    /**
     * 可选实现
     * 如果需要精确修改某一个view中的内容，请实现此方法。
     * 如果不实现此方法，或者返回null，将会直接刷新整个item。
     */
    override fun getChangePayload(oldItem: ArticleBean, newItem: ArticleBean): Any? {
        return null
    }
}