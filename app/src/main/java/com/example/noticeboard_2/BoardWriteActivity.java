package com.example.noticeboard_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class BoardWriteActivity extends AppCompatActivity {

    private EditText write_title,write_contents;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_write);

        write_title = findViewById(R.id.write_title);
        write_contents = findViewById(R.id.write_contents);

        Button completion_btn = (Button) findViewById(R.id.completion_btn);
        completion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = write_title.getText().toString();
                String contents = write_contents.getText().toString();

                Response.Listener<String > responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "게시물 작성 완료", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(BoardWriteActivity.this, BoardActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "작성 실패", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                WriteRequest writeRequest = new WriteRequest(title,contents,responseListener);
                RequestQueue queue = Volley.newRequestQueue(BoardWriteActivity.this);
                queue.add(writeRequest);


            }
        });


    } // onCreate
} // BoardWirte
