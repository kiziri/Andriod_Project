package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.UserVO;

import retrofit2.Call;

public class MainHomeActivity extends AppCompatActivity {

    TextView userNicknameTxtView;
    ImageView profileImgView, RankImgView;

    Intent intent;
    String userId, userName, userNickname;
    int userRankPoint, userSolveProblem, userCorrectProblem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);

        // 로그인 화면에서 로그인을 하며 MySQL에서 검색하여 받아온 로그인한 회원의
        // 회원 정보를 저장
        intent = getIntent();
        System.out.println("---------------------\n");

        // 로그인한 유저의 닉네임을 메인 화면의 닉네임 부분에 세팅
        userNicknameTxtView.setText(""+intent.getStringExtra("userNickname"));
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