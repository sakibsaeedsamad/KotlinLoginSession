package com.sssakib.kotlinloginsession

import android.content.*
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.PowerManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {
    var handler: Handler? = null
    var r: Runnable? = null
    val DISCONNECT_TIMEOUT: Long = 30000

    @RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)



        val intentFilter = IntentFilter(Intent.ACTION_SCREEN_ON)
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent) {
                if (intent.action == Intent.ACTION_SCREEN_OFF) {
                   // Log.d(ContentValues.TAG, Intent.ACTION_SCREEN_OFF)
                    onPause()
                } else if (intent.action == Intent.ACTION_SCREEN_ON) {
                    Log.d(ContentValues.TAG, Intent.ACTION_SCREEN_ON)
                }
            }
        }, intentFilter)

        btnGoToDemo.setOnClickListener {
            val i = Intent(this, DemoActivity::class.java)
            startActivity(i)
            onStop()
        }
        handler = Handler()
        r = Runnable { // TODO Auto-generated method stub
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        onResume()
    }

    override fun onUserInteraction() {
        // TODO Auto-generated method stub
        super.onUserInteraction()
        onResume()
    }


    public override fun onResume() {
        super.onResume()
        resetDisconnectTimer()
    }

    override fun onStop() {
        super.onStop()
        stopDisconnectTimer()
    }


    override fun onPause() {

        super.onPause()
        resetDisconnectTimer()

    }


    fun resetDisconnectTimer() {
        handler?.removeCallbacks(r!!)
        handler?.postDelayed(r!!, DISCONNECT_TIMEOUT)
    }

    fun stopDisconnectTimer() {
        handler?.removeCallbacks(r!!)
    }


    override fun onBackPressed() {
        onStop()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


}