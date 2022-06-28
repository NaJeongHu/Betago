package com.nacho.betago.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.nacho.betago.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edit_id, edit_pw;
    private LinearLayout ll_login;
    private TextView tv_login;
    private AlertDialog alertDialog;
    private LottieAnimationView animationView;

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
                upload_dialog(view);
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        alertDialog.dismiss();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }, 3800);
                break;
        }
    }

    public void upload_dialog(View v) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_progress, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setView(dialogView);

        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        animationView = dialogView.findViewById(R.id.lottie_progress);
        animationView.playAnimation();
    }
}