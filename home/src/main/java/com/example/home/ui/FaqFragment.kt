package com.example.home.ui

import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.example.common.base.BaseVMFragment
import com.example.common.route.LoginServiceUtils
import com.example.common.utils.StatusBarUtil
import com.example.common.utils.getResColor
import com.example.home.R
import com.example.home.adapter.ArticleAdapter
import com.example.home.adapter.ArticleDiffCallback
import com.example.home.bean.ArticleBean
import com.example.home.databinding.FragmentFaqBinding
import com.example.home.viewmodel.FaqModel
import com.example.net.model.DataStatus
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *    author : Bin
 *    date   : 2022/1/15 10:10
 *    desc   : 问答
 */
class FaqFragment : BaseVMFragment<FragmentFaqBinding>() {

    private val faqModel: FaqModel by viewModel()

    private val mArticleList: MutableList<ArticleBean> = mutableListOf()

    //当前多少页
    private var mCurrentPosition = 0

    private val mArticleAdapter by lazy {
        ArticleAdapter(mArticleList)
    }

    override fun getLayoutId(): Int = R.layout.fragment_faq

    override fun initView(view: View) {
        StatusBarUtil.setColor(requireActivity(), R.color.theme.getResColor())

        mBinding.vm = faqModel
        faqModel.setTitle("问答")

        initRecycler()
    }

    override fun initData() {
        super.initData()
        getData()
    }

    override fun initListener() {
        super.initListener()
        //下拉刷新
        mBinding.smartRefresh.setOnRefreshListener {
            mCurrentPosition = 0
            getData()
        }

        //上拉加载更多
        mBinding.smartRefresh.setOnLoadMoreListener {
            mCurrentPosition++
            getData()
        }

        //adapter child点击
        mArticleAdapter.setOnItemChildClickListener { adapter, view, position ->
            when (view.id) {
                // 收藏/取消收藏
                R.id.iv_collect -> {
                    if (!LoginServiceUtils.isLogin()) {
                        //没有登录 去登录
                        LoginServiceUtils.startLoginActivity(requireContext())
                        return@setOnItemChildClickListener
                    }
                    val item = mArticleAdapter.getItem(position)
                    if (item.collect) {
                        //取消收藏
                        lifecycleScope.launchWhenCreated {
                            if (faqModel.unCollect(item.id)) {
                                item.collect = false
                                adapter.notifyItemChanged(position)
                                ToastUtils.showShort("取消收藏成功！")
                            } else {
                                ToastUtils.showShort("取消收藏失败！")
                            }
                        }
                    } else {
                        //收藏
                        lifecycleScope.launchWhenCreated {
                            if (faqModel.unCollect(item.id)) {
                                item.collect = true
                                adapter.notifyItemChanged(position)
                                ToastUtils.showShort("收藏成功！")
                            } else {
                                ToastUtils.showShort("收藏失败！")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun startObserver() {
        super.startObserver()
        /**
         * 监听用户信息
         */
        LoginServiceUtils.getLiveData().observe(this, {
            initData()
        })

        /**
         * 监听问答 列表消息
         */
        faqModel.mFaqList.observe(this, {
            when (it.dataStatus) {
                DataStatus.STATE_LOADING -> {
                    if (mCurrentPosition == 0 && !mBinding.smartRefresh.isRefreshing) {
                        showLoading()
                    }
                }
                DataStatus.STATE_SUCCESS -> {
                    finishRefresh()
                    if (mArticleAdapter.hasEmptyView()) mArticleAdapter.removeEmptyView()
                    if (mCurrentPosition == 0) {
                        if (it.data?.datas.isNullOrEmpty()) {
                            //必须要先把数组设置为空
                            mArticleAdapter.setNewInstance(mutableListOf())
                            //如果网络错误了
                            mArticleAdapter.setEmptyView(
                                getMsgEmptyDataView(mBinding.recyclerData)
                            )
                            return@observe
                        }
                        mArticleList.clear()

                    }
                    mArticleList.addAll(it.data?.datas!!)
                    mArticleAdapter.setDiffNewData(mArticleList)
                    mArticleAdapter.notifyDataSetChanged()
                    //判断是否是最后一页
                    if (mCurrentPosition < it.data?.pageCount!!) {
                        mBinding.smartRefresh.finishRefresh()
                        mBinding.smartRefresh.finishLoadMore()
                    } else {
                        mBinding.smartRefresh.finishLoadMoreWithNoMoreData()
                    }
                }
                DataStatus.STATE_ERROR -> {
                    finishRefresh()
                    if (mCurrentPosition == 0) {
                        //必须要先把数组设置为空
                        mArticleAdapter.setNewInstance(mutableListOf())
                        //如果网络错误
                        mArticleAdapter.setEmptyView(
                            getErrorEmptyDataView(
                                mBinding.recyclerData,
                                it.exception?.msg
                            )
                        )
                    }
                }
            }
        })
    }

    private fun initRecycler() {
        mBinding.recyclerData.layoutManager = LinearLayoutManager(requireContext())
        mArticleAdapter.setDiffCallback(ArticleDiffCallback())
        mBinding.recyclerData.adapter = mArticleAdapter
    }

    private fun getData() {
        faqModel.getFaqList(mCurrentPosition)
    }

    private fun finishRefresh() {
        if (mCurrentPosition == 0) {
            if (!mBinding.smartRefresh.isRefreshing) {
                dismissLoading()
            } else {
                mBinding.smartRefresh.finishRefresh()
            }
        }
    }
}