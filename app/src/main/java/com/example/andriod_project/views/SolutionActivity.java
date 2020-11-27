package com.example.andriod_project.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;
import com.example.andriod_project.models.QuestionVO;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class SolutionActivity extends AppCompatActivity {
    //변수 선언
    RadioGroup radioGroup; //선택지 라디오 그룹
    RadioButton selRadioBtn1,selRadioBtn2, selRadioBtn3, selRadioBtn4; //라디오 그룹 내부 선택지 4개 라디오 버튼

    TextView qTextView, exsumTextView, exdetTextView; //질문 텍스트 뷰, 요약과 자세한 설명 텍스트 뷰
    Button exsummary_btn, exdetail_btn; //요약 버튼, 자세히 버튼
    ImageView backstage;

    Intent intent;

    String userId, userName, userNickname, userStoryModeLevel, selection1,  selection2,  selection3,  selection4;
    String content, exsummary, exdetail;
    int userRankPoint, userSolveProblem, userCorrectProblem, userStoryModeStage, questionid, answer;

    Retrofit retrofit;
    RemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

        //변수 대입
        exsummary_btn = (Button)findViewById(R.id.exSummary); //요약 버튼
        exdetail_btn = (Button)findViewById(R.id.exDetail); //자세히 버튼
        exsumTextView = (TextView)findViewById(R.id.summaryText); //요약 해설 텍스트 뷰
        exdetTextView = (TextView)findViewById(R.id.detailText); //자세한 해설 텍스트 뷰
        radioGroup = (RadioGroup)findViewById(R.id.selectionRadioG); //선택지 4개를 담은 라디오 그룹
        selRadioBtn1 = (RadioButton)findViewById(R.id.selectionRadio1); //선택지 4개
        selRadioBtn2 = (RadioButton)findViewById(R.id.selectionRadio2);
        selRadioBtn3 = (RadioButton)findViewById(R.id.selectionRadio3);
        selRadioBtn4 = (RadioButton)findViewById(R.id.selectionRadio4);
        qTextView = (TextView)findViewById(R.id.qeustionTextView); //문제 출력하는 텍스트
        backstage = (ImageView)findViewById(R.id.backstage); //돌아가기 버튼

        //처음에 해설 버튼 안 보이게 함과 동시에 칸 안 차지하게 GONE으로 변경
        exsummary_btn.setVisibility(View.GONE);
        exdetail_btn.setVisibility(View.GONE);

        //처음에는 해설 텍스트 뷰 안 보이게 함과 동시에 칸 안 차지하게 GONE으로 변경
        exsumTextView.setVisibility(View.GONE);
        exdetTextView.setVisibility(View.GONE);

        //스토리모드 값 받음
        intent = getIntent();
        userId = intent.getStringExtra("userId");
        userName = intent.getStringExtra("userName");
        userNickname = intent.getStringExtra("userNickname");
        userRankPoint = intent.getIntExtra("userRankPoint", 0);
        userSolveProblem = intent.getIntExtra("userSolveProblem", 0);
        userCorrectProblem = intent.getIntExtra("userCorrectProblem", 0);
        userStoryModeStage = intent.getIntExtra("userstorymodestage", 0);
        userStoryModeLevel = intent.getStringExtra("userstorymodelevel");
        System.out.println("---------------------\n");
        System.out.println("" + userId + "/" + userStoryModeStage  + "/" +userStoryModeLevel);

        //데이터베이스 연동
        getQuestionInfo(userStoryModeLevel, userStoryModeStage);

        //해설 화면은 이미 선택하고 정답 체크가 된 상태이기 때문에 라디오 버튼에 리스너 없음
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //라디오버튼 클릭 이벤트
                backstage.setVisibility(View.VISIBLE);
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.selectionRadio1:
                        exsummary_btn.setVisibility(View.VISIBLE);
                        exdetail_btn.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);
                        //정답체크
                        if(answer == 1){
                            selRadioBtn1.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn1.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio2:
                        exsummary_btn.setVisibility(View.VISIBLE);
                        exdetail_btn.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);
                        //정답체크
                        if(answer == 2){
                            selRadioBtn2.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn2.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio3:
                        exsummary_btn.setVisibility(View.VISIBLE);
                        exdetail_btn.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);
                        //정답체크
                        if(answer == 3){
                            selRadioBtn3.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn3.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio4:
                        exsummary_btn.setVisibility(View.VISIBLE);
                        exdetail_btn.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);
                        //정답체크
                        if(answer == 4){
                            selRadioBtn4.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn4.setTextColor(Color.RED);
                        }
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "에러", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //요약 버튼 리스너(요약 텍스트 뷰가 VISIBLE 상태이면 GONE으로, GONE 상태이면 VISIBLE 상태로 변경)
        exsummary_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (exsumTextView.getVisibility() == View.VISIBLE) {
                    exsumTextView.setVisibility(View.GONE);
                } else {
                    exsumTextView.setVisibility(View.VISIBLE);
                }
            }});

        //자세히 버튼 리스너(자세히 텍스트 뷰가 VISIBLE 상태이면 GONE으로, GONE 상태이면 VISIBLE 상태로 변경)
        exdetail_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (exdetTextView.getVisibility() == View.VISIBLE) {
                    exdetTextView.setVisibility(View.GONE);
                } else {
                    exdetTextView.setVisibility(View.VISIBLE);
                }
            }});
        backstage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getBackStageInfo(userStoryModeLevel, userStoryModeStage, userId);
                intent = new Intent(SolutionActivity.this, StoryModeActivity.class);
                intent.putExtra("userId", userId);
                intent.putExtra("userName", userName);
                intent.putExtra("userNickname", userNickname);
                intent.putExtra("userRankPoint", userRankPoint);
                intent.putExtra("userSolveProblem", userSolveProblem);
                intent.putExtra("userCorrectProblem", userCorrectProblem);
                startActivity(intent);
                finish();
            }});

    }

    public void getQuestionInfo(String userStoryModeLevel, int userStoryModeStage) {
        Call<QuestionVO> call = remoteService.storymodequestion(userStoryModeLevel + "question", userStoryModeStage);
        call.enqueue(new Callback<QuestionVO>() {
            @Override
            public void onResponse(Call<QuestionVO> call, Response<QuestionVO> response) {
                QuestionVO questionVO = response.body();

                System.out.println("--------------DB 불러오기 성공\n");
                selection1 = questionVO.getSelection1();
                selection2 = questionVO.getSelection2();
                selection3 = questionVO.getSelection3();
                selection4 = questionVO.getSelection4();
                questionid = questionVO.getQuestionid();
                content = questionVO.getContent();
                exsummary = questionVO.getExsummary();
                exdetail = questionVO.getExdetail();
                answer = questionVO.getAnswer();
                System.out.println("--------------\n");
                System.out.println("" + selection1 + "\n" + selection2 + "\n" + selection3 + "\n" +
                        selection4 + "\n" + questionid + "\n" + content + "\n" + exsummary + "\n" +
                        exdetail + "\n" + answer);

                exsumTextView.setText(exsummary);
                exdetTextView.setText(exdetail);
                selRadioBtn1.setText(selection1);
                selRadioBtn2.setText(selection2);
                selRadioBtn3.setText(selection3);
                selRadioBtn4.setText(selection4);
                qTextView.setText(content);
            }
            @Override
            public void onFailure(Call<QuestionVO> call, Throwable t) {
            }
        });
    }

    public void getBackStageInfo(String userStoryModeLevel, int userStoryModeStage, String userId) {
        UserVO userVO = new UserVO();

        System.out.println(userStoryModeLevel + "/" + userStoryModeStage + "/" + userId);

        if (userStoryModeStage < 50) {
            int stage;
            stage = userStoryModeStage + 1;

            userVO.setUserid(userId);
            userVO.setUserstorymodelevel(userStoryModeLevel);
            userVO.setUserstorymodestage(stage);

            Call<UserVO> call = remoteService.saveStoryModeData(userVO.getUserstorymodelevel(), userVO.getUserstorymodestage(), userVO.getUserid());
            call.enqueue(new Callback<UserVO>() {
                @Override
                public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                    System.out.println(userVO.getUserstorymodelevel() + "/" + userVO.getUserstorymodestage() + "/" + userVO.getUserid());
                }
                @Override
                public void onFailure(Call<UserVO> call, Throwable t) {}
            });
        }
        else if (userStoryModeStage == 50) {
            if (userStoryModeLevel.equals("easy")) {
                int stage;
                String StoryMode;
                stage = 1;
                StoryMode = "mid";

                userVO.setUserid(userId);
                userVO.setUserstorymodelevel(StoryMode);
                userVO.setUserstorymodestage(stage);

                Call<UserVO> call = remoteService.saveStoryModeData(userVO.getUserstorymodelevel(), userVO.getUserstorymodestage(), userVO.getUserid());
                call.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        System.out.println(userVO.getUserstorymodelevel() + "/" + userVO.getUserstorymodestage() + "/" + userVO.getUserid());
                    }
                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) {}
                });
            }

            else if (userStoryModeLevel.equals("mid")) {
                int stage;
                String StoryMode;
                stage = 1;
                StoryMode = "hard";

                userVO.setUserid(userId);
                userVO.setUserstorymodelevel(StoryMode);
                userVO.setUserstorymodestage(stage);

                Call<UserVO> call = remoteService.saveStoryModeData(userVO.getUserstorymodelevel(), userVO.getUserstorymodestage(), userVO.getUserid());
                call.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        System.out.println(userVO.getUserstorymodelevel() + "/" + userVO.getUserstorymodestage() + "/" + userVO.getUserid());
                    }
                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) {}
                });
            }

            else if (userStoryModeLevel.equals("hard")) {
                userVO.setUserid(userId);
                userVO.setUserstorymodelevel(userStoryModeLevel);
                userVO.setUserstorymodestage(userStoryModeStage);

                Call<UserVO> call = remoteService.saveStoryModeData(userVO.getUserstorymodelevel(), userVO.getUserstorymodestage(), userVO.getUserid());
                call.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        System.out.println(userVO.getUserstorymodelevel() + "/" + userVO.getUserstorymodestage() + "/" + userVO.getUserid());
                    }
                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) {}
                });
            }
        }
    }
}
