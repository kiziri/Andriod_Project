package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.UserVO;

import retrofit2.Call;

public class MainHomeActivity extends AppCompatActivity {

    TextView userNicknameTxtView;
    ImageView profileImgView, RankImgView;

    LinearLayout popupLinear;
    PopupWindow userInfoPopup;
    View popupView;

    Intent intent;
    String userId, userName, userNickname;
    int userRankPoint, userSolveProblem, userCorrectProblem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);

        popupLinear = findViewById(R.id.mainHomeLayout);
        popupView = View.inflate(this, R.layout.popup_userinfo, null);
        userInfoPopup = new PopupWindow(popupView, 280, 200, true);


        // 로그인 화면에서 로그인을 하며 MySQL에서 검색하여 받아온 로그인한 회원의
        // 회원 정보를 저장
        intent = getIntent();
        userId = intent.getStringExtra("userId");
        userName = intent.getStringExtra("userName");
        userNickname = intent.getStringExtra("userNickname");
        userRankPoint = intent.getIntExtra("userRankPoint", 0);
        userSolveProblem = intent.getIntExtra("userSolveProblem", 0);
        userCorrectProblem = intent.getIntExtra("userCorrectProblem", 0);
        System.out.println("---------------------\n");
        System.out.println("" + userId + "/" + userName + "/" + userNickname + "/" + userRankPoint + userSolveProblem + userCorrectProblem);

        // 로그인한 유저의 닉네임을 메인 화면의 닉네임 부분에 세팅
        userNicknameTxtView.setText(userNickname);
    }

    // 버튼 이벤트 리스터 구현부
    public void mainHomeSystem(View view) {

        switch (view.getId()) {
            case R.id.storyBtn :
                break;
            case R.id.challengeBtn :
                break;
            case R.id.studyBtn :
                break;
            case R.id.userNicknameTxtView :
            case R.id.profileImgVIew :
                userInfoPopup.showAsDropDown(popupLinear);
                break;
            case R.id.userInfoCloseBtn :
                userInfoPopup.dismiss();
                break;
        }
    }
    
    // 회원 정보 화면 구현 메소드 부분
    public void showUserInfo() {
        
    }
}