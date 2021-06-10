package com.sssakib.kotlinloginsession

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {

    lateinit var myRunnable: Runnable
    private var myHandler = Handler()
    val DISCONNECT_TIMEOUT: Long = 20000


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        val mReceiver: BroadcastReceiver = ScreenReceiver()
        registerReceiver(mReceiver, filter)

        btnGoToDemo.setOnClickListener {

            val i = Intent(this, DemoActivity::class.java)
            startActivity(i)
           stop()

        }
        myRunnable = Runnable {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        onResume()


    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        onPause()
        onResume()
    }

    override fun onPause() {
        if (!ScreenReceiver.wasScreenOn) {
            System.out.println("Screen OFFFFFFFFFFFFFFFFFFFFFFFFFF")
            start()
        } else {
            stop()
        }
        super.onPause()
    }


    override fun onResume() {

        super.onResume()
        start()
    }
    override fun onStop() {
        start()
        super.onStop()
    }



    override fun onBackPressed() {

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        stop()
    }

    fun start() {
        myHandler.postDelayed(myRunnable, DISCONNECT_TIMEOUT)
    }

    fun stop() {
        myHandler.removeCallbacks(myRunnable)
    }


}