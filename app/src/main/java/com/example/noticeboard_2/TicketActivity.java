package com.example.noticeboard_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
    }

    public void onTicketButtonClick(View view) {
        // 클릭된 버튼을 ticketContainer에서 제거합니다.
        LinearLayout ticketContainer = findViewById(R.id.ticketContainer);
        ticketContainer.removeView(view);

        // 클릭된 버튼의 텍스트를 가져옵니다.
        String selectedTicket = ((Button) view).getText().toString();

        // Orderstart 또는 NoticketActivity로 이동합니다.
        if (view.getId() == R.id.ticketButton1 || view.getId() == R.id.ticketButton1) {
            // Orderstart로 이동
            Intent intent = new Intent(this, Orderstart.class);
            intent.putExtra("selectedTicket", selectedTicket);
            startActivityForResult(intent, 1);
        } else if (view.getId() == R.id.btnUsedCoupons) {
            // NoticketActivity로 이동
            Intent intent = new Intent(this, NoticketActivity.class);
            startActivity(intent);
        }
    }
}
