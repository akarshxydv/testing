package com.example.testing

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    var songl =
        "https://pub-172b4845a7e24a16956308706aaf24c2.r2.dev/french-song-about-brittany-136020.mp3"
    var song =
        "https://pub-172b4845a7e24a16956308706aaf24c2.r2.dev/ uplifting-corporate-pop-rock-it-is-time-113871.mp3"
    private lateinit var mediaPlayer: MediaPlayer
var notification_id=101
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //  setting clicklistner for save pdf
        var btn:Button=findViewById(R.id.btn)

        btn.setOnClickListener(){
            sendNotification()
        }



    }
    private fun sendNotification(){
        val builder=NotificationCompat.Builder(this,Notificationchannel.channel_id)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Test Notification")
            .setContentText("Notification Discription")
        with(NotificationManagerCompat.from(this@MainActivity)){
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {



            }
            notify(notification_id,builder.build())

        }
    }

}














        //var song="https://pub-172b4845a7e24a16956308706aaf24c2.r2.dev/uplifting-corporate-pop-rock-it-is-time-113871.mp3"
//var brn:Button=findViewById(R.id.btn)
//brn.setOnClickListener(){
//
//    CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val mediaPlayer = prepareMediaPlayer()
//            mediaPlayer?.start()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            showErrorMessage("Error: Invalid or unauthorized URL")
//        }
//    }
//}
//    }
//
//    private suspend fun prepareMediaPlayer(): MediaPlayer? {
//        return withContext(Dispatchers.IO) {
//            if (isURLValid(song)) {
//                val mediaPlayer = MediaPlayer()
//                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
//                var songM=song.replace(" ","")
//                mediaPlayer.setDataSource(songM)
//                mediaPlayer.prepare()
//                mediaPlayer.setOnPreparedListener {
//                    val duration = it.duration
//
//                }
//                mediaPlayer
//            } else {
//                throw IOException("Invalid or unauthorized URL")
//            }
//        }
//    }
//
//    private fun isURLValid(url: String): Boolean {
//        // Perform URL validation here (e.g., check for HTTP status code)
//        return true // Replace with your URL validation logic
//    }
//
//
//
//    private fun showErrorMessage(message: String) {
//        runOnUiThread {
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//        }
//    }
//}