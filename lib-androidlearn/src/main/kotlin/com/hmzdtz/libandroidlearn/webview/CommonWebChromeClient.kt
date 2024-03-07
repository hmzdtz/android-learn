package com.hmzdtz.libandroidlearn.webview

import android.webkit.ConsoleMessage
import android.webkit.ConsoleMessage.MessageLevel
import android.webkit.WebChromeClient
import com.hmzdtz.libandroidlearn.util.LogUtil

class CommonWebChromeClient() : WebChromeClient() {
    companion object {
        val TAG: String = this::class.java.simpleName
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
        when (consoleMessage.messageLevel()) {
            MessageLevel.LOG -> {
                LogUtil.i(TAG, consoleMessage.message())
            }

            MessageLevel.DEBUG -> {
                LogUtil.d(TAG, consoleMessage.message())
            }

            MessageLevel.WARNING -> {
                LogUtil.w(TAG, consoleMessage.message())
            }

            MessageLevel.ERROR -> {
                LogUtil.e(TAG, consoleMessage.message())
            }

            else -> {
            }
        }
        return super.onConsoleMessage(consoleMessage)
    }
}