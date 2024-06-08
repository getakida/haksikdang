package com.example.noticeboard_2;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class WriteRequest extends StringRequest {

    final static private String URL = "http://qrmission.dothome.co.kr/BoardWrite.php";

    private final Map<String,String> parameters;

    public WriteRequest(String title, String contents, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("title",title);
        Log.d(title, "WriteRequest: ");
        parameters.put("contents",contents);
        Log.d(contents, "WriteRequest: ");
    }

    @Override
    public Map<String,String> getParams() {
        return parameters;
    }


}
