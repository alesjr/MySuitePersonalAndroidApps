package com.example.blocknumbercall.PhoneManager.Domain.UseCase.BlockCall;

import com.example.blocknumbercall.Core.Domain.UseCase.AbstractUseCaseResponseValues;

public class BlockCallResponseValues extends AbstractUseCaseResponseValues {

    public BlockCallResponseValues(int code, String message, Object payload) {
        super(code, message, payload);
    }

    public BlockCallResponseValues(int code) {
        super(code);
    }

    public BlockCallResponseValues(int code, String message) {
        super(code, message);
    }

    public BlockCallResponseValues(int code, Object payload) {
        super(code, payload);
    }
}
