package com.example.andriod_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainHomeActivity extends AppCompatActivity {

    TextView userNicknameTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);


    }

    // 버튼 이벤트 리스터 구현부
    public void gameModeSelectSystem(View view) {

        switch (view.getId()) {
            case R.id.storyBtn :
                break;
            case R.id.challengeBtn :
                break;
            case R.id.studyBtn :
                break;
        }
    }
}