package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.ChallengeModeAdapter;
import com.example.andriod_project.adapters.StudyModeAdapter;

public class StudyModeActivity extends AppCompatActivity {

    StudyModeAdapter adapter;
    ViewPager viewPager;

    ImageView back, home, profileImgView, RankImgView, categoryBtn;
    TextView userNicknameTxtView, nicknameTxtView, idTxtView, nameTxtView, rankPointTxt, solveProblemTxt, correctProblemTxt;
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
        setContentView(R.layout.activity_study_mode);

        //이미지뷰 지정
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);
        categoryBtn = (ImageView) findViewById(R.id.categoryBtn);

        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);

        // 팝업 윈도우 정의 및 구현
        popupConstraint = findViewById(R.id.studyModeConstraint);
        popupView = View.inflate(this, R.layout.popup_userinfo, null);
        userInfoPopup = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        // 유저 정보 팝업 윈도우 화면 텍스트뷰 아이디 정의
        nicknameTxtView = popupView.findViewById(R.id.nicknameTxtView);
        idTxtView = popupView.findViewById(R.id.idTxtView);
        nameTxtView = popupView.findViewById(R.id.nameTxtView);
        rankPointTxt = popupView.findViewById(R.id.rankPointTxt);
        solveProblemTxt = popupView.findViewById(R.id.solveProblemTxt);
        correctProblemTxt = popupView.findViewById(R.id.correctProblemTxt);

        //뷰페이저 설정
        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new StudyModeAdapter(this);
        viewPager.setAdapter(adapter);

        // 이전 페이지 intent 데이터 읽어드리기
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
        rankPointTxt.setText(userRankPoint + "점");
        solveProblemTxt.setText(userSolveProblem + "개");
        correctProblemTxt.setText(userCorrectProblem + "개");

        // 유저 정보 팝업 윈도우 종료 버튼 이벤트 구현부
        userInfoCloseBtn = popupView.findViewById(R.id.userInfoCloseBtn);
        userInfoCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInfoPopup.dismiss();
            }
        });
    }


    public void studyModeSystem(View view) {
        switch (view.getId()) {
            case R.id.categoryBtn:
                intent = new Intent(StudyModeActivity.this, StudySelectActivity.class);
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
            case R.id.userNicknameTxtView:
            case R.id.profileImgVIew:
                userInfoPopup.showAtLocation(popupConstraint, Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
                userInfoPopup.setAnimationStyle(-1);
                break;
        }
    }
}
