package com.sssakib.kotlinloginsession

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logInButton.setOnClickListener {
            val mobile = "01933575667"//mobileLogIn!!.text.toString().trim { it <= ' ' }
            val password = "123456"//passwordLogIn!!.text.toString().trim { it <= ' ' }

            if (mobile.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please give Mobile and Password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                if ("01933575667" == mobile && "123456" == password) {
                    val i = Intent(this@MainActivity, WelcomeActivity::class.java)

                    startActivity(i)
                    cleanFields()
                }
                else{
                    Toast.makeText(
                        applicationContext,
                        "Mobile and Password does not match.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun cleanFields() {
        mobileLogIn!!.text = null
        passwordLogIn!!.text = null
    }

    override fun onBackPressed() {
        finishAffinity()
        finish()
    }
}