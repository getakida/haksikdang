package com.example.noticeboard_2;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class NoticketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticket);

        // btnAvailableCoupons 버튼 클릭 시 TicketActivity로 이동
        findViewById(R.id.btnAvailableCoupons).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoticketActivity.this, TicketActivity.class);
                startActivity(intent);
            }
        });
    }
}
