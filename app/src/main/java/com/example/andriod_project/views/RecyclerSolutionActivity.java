package com.example.andriod_project.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.RecyclerSolutionAdapter;
import com.example.andriod_project.models.QuestionVO;
import com.example.andriod_project.models.RemoteService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class RecyclerSolutionActivity extends AppCompatActivity {

    RecyclerView challengeModeSolution;
    ArrayList<QuestionVO> arrayQuestionList;
    RecyclerSolutionAdapter solutionAdapter;

    Retrofit retrofit;
    RemoteService remoteService;

    Intent intent;
    String questionCategory, userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_solution);

        intent = getIntent();
        questionCategory = intent.getStringExtra("questionCategory");
        userId = intent.getStringExtra("userId");

        // MySQL 접속 연동 정의 구현
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

        // 문제 데이터 저장하기 위한 ArrayList 정의
        arrayQuestionList = new ArrayList<QuestionVO>();

        challengeModeSolution = findViewById(R.id.solutionRecyclerView);
        challengeModeSolution.setLayoutManager(new LinearLayoutManager(RecyclerSolutionActivity.this, LinearLayoutManager.HORIZONTAL, false));

        getQuestionData(questionCategory);
    }

    public void getQuestionData(String questionCategory) {
        arrayQuestionList.clear();
        Call<ArrayList<QuestionVO>> call = remoteService.challengemodequestion(questionCategory);
        call.enqueue(new Callback<ArrayList<QuestionVO>>() {
            @Override
            public void onResponse(Call<ArrayList<QuestionVO>> call, Response<ArrayList<QuestionVO>> response) {
                arrayQuestionList = response.body();
                solutionAdapter = new RecyclerSolutionAdapter(getApplicationContext(), arrayQuestionList, userId);
                // RecyclerView 정의
                System.out.println(arrayQuestionList.size());
                challengeModeSolution.setAdapter(solutionAdapter);
            }
            @Override
            public void onFailure(Call<ArrayList<QuestionVO>> call, Throwable t) { }
        });
    }
}