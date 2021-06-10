package com.sssakib.kotlinloginsession

import android.content.*
import android.content.Intent.ACTION_SCREEN_ON
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

//No need for this function
open class SubActivity : AppCompatActivity() {
    var myRunnable: Runnable
    private var myHandler = Handler()
    val DISCONNECT_TIMEOUT: Long = 20000

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
//
//        System.out.println("SubActivity Oncreate Called")
//    }

    init {
        myRunnable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }


    }


    override fun onUserInteraction() {
        super.onUserInteraction();
        onPause()
        onResume()
    }

    override fun onPause() {

        stop()

        val intentFilter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                if (intent.action == Intent.ACTION_SCREEN_OFF) {
                    start()
                }
}
        }, intentFilter)

        super.onPause()


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