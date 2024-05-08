package com.example.act_0508.example1

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.example.act_0508.R
import com.example.act_0508.example1.createPendingIntent
import com.example.week10.R

fun makeNotification(context: Context, msg: String) {
    val pendingIntent = createPendingIntent(context, msg)

    val channelId = "MyChanne"
    val channelName = "TimeCheckChannel"
    val notificationId = 0

    val notificationChannel =
        NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)

    val notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager // service를 manager로 형변환
    notificationManager.createNotificationChannel(notificationChannel)

    val notification = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.baseline_access_alarms_24)//
        .setContentTitle("일정 알람")
        .setContentText(msg)
        .setPriority(NotificationManager.IMPORTANCE_HIGH)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build() // notification 객체가 만들어짐

    notificationManager.notify(notificationId, notification) //퍼미션 추가 , 권한 정보

        // 채널 정보 만들고 , 시스템 서비스 만들어서 manager / 시스템에 채널 정보 등록  / build
}