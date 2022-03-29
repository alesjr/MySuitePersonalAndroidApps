package com.example.blocknumbercall.PhoneManager.Infrastructure.Repository;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.example.blocknumbercall.PhoneManager.Domain.Repository.ContactRepositoryInterface;

public class AndroidContactRepository implements ContactRepositoryInterface {

    private static final String[] PROJECTION = new String[]{
        ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    };

    private ContentResolver contentResolver;

    public AndroidContactRepository(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    @Override
    public boolean isExists(String phoneNumber) {
        String selection = ContactsContract.CommonDataKinds.Phone.NUMBER + " = ?";
        Cursor cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            PROJECTION,
            selection,
            new String[]{phoneNumber},
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        );
        return cursor.moveToFirst();
    }
}
