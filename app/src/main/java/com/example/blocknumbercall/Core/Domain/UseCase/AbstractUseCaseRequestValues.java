package com.example.blocknumbercall.Core.Domain.UseCase;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUseCaseRequestValues implements UseCaseRequestValues {

    private JSONObject jsonObject;
    private HashMap<String, String> errors;

    public AbstractUseCaseRequestValues() {
        this.jsonObject = new JSONObject();
        this.errors = new HashMap<>();
    }


    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public Map<String, String> getErrors() {
        return errors;
    }

    @Override
    public JSONObject getJsonObject() {
        return this.jsonObject;
    }
}
