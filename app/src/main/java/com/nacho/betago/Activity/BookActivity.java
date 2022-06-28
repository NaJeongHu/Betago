package com.nacho.betago.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nacho.betago.R;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout cl_first;
    private LinearLayout ll_calendar, ll_date, ll_people, ll_people1, ll_ship, ll_ship1, ll_car, ll_car_info, ll_pay;
    private TextView tv_date, tv_people, tv_people_adult, tv_people_grand, tv_ship;
    private ImageView iv_arrow1, iv_arrow2, iv_arrow3, iv_arrow4, iv_plus_adult, iv_plus_grand, iv_turnon;
    private CalendarView calendarView;

    private Integer str1, str2;
    private boolean flag1, flag2;
    private boolean isFromDetail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // todo :

        cl_first = findViewById(R.id.cl_first);
        cl_first.setOnClickListener(this);
        ll_calendar = findViewById(R.id.ll_calendar);
        ll_date = findViewById(R.id.ll_date);
        ll_date.setOnClickListener(this);
        ll_people = findViewById(R.id.ll_people);
        ll_people.setOnClickListener(this);
        ll_people1 = findViewById(R.id.ll_people1);
        ll_ship = findViewById(R.id.ll_ship);
        ll_ship.setOnClickListener(this);
        ll_ship1 = findViewById(R.id.ll_ship1);
        ll_car = findViewById(R.id.ll_car);
        ll_car.setOnClickListener(this);
        ll_car_info = findViewById(R.id.ll_car_info);
        ll_pay = findViewById(R.id.ll_pay);
        ll_pay.setOnClickListener(this);

        tv_date = findViewById(R.id.tv_date);
        tv_people = findViewById(R.id.tv_people);
        tv_people_adult = findViewById(R.id.tv_people_adult);
        tv_people_grand = findViewById(R.id.tv_people_grand);
        tv_ship = findViewById(R.id.tv_ship);
        iv_arrow1 = findViewById(R.id.iv_arrow1);
        iv_arrow2 = findViewById(R.id.iv_arrow2);
        iv_arrow3 = findViewById(R.id.iv_arrow3);
        iv_arrow4 = findViewById(R.id.iv_arrow4);
        iv_plus_adult = findViewById(R.id.iv_plus_adult);
        iv_plus_adult.setOnClickListener(this);
        iv_plus_grand = findViewById(R.id.iv_plus_grand);
        iv_plus_grand.setOnClickListener(this);
        iv_turnon = findViewById(R.id.iv_turnon);
        iv_turnon.setOnClickListener(this);

        calendarView = findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                tv_date.setText("2022년 6월 13일 (토)");
                ll_calendar.setVisibility(View.GONE);
                iv_arrow1.setRotation(0);
                ll_people.setVisibility(View.VISIBLE);
            }
        });

        str1 = 0;
        str2 = 0;
        flag1 = false;
        flag2 = false;


        isFromDetail = getIntent().getBooleanExtra("isfrom",false);
        if(isFromDetail) {
            ll_ship.setBackgroundResource(R.drawable.custom_reservation_cardview_shape);
            ll_ship1.setVisibility(View.GONE);
            iv_arrow3.setRotation(0);

            tv_date.setText("2022년 6월 13일 (토)");
            ll_people.setVisibility(View.VISIBLE);
            tv_people.setText("성인 2 노인 2");
            ll_people1.setVisibility(View.GONE);
            ll_ship.setVisibility(View.VISIBLE);
            tv_ship.setText("비욘드트러스트 17:00");
            ll_car.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cl_first:
                Intent intent = new Intent(BookActivity.this, BookDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_date:
                ll_date.setBackgroundResource(R.drawable.custom_reservation_cardview_shape2);
                ll_calendar.setVisibility(View.VISIBLE);
                iv_arrow1.setRotation(180);
                break;
            case R.id.ll_people:
                if(flag1 == false) {
                    ll_date.setBackgroundResource(R.drawable.custom_reservation_cardview_shape);
                    ll_people.setBackgroundResource(R.drawable.custom_reservation_cardview_shape2);
                    ll_people1.setVisibility(View.VISIBLE);
                    iv_arrow2.setRotation(180);
                    flag1 = true;
                } else if (flag2 == true) {
                    tv_people.setText("성인 2 노인 2");
                    ll_people1.setVisibility(View.GONE);
                    ll_ship.setVisibility(View.VISIBLE);
                    iv_arrow2.setRotation(0);
                }
                break;
            case R.id.ll_ship:
                ll_people.setBackgroundResource(R.drawable.custom_reservation_cardview_shape);
                ll_ship.setBackgroundResource(R.drawable.custom_reservation_cardview_shape2);
                ll_ship1.setVisibility(View.VISIBLE);
                iv_arrow3.setRotation(180);
                break;
            case R.id.ll_car:
                break;
            case R.id.iv_plus_adult:
                str1++;
                tv_people_adult.setText(String.valueOf(str1));
                break;
            case R.id.iv_plus_grand:
                str2++;
                tv_people_grand.setText(String.valueOf(str2));
                if(str2 == 2) flag2 = true;
                break;
            case R.id.iv_turnon:
                iv_turnon.setImageResource(R.drawable.icon_on);
                ll_pay.setBackgroundResource(R.drawable.custom_main_cardview_logined_shape);
                break;
            case R.id.ll_pay:
                // todo : kakaopai 연결
                PayActivity payActivity = new PayActivity("청암 초등학교", "실내코트 이용료", 40000);
                Intent intent1 = new Intent(BookActivity.this, payActivity.getClass());
                startActivity(intent1);
                break;
        }
    }
}