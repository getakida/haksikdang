package com.example.noticeboard_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuInfoActivity01 extends AppCompatActivity {

    // 액티비티가 처음 생성될 때 호출되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 액티비티의 내용물을 activity_menuinfor01.xml에서 정의한 레이아웃으로 설정
        setContentView(R.layout.activity_menuinfor01);

        // 레이아웃에서 ID가 'spa'인 ImageView를 찾아옴
        ImageView spaImageView = findViewById(R.id.spa);

        // ImageView에 클릭 리스너를 설정
        spaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ImageView가 클릭되면 MainActivity로 이동하는 Intent 생성
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                // MainActivity 시작
                startActivity(intent);
            }
        });
    }
}