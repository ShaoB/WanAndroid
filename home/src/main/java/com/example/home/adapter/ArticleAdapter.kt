package com.example.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.home.R
import com.example.home.bean.ArticleBean
import com.example.home.databinding.ItemHomeArticleBinding
import com.example.home.viewmodel.ItemHomeArticle

/**
 *    author : Bin
 *    date   : 2022/1/1511:30
 *    desc   : 文章 adapter
 */
class ArticleAdapter(articleList: MutableList<ArticleBean>) :
    BaseQuickAdapter<ArticleBean, BaseDataBindingHolder<ItemHomeArticleBinding>>(
        R.layout.item_home_article, articleList
    ) {

    override fun convert(holder: BaseDataBindingHolder<ItemHomeArticleBinding>, item: ArticleBean) {
        val dataBinding = holder.dataBinding
        dataBinding?.item = ItemHomeArticle(item)
        addChildClickViewIds(R.id.iv_collect)
    }
}