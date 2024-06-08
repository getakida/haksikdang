package com.example.noticeboard_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Orderstart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodticket1);
    }

    public void onOrderButtonClick(View view) {
        // Order 버튼을 눌렀을 때 TicketActivity로 돌아갑니다.
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

        // 주문이 완료되었다는 토스트 메시지를 표시합니다.
        Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
    }
}

