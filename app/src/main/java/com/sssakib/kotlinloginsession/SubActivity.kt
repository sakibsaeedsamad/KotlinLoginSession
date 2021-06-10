package com.sssakib.kotlinloginsession

import android.content.*
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

//No need for this function
open class SubActivity : AppCompatActivity() {
    var myRunnable: Runnable
    private var myHandler = Handler()
    val DISCONNECT_TIMEOUT: Long = 10000

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
//        registerReceiver(object : BroadcastReceiver() {
//            override fun onReceive(context: Context?, intent: Intent) {
//                if (intent.action == Intent.ACTION_SCREEN_OFF) {
//                    start()
//                }
//            }
//        }, intentFilter)
//    }

    init {
        myRunnable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }


    override fun onUserInteraction() {
        super.onUserInteraction();
        stop()
        start()
    }

    override fun onPause() {
        super.onPause()
        stop()
    }

    override fun onResume() {
        super.onResume()
        start()
    }

    fun start() {
        myHandler.postDelayed(myRunnable, DISCONNECT_TIMEOUT)
    }

    fun stop() {
        myHandler.removeCallbacks(myRunnable)
    }
}