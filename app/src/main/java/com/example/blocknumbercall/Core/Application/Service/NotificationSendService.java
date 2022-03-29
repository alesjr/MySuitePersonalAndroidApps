package com.example.blocknumbercall.Core.Application.Service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;

import androidx.core.app.NotificationCompat;

import com.example.blocknumbercall.Core.Domain.Service.NotificationSendInterface;

public class NotificationSendService implements NotificationSendInterface {

    private Context context = null;

    public NotificationSendService(Context context) {
        this.context = context;
    }

    @Override
    public void createNotification(
        int id,
        CharSequence title,
        CharSequence message
    ) {
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "my_channel_" + id,
                    "my_channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Channel for send notification");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            channel.setShowBadge(false);
            notificationManager.createNotificationChannel(channel);

            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context, "my_channel_" + id)
                        .setSmallIcon(com.example.blocknumbercall.R.drawable.ic_launcher_background)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            notificationManager.notify(id, builder.build());
        }
    }
}
