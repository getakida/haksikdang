package com.example.noticeboard_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BoardActivity extends AppCompatActivity {

    private ListView boardListview;
    private BoardApater adapter;
    private List<Board> boardList;
    static RequestQueue requestQueue;

    String URL = "http://qrmission.dothome.co.kr/BoardList.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_list);

        // 메인으로 버튼 클릭 시 메인화면으로 전환
        Button maingo_btn = (Button) findViewById(R.id.maingo_btn);
        maingo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        //작성 버튼 클릭 시 작성 화면전환
        Button write_btn = (Button) findViewById(R.id.write_btn);
        write_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BoardWriteActivity.class);
                startActivity(intent);
            }
        });


        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest( URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                boardListview = (ListView) findViewById(R.id.boardListView);
                boardList = new ArrayList<Board>();
                adapter = new BoardApater(getApplicationContext(), boardList);
                boardListview.setAdapter(adapter);

                //Log.d("response",response.toString());
                try {
                    String title,contents,create_time;
                    for(int i=0; i <response.length(); i++) {
                        JSONObject object = (JSONObject) response.get(i);
                        title = object.getString("title");
                        //Log.d(title, "onResponse:title ");
                        contents = object.getString("contents");
                        create_time = object.getString("create_time");
                        boardList.add(new Board(title,contents,create_time));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "에러:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        jsonArrayRequest.setShouldCache(false);
        requestQueue.add(jsonArrayRequest);

        Button re_btn = (Button) findViewById(R.id.re_btn);
        re_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                startActivity(intent);
            }
        });







    } //onCreate

} //BoardActiviy





