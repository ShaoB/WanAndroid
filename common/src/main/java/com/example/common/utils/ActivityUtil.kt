package com.example.common.utils

import android.app.Activity
import java.lang.IllegalArgumentException

/**
 *    author : Bin
 *    date   : 2022/1/1110:03
 *    desc   : Activity管理类
 */
object ActivityUtil {

    var mActivities = arrayListOf<Activity>()

    /**
     * 添加 Activity
     */
    fun addActivity(activity: Activity) {
        if (!mActivities.contains(activity)) {
            mActivities.add(activity)
        }
    }

    /**
     * 移除 Activity
     */
    fun removeActivity(activity: Activity) {
        if (mActivities.contains(activity)) {
            mActivities.remove(activity)
        }
    }

    /**
     * 获取栈顶Activity
     */
    fun getStackToAct(): Activity {
        if (mActivities.isEmpty()) {
            throw IllegalArgumentException("没有找到 Activity")
        }
        return mActivities[mActivities.size - 1]
    }

    /**
     * 结束所有 Activity
     */
    fun finishAllActivity() {
        mActivities.forEach {
            if (!it.isFinishing) {
                it.finish()
            }
        }
    }
}