package com.hmzdtz.libandroidlearn.base

import android.app.Application
import android.content.res.Configuration
import com.hmzdtz.libandroidlearn.util.LogUtil

class BaseApplication : Application() {
    companion object {
        val TAG: String = this::class.java.simpleName
    }

    override fun onCreate() {
        LogUtil.i(TAG, "onCreate, hashCode: ${hashCode()}")
        super.onCreate()
    }

    override fun onTerminate() {
        LogUtil.i(TAG, "onTerminate, hashCode: ${hashCode()}")
        super.onTerminate()
    }

    override fun onTrimMemory(level: Int) {
        LogUtil.i(TAG, "onTrimMemory, level: $level")
        super.onTrimMemory(level)
    }

    override fun onLowMemory() {
        LogUtil.i(TAG, "onLowMemory")
        super.onLowMemory()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        LogUtil.i(TAG, "onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
    }
}