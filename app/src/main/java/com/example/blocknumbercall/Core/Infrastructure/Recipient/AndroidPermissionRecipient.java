package com.example.blocknumbercall.Core.Infrastructure.Recipient;

import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import com.example.blocknumbercall.Core.Domain.Recipient.PermissionRecipientInterface;

public class AndroidPermissionRecipient implements PermissionRecipientInterface {

    private Context context;

    public AndroidPermissionRecipient(Context context) {
        this.context = context;
    }

    @Override
    public boolean isGranted(String permissionType) {
        return ActivityCompat.checkSelfPermission(
            this.context,
            permissionType
        ) == PackageManager.PERMISSION_GRANTED;
    }
}
