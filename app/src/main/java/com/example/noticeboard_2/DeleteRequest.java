package com.example.noticeboard_2;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeleteRequest extends StringRequest {
    final static private String URL = "http://qrmission.dothome.co.kr/BoardDelete.php";

    private final Map<String,String> parameters;

    public DeleteRequest(String title, String contents, String create_time, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("title",title);
        parameters.put("contents",contents);
        parameters.put("create_time",create_time);
    }

    @Override
    public Map<String,String> getParams() {
        return parameters;
    }


}
