package com.hmzdtz.androidlearn

import android.os.Bundle
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hmzdtz.libandroidlearn.util.LogUtil
import tv.danmaku.ijk.media.videoview.IjkVideoView

class VideoActivity : AppCompatActivity() {
    companion object {
        const val TAG = "VideoActivity"
    }

    val videoView: IjkVideoView by lazy {
        findViewById(R.id.video)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_video)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        videoView.setOnPreparedListener {
            LogUtil.i(TAG, "onPrepared")
        }

        videoView.setOnCompletionListener {
            LogUtil.i(TAG, "onCompletion")
        }

        videoView.setOnErrorListener { p0, p1 ->
            LogUtil.i(TAG, "onError")
            false
        }
        videoView.setVideoURI("https://baikevideo.cdn.bcebos.com/media/mda-Ogecg9gVColin1F7/1170461607bb2f3a1b517726a531a378.mp4".toUri())
        videoView.start()
        LogUtil.i(TAG, "start")

        val video = VideoView(this)
    }
}