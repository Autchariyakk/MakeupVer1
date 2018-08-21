package com.autchariya.kiklik.makeuptutorial4.style

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.autchariya.kiklik.makeuptutorial4.R
//import com.autchariya.kiklik.makeuptutorial4.database.AppDatabase
//import com.autchariya.kiklik.makeuptutorial4.utils.DatabaseInitializer
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_video_tutorial.*

class VideoTutorial : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {

//    private var mDb: AppDatabase? = null

    private val playbackEventListener = object : YouTubePlayer.PlaybackEventListener {
        override fun onBuffering(arg0: Boolean) {}
        override fun onPaused() {}
        override fun onPlaying() {}
        override fun onSeekTo(arg0: Int) {}
        override fun onStopped() {}
    }

    private val playerStateChangeListener = object : YouTubePlayer.PlayerStateChangeListener {
        override fun onAdStarted() {}
        override fun onError(arg0: YouTubePlayer.ErrorReason) {}
        override fun onLoaded(arg0: String) {}
        override fun onLoading() {}
        override fun onVideoEnded() {}
        override fun onVideoStarted() {}
    }

        lateinit var res : String
    lateinit var i : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_tutorial)

        val bundle = intent.extras
        if (bundle != null) {
            res = bundle.getString("value1")
        }

        toolbar_video.setNavigationOnClickListener { finish() }

        val youTubePlayerView = findViewById<View>(R.id.youtube_player) as YouTubePlayerView
        youTubePlayerView.initialize(API_KEY, this)

//        mDb = AppDatabase.getAppDatabase(this)

//        btn_click.setOnClickListener { (AppDatabase.getAppDatabase(this)!!)  }
//        btn_click.setOnClickListener({ view -> DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this)!!) }
//        )



    }

//    override fun onDestroy() {
//        AppDatabase.destroyInstance()
//        super.onDestroy()
//    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider, result: YouTubeInitializationResult) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show()
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {
        /** add listeners to YouTubePlayer instance  */
        player.setPlayerStateChangeListener(playerStateChangeListener)
        player.setPlaybackEventListener(playbackEventListener)

        /** Start buffering  */
        if (!wasRestored) {
            player.cueVideo(res)
        }
    }

    companion object {

        val API_KEY = "AIzaSyB9NNsZA0X3oom3rPbkE5U7hFi8gZcIMVE"
//        var VIDEO_ID = "WpL4dhNwuc8"

    }
    }

