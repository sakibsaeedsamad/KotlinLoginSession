package com.sssakib.kotlinloginsession

import android.content.*
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : SubActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)





        btnGoToDemo.setOnClickListener {
            finish()
            val i = Intent(this, DemoActivity::class.java)
            startActivity(i)

        }
    }

    override fun onBackPressed() {
        finish()
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


}