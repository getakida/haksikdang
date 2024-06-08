package com.example.noticeboard_2;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Objects;

public class BoardApater extends BaseAdapter{


    private Context context;
    private List<Board> boardList;

    public BoardApater (Context context, List<Board> boardList){
        this.context = context;
        this.boardList = boardList;
    }

    @Override
    public int getCount () {
        return boardList.size();
    }

    @Override
    public Object getItem(int i) {
        return boardList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        context = parent.getContext();
        Board board = boardList.get(i);

        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.board, parent, false);
        }

        TextView boardTitle = (TextView) v.findViewById(R.id.boardTitle);
        TextView boardText = (TextView) v.findViewById(R.id.boardText);
        TextView boardTime = (TextView) v.findViewById(R.id.boardTime);

        boardTitle.setText(boardList.get(i).getTitle());
        boardText.setText(boardList.get(i).getText());
        boardTime.setText(boardList.get(i).getTime());

        Button del_btn = (Button) v.findViewById(R.id.del_btn);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = boardList.get(i).title;
                String contents = boardList.get(i).text;
                String create_time = boardList.get(i).time;

                Response.Listener<String> responListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(context, "삭제 완료", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(context, "삭제 실패", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }
                };
                DeleteRequest deleteRequest = new DeleteRequest(title, contents, create_time, responListener);
                RequestQueue requestQueue1 = Volley.newRequestQueue(context);
                requestQueue1.add(deleteRequest);
            }

        });

        return v;
    }
}
