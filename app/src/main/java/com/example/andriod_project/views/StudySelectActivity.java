package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.andriod_project.R;
import com.example.andriod_project.models.QuestionVO;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class StudySelectActivity extends AppCompatActivity {

    ImageButton ComputerBtn, CurrentEventBtn, IdiomBtn, IndustrialRevolutionBtn, NeologismBtn, PeripheralBtn, PhilosophyBtn, PsychologyBtn, ReligionBtn, ScienceBtn;
    Intent intent;
    // 파이어베이스 접속용 변수 선언
    FirebaseAuth mAuth;

    // mySQL 접근용 변수 선언
    Retrofit retrofit;
    RemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_select);

        ComputerBtn = (ImageButton) findViewById(R.id.ComputerBtn);
        CurrentEventBtn = (ImageButton) findViewById(R.id.CurrentEventBtn);
        IdiomBtn = (ImageButton) findViewById(R.id.IdiomBtn);
        IndustrialRevolutionBtn = (ImageButton) findViewById(R.id.IndustrialRevolutionBtn);
        NeologismBtn = (ImageButton) findViewById(R.id.NeologismBtn);
        PeripheralBtn = (ImageButton) findViewById(R.id.PeripheralBtn);
        PhilosophyBtn = (ImageButton) findViewById(R.id.PhilosophyBtn);
        PsychologyBtn = (ImageButton) findViewById(R.id.PsychologyBtn);
        ReligionBtn = (ImageButton) findViewById(R.id.ReligionBtn);
        ScienceBtn = (ImageButton) findViewById(R.id.ScienceBtn);

        mAuth = FirebaseAuth.getInstance();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

    }

    public void QuestionButtonSystem(View view) {
        switch (view.getId()) {
            case R.id.ComputerBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.CurrentEventBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.IdiomBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.IndustrialRevolutionBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.NeologismBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.PeripheralBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.PhilosophyBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.PsychologyBtn:
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.ReligionBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
            case R.id.ScienceBtn :
                // 회원가입 화면으로 화면 전환
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void getQuestionInfo(String userId) {
        Call<QuestionVO> call = remoteService.loginUser(questioned);
        call.enqueue(new Callback<QuestionVO>() {
            @Override
            public void onResponse(Call<QuestionVO> call, Response<QuestionVO> response) {
                QuestionVO QuestionVO = response.body();

                System.out.println("---------------\n");
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                intent.putExtra("questionid", QuestionVO.questionid());
                intent.putExtra("content", QuestionVO.getContent());
                intent.putExtra("selection1", QuestionVO.getSelection1());
                intent.putExtra("selection2", QuestionVO.getSelection2());
                intent.putExtra("selection3", QuestionVO.getSelection3());
                intent.putExtra("selection4", QuestionVO.getSelection4());
                intent.putExtra("exsummary",QuestionVO.getExsummary());
                intent.putExtra("exdetail",QuestionVO.getExdetail());
                intent.putExtra("answer",QuestionVO.getAnswer());
                startActivity(intent);
                finish();
            }
            @Override
            public void onFailure(Call<QuestionVO> call, Throwable t) { }
        });
    }


}