package com.example.andriod_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginSelectActivity extends AppCompatActivity {

    Button emailLoginBtn, googleLoginBtn, registerBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_select);

        emailLoginBtn = findViewById(R.id.emailLoginBtn);
        googleLoginBtn = findViewById(R.id.googleLoginBtn);
        registerBtn = findViewById(R.id.joinBtn);
    }

    public void loginModeSystem(View view) {
        switch (view.getId()) {
            case R.id.emailLoginBtn :
                // 이메일 계정 로그인 화면으로 화면 전환
                intent = new Intent(LoginSelectActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.googleLoginBtn :
                // 구글계정 로그인 API를 사용하여 구글 계정 로그인 성공 시,
                // 해당하는 함수의 if문에서 성공 조건에서 해당 화면 전환 코드 사용
                intent = new Intent(LoginSelectActivity.this, MainHomeActivity.class);
                startActivity(intent);
                break;
            case R.id.joinBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(LoginSelectActivity.this, JoinActivity.class);
                startActivity(intent);
                break;
        }
    }
}