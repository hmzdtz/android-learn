package com.hmzdtz.libandroidlearn.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hmzdtz.libandroidlearn.util.LogUtil

open class BaseActivity : AppCompatActivity() {
    companion object {
        val TAG: String = this::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.d(
            TAG,
            "onCreate" + if (savedInstanceState != null) " has savedInstanceState" else ""
        )
        super.onCreate(savedInstanceState)
        title = TAG
    }

    override fun onRestart() {
        LogUtil.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onStart() {
        LogUtil.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        LogUtil.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        LogUtil.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        LogUtil.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        LogUtil.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        LogUtil.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        LogUtil.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        LogUtil.d(TAG, "onNewIntent")
        super.onNewIntent(intent)
    }
}
