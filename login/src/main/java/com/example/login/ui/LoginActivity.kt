package com.example.login.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ToastUtils
import com.example.common.base.BaseVMActivity
import com.example.common.bean.User
import com.example.common.utils.StatusBarUtil
import com.example.login.R
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.model.LoginLayoutBean
import com.example.login.utils.UserManager
import com.example.login.viewmodel.LoginViewModel
import com.example.net.model.BaseResult
import com.example.net.model.DataStatus
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseVMActivity<ActivityLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModel()
    private lateinit var mData: LoginLayoutBean

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        StatusBarUtil.setDarkMode(this)
        mData = LoginLayoutBean()
        mBinding.bean = mData
    }

    override fun initListener() {
        super.initListener()

        mBinding.close.setOnClickListener {
            finish()
        }

        //登录/注册
        mBinding.btnLogin.setOnClickListener {
            if (mData.isLogin) {//登录
                if (getUserName().isEmpty()) {
                    ToastUtils.showShort("账号不能为空")
                    return@setOnClickListener
                }
                if (getPassword().isEmpty()) {
                    ToastUtils.showShort("密码不能为空")
                    return@setOnClickListener
                }
                loginAction()
            }
        }
    }

    override fun initData() {
        super.initData()

    }

    override fun startObserver() {
        super.startObserver()
        loginViewModel.mLoginUser.observe(this, {
            handleResult(it)
        })
    }

    private fun getUserName(): String {
        return mBinding.userName.text.toString().trim()
    }

    private fun getPassword(): String {
        return mBinding.password.text.toString().trim()
    }

    /**
     * 登录
     */
    private fun loginAction() {
        loginViewModel.login(getUserName(), getPassword())
    }

    /**
     * 处理结果
     */
    private fun handleResult(it: BaseResult<User>) {
        when (it.dataStatus) {
            DataStatus.STATE_LOADING ->
                showLoading()
            DataStatus.STATE_ERROR -> {
                dismissLoading()
                ToastUtils.showShort(it.exception!!.msg)
            }
            DataStatus.STATE_SUCCESS -> {
                dismissLoading()
                it.data?.let { userInfo -> saveUser(userInfo) }
            }
        }
    }

    /**
     * 保存用户信息
     */
    private fun saveUser(data: User) {
        UserManager.saveUser(data)
        finish()
    }
}