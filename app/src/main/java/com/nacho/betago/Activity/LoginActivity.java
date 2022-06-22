package com.nacho.betago.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.nacho.betago.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edit_id, edit_pw;
    private LinearLayout ll_login;
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    void init() {
        edit_id = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_password);
        ll_login = findViewById(R.id.ll_login);
        tv_login = findViewById(R.id.tv_login);

        ll_login.setOnClickListener(this);

        edit_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit_pw.getText().toString().equals("") || edit_pw.getText().toString() == null) {

                } else {
                    ll_login.setBackgroundResource(R.drawable.custom_main_cardview_logined_shape);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}