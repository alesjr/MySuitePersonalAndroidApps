package com.example.blocknumbercall.Core.Domain.Service;

import android.content.Context;

public interface NotificationSendInterface {
    public static final int NOTIFICATION_BLOCKED = 0;
    public static final int NOTIFICATION_SERVICE_BLOCK_START = 1;
    public static final int NOTIFICATION_SERVICE_BLOCK_RUNNING = 2;

    public void createNotification(
        int id,
        CharSequence title,
        CharSequence message
    );
}
