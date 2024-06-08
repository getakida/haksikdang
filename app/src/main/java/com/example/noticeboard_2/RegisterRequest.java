package com.example.noticeboard_2;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정 (PHP 파일 연동)
    final static private String URL = "http://qrmission.dothome.co.kr/UserRegister.php";
    private final Map<String, String> parameters;

    public RegisterRequest(String userYOU, String userID, String userPassword, String userName, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userYOU", userYOU);
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}