package com.example.blocknumbercall.PhoneManager.Application.Event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import com.example.blocknumbercall.PhoneManager.Application.Service.BlockCallService;
import com.example.blocknumbercall.PhoneManager.Domain.Service.BlockCallServiceInterface;
import com.example.blocknumbercall.PhoneManager.Infrastructure.Recipient.AndroidTelecomManagerRecipient;
import com.example.blocknumbercall.PhoneManager.Infrastructure.Repository.AndroidContactRepository;

public class PhoneReceiverListener extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(action)) {
            return;
        }
        Bundle extras = intent.getExtras();
        String extraState = extras.getString(TelephonyManager.EXTRA_STATE);
        if (extraState.equals(TelephonyManager.EXTRA_STATE_RINGING) && extras.size() >= 2) {
            String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            BlockCallServiceInterface blockCallService = new BlockCallService(
                new AndroidContactRepository(context.getContentResolver()),
                new AndroidTelecomManagerRecipient(context)
            );
            blockCallService.blockCall(phoneNumber);
        }
    }
}

