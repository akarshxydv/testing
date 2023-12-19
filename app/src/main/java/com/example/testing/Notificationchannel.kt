package com.example.testing

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class Notificationchannel: Application() {
companion object{
    var channel_id="notify_channel"
}

    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                var ChannelName="Testing Channel"
            var discription="Notification Shown"
            var importance=NotificationManager.IMPORTANCE_DEFAULT
            var channel= NotificationChannel(channel_id,ChannelName,importance).apply {
                discription=discription
            }
            var notificationManager: NotificationManager =getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

    }


}