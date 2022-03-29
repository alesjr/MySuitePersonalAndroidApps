package com.example.blocknumbercall.PhoneManager.Infrastructure.Recipient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.TelecomManager;

import com.example.blocknumbercall.Core.Domain.Recipient.PermissionRecipientInterface;
import com.example.blocknumbercall.Core.Infrastructure.Recipient.AndroidPermissionRecipient;
import com.example.blocknumbercall.PhoneManager.Domain.Recipient.TelecomManagerRecipientInterface;

public class AndroidTelecomManagerRecipient implements TelecomManagerRecipientInterface {

    private Context context;
    private PermissionRecipientInterface permissionRecipient;

    public AndroidTelecomManagerRecipient(Context context) {
        this.context = context;
        this.permissionRecipient = new AndroidPermissionRecipient(context);
    }

    @SuppressLint("MissingPermission")
    @Override
    public boolean endCall() {
        TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
        if (this.permissionRecipient.isGranted(android.Manifest.permission.ANSWER_PHONE_CALLS)) {
            return telecomManager.endCall();
        }
        return false;
    }
}
