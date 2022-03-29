package com.example.blocknumbercall.Core.Domain.UseCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public abstract class AbstractUseCaseResponseValues implements UseCaseResponseValues {

    private int code;
    private String message;
    private Object payload;

    public AbstractUseCaseResponseValues(
        int code,
        String message,
        Object payload
    ) {
        this.code = code;
        this.message = message;
        this.payload = payload;
    }

    public AbstractUseCaseResponseValues(
        int code
    ) {
        this.code = code;
        this.message = "success_use_case";
        this.payload = true;
        if (code >= 400) {
            this.message = "error_use_case";
            this.payload = false;
        }
    }

    public AbstractUseCaseResponseValues(
        int code,
        String message
    ) {
        this.code = code;
        this.message = message;
        this.payload = true;
        if (code >= 400) {
            this.payload = false;
        }
    }

    public AbstractUseCaseResponseValues(
        int code,
        Object payload
    ) {
        this.code = code;
        this.message = "success_use_case";
        this.payload = payload;
        if (code >= 400) {
            this.message = "error_use_case";
        }
    }

    @Override
    public boolean getStatus() throws IOException {
        return this.code < 400;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public JSONObject getPayload() throws JSONException {
        if (this.code == UseCaseResponseValues.SUCCESS_NO_CONTENT) {
            this.payload = null;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", this.payload);
        return jsonObject;
    }
}
