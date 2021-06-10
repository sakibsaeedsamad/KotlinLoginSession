package com.sssakib.kotlinloginsession

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ScreenReceiver : BroadcastReceiver() {

    companion object{
        var wasScreenOn = true
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            wasScreenOn = false
        } else if (intent.action == Intent.ACTION_SCREEN_ON) {
            wasScreenOn = true
        }
    }


}