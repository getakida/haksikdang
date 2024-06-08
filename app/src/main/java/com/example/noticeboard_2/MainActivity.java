package com.example.noticeboard_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 회원가입 버튼 클릭 시 RegisterActivity로 이동
        Button registerButton =(Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(view -> {
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        });

        // 로그인 버튼 클릭 시
        final EditText idText = findViewById(R.id.idText);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {
            String userID = idText.getText().toString();
            String userPassword = password.getText().toString();

            // 서버로 로그인 요청을 보내고 응답을 처리하는 리스너
            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    // AlertDialog.Builder 생성
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    if (success) {
                        // 로그인 성공 시 알림 다이얼로그 표시
                        dialog = builder.setMessage("로그인에 성공했습니다.")
                                .setPositiveButton("확인", (dialog, which) -> {
                                    // 로그인 성공 시 MainActivity로 이동
                                    Intent intent = new Intent(MainActivity.this, MainMenu.class);
                                    startActivity(intent);
                                    finish(); // 현재 액티비티 종료
                                })
                                .create();
                    } else {
                        // 로그인 실패 시 알림 다이얼로그 표시
                        dialog = builder.setMessage("계정을 다시 확인해주세요.")
                                .setNegativeButton("다시 시도", null)
                                .create();
                    }

                    // AlertDialog 보이기
                    dialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

            // 로그인 요청을 서버로 보내는 객체
            LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            queue.add(loginRequest);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 알림 다이얼로그가 화면에 표시 중인 경우, 종료할 때 다이얼로그 닫기
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
