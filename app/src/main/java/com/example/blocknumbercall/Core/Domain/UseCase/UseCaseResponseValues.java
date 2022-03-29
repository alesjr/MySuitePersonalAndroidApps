package com.example.blocknumbercall.Core.Domain.UseCase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface UseCaseResponseValues {

    public static final int REQUEST_INVALID = HttpURLConnection.HTTP_BAD_REQUEST;
    public static final int NOT_FOUND = HttpURLConnection.HTTP_NOT_FOUND;
    public static final int SUCCESS = HttpURLConnection.HTTP_OK;
    public static final int SUCCESS_NO_CONTENT = HttpURLConnection.HTTP_NO_CONTENT;
    public static final int SUCCESS_CREATED = HttpURLConnection.HTTP_CREATED;
    public static final int REDEFINE_CONTENT = HttpURLConnection.HTTP_RESET;
    public static final int STREAM_CHUNK_CONTENT = HttpURLConnection.HTTP_PARTIAL;
    public static final int INTERNAL_ERROR = HttpURLConnection.HTTP_INTERNAL_ERROR;

    /**
     * When task create or edit a batch
     */
    public static final int SUCCESS_ACCEPTED = HttpURLConnection.HTTP_ACCEPTED;

    /**
     * Used to async tasks (queues, uploads, services async and etc) in still execution
     */
    public static final int IN_PROCESSING = 102;
    public static final int CONTINUE = 100;
    public static final int BEGINING = 103;

    public boolean getStatus() throws IOException;
    public String getMessage();
    public int getCode();
    public JSONObject getPayload() throws JSONException;
}
