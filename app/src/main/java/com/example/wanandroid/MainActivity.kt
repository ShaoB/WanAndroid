package com.example.wanandroid

import android.os.Bundle
import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import com.example.common.base.BaseVMActivity
import com.example.common.utils.FixFragmentNavigator
import com.example.home.ui.FaqFragment
import com.example.home.ui.HomeFragment
import com.example.user.ui.UserFragment
import com.example.wanandroid.databinding.ActivityMainBinding
import com.example.wanandroid.ui.notifications.NotificationsFragment

class MainActivity : BaseVMActivity<ActivityMainBinding>() {

    /*private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }*/

    private var navController: NavController? = null

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    private fun setupBottomNavigationBar() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav) as NavHostFragment
        navController = navHostFragment.navController
        //创建自定义的Fragment导航器
        val fragmentNavigator =
            FixFragmentNavigator(this, navHostFragment.childFragmentManager, navHostFragment.id)
        //获取导航器提供者
        val provider = navController!!.navigatorProvider
        //把自定义的Fragment导航器添加进去
        provider.addNavigator(fragmentNavigator)
        //手动创建导航图
        val navGraph = initNavGraph(provider, fragmentNavigator)
        //设置导航图
        navController!!.graph = navGraph

//        NavigationUI.setupWithNavController(mBinding.bottomNav, navController)
        //底部导航设置点击事件
        mBinding.bottomNav.setOnNavigationItemSelectedListener { item ->
            navController!!.navigate(item.itemId)
            true
        }
    }

    //手动创建导航图，把3个目的地添加进来
    private fun initNavGraph(
        provider: NavigatorProvider,
        fragmentNavigator: FixFragmentNavigator
    ): NavGraph {
        val navGraph = NavGraph(NavGraphNavigator(provider))
        //用自定义的导航器来创建目的地
        val destination1 = fragmentNavigator.createDestination()
        destination1.id = R.id.navigation_home
        destination1.className = HomeFragment::class.java.canonicalName ?: "home_fragment"
        destination1.label = resources.getString(R.string.title_home)
        navGraph.addDestination(destination1)

        val destination2 = fragmentNavigator.createDestination()
        destination2.id = R.id.navigation_faq
        destination2.className = FaqFragment::class.java.canonicalName ?: "faq_fragment"
        destination2.label = resources.getString(R.string.title_faq)
        navGraph.addDestination(destination2)

        val destination3 = fragmentNavigator.createDestination()
        destination3.id = R.id.navigation_notifications
        destination3.className =
            NotificationsFragment::class.java.canonicalName ?: "notifications_fragment"
        destination3.label = resources.getString(R.string.title_notifications)
        navGraph.addDestination(destination3)

        val userDestination = fragmentNavigator.createDestination()
        userDestination.id = R.id.navigation_user
        userDestination.className = UserFragment::class.java.canonicalName ?: "user_fragment"
        userDestination.label = resources.getString(R.string.title_user)
        navGraph.addDestination(userDestination)

        navGraph.startDestination = R.id.navigation_home
        return navGraph
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onBackPressed() {
        val currentId: Int = navController?.currentDestination!!.id
        val startId: Int = navController?.graph!!.startDestination
        //如果当前目的地不是HomeFragment，则先回到HomeFragment
        if (currentId != startId) {
            mBinding.bottomNav.selectedItemId = startId
        } else {
            finish()
        }
    }
}