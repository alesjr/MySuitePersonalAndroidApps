package com.example.blocknumbercall.Core.Domain.UseCase;

import org.json.JSONObject;

import java.util.Map;

public interface UseCaseRequestValues {

    public boolean validate();
    public Map<String, String> getErrors();
    public JSONObject getJsonObject();
}
