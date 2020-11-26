package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.UserVO;

import retrofit2.Call;

public class MainHomeActivity extends AppCompatActivity {

    TextView userNicknameTxtView, nicknameTxtView, idTxtView, nameTxtView, rankPointTxt, solveProblemTxt, correctProblemTxt;
    ImageView profileImgView, RankImgView;
    ImageButton userInfoCloseBtn;

    ConstraintLayout popupConstraint;
    PopupWindow userInfoPopup;
    View popupView;

    Intent intent;
    String userId, userName, userNickname;
    int userRankPoint, userSolveProblem, userCorrectProblem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);   // 화면 상단 회원 닉네임 텍스트뷰 아이디

        // 팝업 윈도우 정의 및 구현
        popupConstraint = findViewById(R.id.mainHomeLayout);
        popupView = View.inflate(this, R.layout.popup_userinfo, null);
        userInfoPopup = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        // 유저 정보 팝업 윈도우 화면 텍스트뷰 아이디 정의
        nicknameTxtView = popupView.findViewById(R.id.nicknameTxtView);
        idTxtView = popupView.findViewById(R.id.idTxtView);
        nameTxtView = popupView.findViewById(R.id.nameTxtView);
        rankPointTxt = popupView.findViewById(R.id.rankPointTxt);
        solveProblemTxt = popupView.findViewById(R.id.solveProblemTxt);
        correctProblemTxt = popupView.findViewById(R.id.correctProblemTxt);


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

        // 유저 정보 팝업 윈도우에 정보 세팅
        nicknameTxtView.setText(userNickname);
        idTxtView.setText(userId);
        nameTxtView.setText(userName);
        rankPointTxt.setText(userRankPoint+"점");
        solveProblemTxt.setText(userSolveProblem+"개");
        correctProblemTxt.setText(userCorrectProblem+"개");

        // 유저 정보 팝업 윈도우 종료 버튼 이벤트 구현부
        userInfoCloseBtn = popupView.findViewById(R.id.userInfoCloseBtn);
        userInfoCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfoPopup.dismiss();
            }
        });
    }

    // 버튼 이벤트 리스터 구현부
    public void mainHomeSystem(View view) {

        switch (view.getId()) {
            case R.id.storyBtn :
                intent = new Intent(MainHomeActivity.this, StoryModeActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("userName", userName);
                intent.putExtra("userNickname", userNickname);
                intent.putExtra("userRankPoint", userRankPoint);
                intent.putExtra("userSolveProblem", userSolveProblem);
                intent.putExtra("userCorrectProblem", userCorrectProblem);
                System.out.println("---------------------\n");
                System.out.println("" + userId + "/" + userName + "/" + userNickname + "/" + userRankPoint + userSolveProblem + userCorrectProblem);
                startActivity(intent);
                onStop();
                break;
            case R.id.challengeBtn :
                intent = new Intent(MainHomeActivity.this, ChallengeModeActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("userNickname", userNickname);
                intent.putExtra("userRankPoint", userRankPoint);
                intent.putExtra("userSolveProblem", userSolveProblem);
                intent.putExtra("userCorrectProblem", userCorrectProblem);
                System.out.println("---------------------\n");
                System.out.println("" + userId + "/" + userName + "/" + userNickname + "/" + userRankPoint + userSolveProblem + userCorrectProblem);
                startActivity(intent);
                onStop();
                break;
            case R.id.studyBtn :
                intent = new Intent(MainHomeActivity.this, StudyModeActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("userNickname", userNickname);
                intent.putExtra("userRankPoint", userRankPoint);
                intent.putExtra("userSolveProblem", userSolveProblem);
                intent.putExtra("userCorrectProblem", userCorrectProblem);
                System.out.println("---------------------\n");
                System.out.println("" + userId + "/" + userName + "/" + userNickname + "/" + userRankPoint + userSolveProblem + userCorrectProblem);
                startActivity(intent);
                onStop();
                break;
            case R.id.userNicknameTxtView :
            case R.id.profileImgVIew :
                userInfoPopup.showAtLocation(popupConstraint, Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL, 0, 0);
                userInfoPopup.setAnimationStyle(-1);
                break;
            case R.id.rankBtn :
                intent = new Intent(MainHomeActivity.this, RankingActivity.class);
                intent.putExtra("userNickname", userNickname);
                System.out.println("---------------------\n");
                startActivity(intent);
                onStop();
                break;
        }
    }
}