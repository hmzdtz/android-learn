package com.hmzdtz.androidlearn

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import com.github.lzyzsd.jsbridge.BridgeWebView
import com.github.lzyzsd.jsbridge.BridgeWebViewClient
import com.hmzdtz.libandroidlearn.util.LogUtil
import com.hmzdtz.libandroidlearn.webview.CommonWebChromeClient

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    val webView: BridgeWebView by lazy {
        findViewById(R.id.web_view)
    }

    var webUrl: String = ""
        set(value) {
            field = value
            webView.loadUrl(value)
        }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        webView.webChromeClient = CommonWebChromeClient()

        val settings = webView.settings
        settings.apply {
            javaScriptEnabled = true
            databaseEnabled = true
            domStorageEnabled = true
        }

        webView.webViewClient = object : BridgeWebViewClient(webView) {
            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                LogUtil.i(TAG, "onPageStarted, url: $url, favicon: $favicon")
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                LogUtil.i(TAG, "onPageFinished, url: $url")
            }

            override fun onReceivedError(
                view: WebView, request: WebResourceRequest, error: WebResourceError
            ) {
                super.onReceivedError(view, request, error)
                LogUtil.e(TAG, "onReceivedError, ${error.errorCode} ${error.description}")
            }

            override fun onReceivedHttpError(
                view: WebView,
                request: WebResourceRequest,
                errorResponse: WebResourceResponse
            ) {
                super.onReceivedHttpError(view, request, errorResponse)
                LogUtil.e(
                    TAG,
                    "onReceivedHttpError, ${request.url}" +
                            " ${errorResponse.statusCode} ${errorResponse.reasonPhrase}"
                )
            }

            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                LogUtil.i(TAG, "shouldOverrideUrlLoading: ${request.url}")
                return false
            }

            override fun shouldInterceptRequest(
                view: WebView,
                request: WebResourceRequest
            ): WebResourceResponse? {
                return super.shouldInterceptRequest(view, request)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWebView()
    }
}