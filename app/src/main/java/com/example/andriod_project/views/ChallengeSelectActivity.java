package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.andriod_project.R;

public class ChallengeSelectActivity extends AppCompatActivity {

    ConstraintLayout popupConstraint;
    PopupWindow userInfoPopup;
    View popupView;

    TextView userNicknameTxtView, nicknameTxtView, idTxtView, nameTxtView, rankPointTxt, solveProblemTxt, correctProblemTxt;
    ImageButton userInfoCloseBtn;


    Intent intent;
    String userId, userName, userNickname;
    int userRankPoint, userSolveProblem, userCorrectProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_select);

        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);

        // 팝업 윈도우 정의 및 구현
        popupConstraint = findViewById(R.id.challengeModeConstraint);
        popupView = View.inflate(this, R.layout.popup_userinfo, null);
        userInfoPopup = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);

        // 유저 정보 팝업 윈도우 화면 텍스트뷰 아이디 정의
        nicknameTxtView = popupView.findViewById(R.id.nicknameTxtView);
        idTxtView = popupView.findViewById(R.id.idTxtView);
        nameTxtView = popupView.findViewById(R.id.nameTxtView);
        rankPointTxt = popupView.findViewById(R.id.rankPointTxt);
        solveProblemTxt = popupView.findViewById(R.id.solveProblemTxt);
        correctProblemTxt = popupView.findViewById(R.id.correctProblemTxt);

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

    public void challengeModeQuestionButtonSystem(View view) {
        switch (view.getId()) {
            case R.id.ComputerBtn :
                String computer = "computer";
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                intent.putExtra("questionCategory", computer);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.CurrentEventBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String currentevens = "";
                intent.putExtra("questionCategory", currentevens);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.IdiomBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String idiom = "idiom";
                intent.putExtra("questionCategory", idiom);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.IndustrialRevolutionBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String industrialrevolution = "industrialrevolution";
                intent.putExtra("questionCategory", industrialrevolution);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.NeologismBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String neologism = "neologism";
                intent.putExtra("questionCategory", neologism);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.PeripheralBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String peripheral = "peripheral";
                intent.putExtra("questionCategory", peripheral);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.PhilosophyBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String philosophy = "philosophy";
                intent.putExtra("questionCategory", philosophy);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.PsychologyBtn:
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String psychologhy = "psychologhy";
                intent.putExtra("questionCategory", psychologhy);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.ReligionBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String religion = "religion";
                intent.putExtra("questionCategory", religion);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.ScienceBtn :
                intent = new Intent(ChallengeSelectActivity.this, RecyclerSolutionActivity.class);
                String science = "science";
                intent.putExtra("questionCategory", science);
                intent.putExtra("userId", userId);
                startActivity(intent);
                onStop();
                break;
            case R.id.back :
                finish();
                break;
            case R.id.home :
                intent = new Intent(ChallengeSelectActivity.this, MainHomeActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("userName", userName);
                intent.putExtra("userNickname", userNickname);
                intent.putExtra("userRankPoint", userRankPoint);
                intent.putExtra("userSolveProblem", userSolveProblem);
                intent.putExtra("userCorrectProblem", userCorrectProblem);
                startActivity(intent);
                finish();
                break;
            case R.id.rankBtn :
                intent = new Intent(ChallengeSelectActivity.this, RankingActivity.class);
                intent.putExtra("userNickname", userNickname);
                System.out.println("---------------------\n");
                startActivity(intent);
                onStop();
                break;
        }
    }
}