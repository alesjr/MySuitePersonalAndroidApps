package com.example.blocknumbercall.PhoneManager.Domain.Service;

public interface BlockCallServiceInterface {
    public static int COMMAND_TYPE_END_CALL = 1;

    public void blockCall(String phoneNumber);
}
