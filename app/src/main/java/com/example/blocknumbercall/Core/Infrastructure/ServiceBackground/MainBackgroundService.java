package com.example.blocknumbercall.Core.Infrastructure.ServiceBackground;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.example.blocknumbercall.PhoneManager.Application.Event.PhoneReceiverListener;

class MainBackgroundService extends Service {

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("restartservice");
        broadcastIntent.setClass(this, PhoneReceiverListener.class);
        this.sendBroadcast(broadcastIntent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
