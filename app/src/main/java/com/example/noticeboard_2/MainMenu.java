package com.example.noticeboard_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainMenu extends AppCompatActivity {
    private CheckBox a_cb1;
    private CheckBox a_cb2;
    private CheckBox a_cb3;
    private CheckBox b_cb1;
    private CheckBox b_cb2;
    private CheckBox b_cb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a_cb1 = findViewById(R.id.a_cb1);
        a_cb2 = findViewById(R.id.a_cb2);
        a_cb3 = findViewById(R.id.a_cb3);
        b_cb1 = findViewById(R.id.b_cb1);
        b_cb2 = findViewById(R.id.b_cb2);
        b_cb3 = findViewById(R.id.b_cb3);


        // ImageView 초기화
        ImageView spaImageView = findViewById(R.id.spa);
        ImageView donImageView = findViewById(R.id.don);
        ImageView pDonImageView = findViewById(R.id.p_don);
        ImageView jjaImageView = findViewById(R.id.jja);
        ImageView jjamImageView = findViewById(R.id.jjam);
        ImageView tangImageView = findViewById(R.id.tang);

        Button mainBuyButton = findViewById(R.id.mainBuy);
        mainBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // "구매하기" 버튼 클릭 시 CheckBox 상태 확인하여 적절한 Activity 시작
                if (a_cb1.isChecked()) {
                    startOrderActivity(Order.class);
                } else if (a_cb2.isChecked()) {
                    startOrderActivity(Order2.class);
                } else if (a_cb3.isChecked()) {
                    startOrderActivity(Order3.class);
                } else if (b_cb1.isChecked()) {
                    startOrderActivity(Order4.class);
                } else if (b_cb2.isChecked()) {
                    startOrderActivity(Order5.class);
                } else if (b_cb3.isChecked()) {
                    startOrderActivity(Order6.class);
                }
            }
        });

        Button btn_board = (Button) findViewById(R.id.btn_Board);
        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        Button btn_box = (Button) findViewById(R.id.btn_Box);
        btn_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), TicketActivity.class);
                startActivity(intent);
            }
        });

        // ImageView에 클릭 리스너 추가
        spaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity01.class);
                startActivity(intent);
            }
        });

        donImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity02.class);
                startActivity(intent);
            }
        });

        pDonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity03.class);
                startActivity(intent);
            }
        });

        jjaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity04.class);
                startActivity(intent);
            }
        });

        jjamImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity05.class);
                startActivity(intent);
            }
        });

        tangImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuInfoActivity06.class);
                startActivity(intent);
            }
        });

        // TextView 초기화 및 현재 날짜 표시
        TextView dateTextView = findViewById(R.id.date);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy / MM / dd");
        String formattedDate = dateFormat.format(calendar.getTime());
        dateTextView.setText(formattedDate);


    }//onCreate
    private void startOrderActivity(Class<?> orderActivityClass) {
        Intent intent = new Intent(MainMenu.this, orderActivityClass);
        startActivity(intent);
    }
}
