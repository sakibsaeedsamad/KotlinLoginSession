package com.sssakib.kotlinloginsession

import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : SubActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)



        btnGoToWelcome.setOnClickListener {
            finish()
            val i = Intent(this, WelcomeActivity::class.java)
            startActivity(i)

        }
    }


    override fun onBackPressed() {

        finish()

        val i = Intent(this, WelcomeActivity::class.java)

        startActivity(i)
    }
}