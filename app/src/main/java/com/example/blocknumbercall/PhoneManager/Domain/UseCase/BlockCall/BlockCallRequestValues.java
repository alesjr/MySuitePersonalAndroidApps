package com.example.blocknumbercall.PhoneManager.Domain.UseCase.BlockCall;

import com.example.blocknumbercall.Core.Domain.UseCase.AbstractUseCaseRequestValues;
import com.example.blocknumbercall.Core.Domain.UseCase.UseCaseRequestValues;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BlockCallRequestValues extends AbstractUseCaseRequestValues {

    @Override
    public boolean validate() {
        if (!this.getJsonObject().has("phoneNumber")) {
            this.getErrors().put("phoneNumber", "is_required");
        }
        return this.getErrors().size() == 0;
    }
}
