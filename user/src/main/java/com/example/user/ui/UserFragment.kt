package com.example.user.ui

import android.view.View
import android.webkit.CookieManager
import com.example.common.base.BaseVMFragment
import com.example.common.route.LoginServiceUtils
import com.example.user.R
import com.example.user.databinding.FragmentUserBinding
import com.example.user.viewmodel.UserItem

/**
 *    author : Bin
 *    date   : 2022/1/1217:04
 *    desc   : 我的页面
 */
class UserFragment : BaseVMFragment<FragmentUserBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_user

    override fun initView(view: View) {
        //绑定数据
        mBinding.userItem = UserItem()

        if (LoginServiceUtils.isLogin()) {
            val userInfo = LoginServiceUtils.getUserInfo()
            userInfo?.username
        } else {
            mBinding.cirUserImg.setBackgroundResource(R.drawable.ic_user_un_authen)
        }


    }

    override fun initListener() {
        super.initListener()

        /**
         * 昵称点击事件
         */
        mBinding.tvUserName.setOnClickListener {
            if (!LoginServiceUtils.isLogin()) {
                LoginServiceUtils.startLoginActivity(requireContext())
            }
        }

        /**
         * 退出登录
         */
        mBinding.tvBtnExitLogin.setOnClickListener {
            CookieManager.getInstance().removeAllCookie()
            LoginServiceUtils.removeUserInfo()
            mBinding.userItem?.refresh()
        }
    }

    override fun startObserver() {
        super.startObserver()

        LoginServiceUtils.getLiveData().observe(this, {
            mBinding.userItem?.refresh()
        })
    }
}