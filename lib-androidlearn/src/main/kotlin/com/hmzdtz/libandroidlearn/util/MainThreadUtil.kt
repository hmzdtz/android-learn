package com.hmzdtz.libandroidlearn.util

import android.os.Handler
import android.os.Looper

object MainThreadUtil {
    private val handler: Handler by lazy {
        Handler(Looper.getMainLooper())
    }

    @JvmStatic
    fun handler(): Handler {
        return handler
    }

    @JvmStatic
    fun isUiThread(): Boolean {
        return Looper.getMainLooper().thread === Thread.currentThread()
    }

    @JvmStatic
    fun post(runnable: Runnable) {
        handler.post(runnable)
    }

    @JvmStatic
    fun run(runnable: Runnable) {
        if (isUiThread()) {
            runnable.run()
        } else {
            post(runnable)
        }
    }
}
