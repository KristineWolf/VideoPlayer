package com.mastercode.videoplayerapp

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayVideoInRawFolder()
        displayVideosFromInternet()
    }

    private fun displayVideosFromInternet() {
        val videoView: VideoView = findViewById(R.id.video_view_two)

        val uri: Uri = Uri.parse("https://static.videezy.com/system/resources/previews/000/002/231/original/5226496.mp4")
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }

    private fun displayVideoInRawFolder() {
        val videoView: VideoView = findViewById(R.id.video_view_one)
        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.mountains)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.start()
    }
}