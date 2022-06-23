package com.nacho.betago.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nacho.betago.R;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_1, ll_2, ll_6, ll_7, ll_pick;
    private TextView tv_seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        ll_1 = findViewById(R.id.ll_1);
        ll_2 = findViewById(R.id.ll_2);
        ll_6 = findViewById(R.id.ll_6);
        ll_7 = findViewById(R.id.ll_7);
        ll_pick = findViewById(R.id.ll_pick);
        tv_seat = findViewById(R.id.tv_seat);

        ll_1.setOnClickListener(this);
        ll_2.setOnClickListener(this);
        ll_6.setOnClickListener(this);
        ll_7.setOnClickListener(this);
        ll_pick.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_1:
                ll_1.setBackgroundResource(R.drawable.blue1);
                tv_seat.setText("A01");
                break;
            case R.id.ll_2:
                ll_2.setBackgroundResource(R.drawable.blue2);
                tv_seat.setText("A01, A02");
                break;
            case R.id.ll_6:
                ll_6.setBackgroundResource(R.drawable.blue6);
                tv_seat.setText("A01, A02, A06");
                break;
            case R.id.ll_7:
                ll_7.setBackgroundResource(R.drawable.blue7);
                tv_seat.setText("A01, A02, A06, A07");
                ll_pick.setBackgroundResource(R.drawable.custom_main_cardview_logined_shape);
                break;
            case R.id.ll_pick:
                Intent intent = new Intent(BookDetailActivity.this, BookActivity.class);
                intent.putExtra("isfrom",true);
                startActivity(intent);
                break;
        }
    }
}