package com.example.a16022596.po10problemstatement;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class ScheduledNotificationReceiver extends BroadcastReceiver {
    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("info", "anything la");
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new
                    NotificationChannel("default","Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("This is for default notficiation");
            notificationManager.createNotificationChannel(channel);
        }

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context,reqCode,i,PendingIntent.FLAG_CANCEL_CURRENT);
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context,"default");
        builder.setContentTitle("Please COME BACK!");
        builder.setContentText("PLEASE PLAY ME ");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);

        Notification n = builder.build();
        notificationManager.notify(123,n);


    }
}
