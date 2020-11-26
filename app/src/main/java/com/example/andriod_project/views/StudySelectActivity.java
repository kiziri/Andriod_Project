package com.example.andriod_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;
import com.example.andriod_project.models.RemoteService;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class StudySelectActivity extends AppCompatActivity {

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

        mAuth = FirebaseAuth.getInstance();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

    }

    public void QuestionButtonSystem(View view) {
        switch (view.getId()) {
            case R.id.ComputerBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String computer = "";
                intent.putExtra("computer",computer );
                startActivity(intent);
                break;
            case R.id.CurrentEventBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String currentevens = "";
                intent.putExtra("currentevens", currentevens);
                startActivity(intent);
                break;
            case R.id.IdiomBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String idiom = "";
                intent.putExtra("idiom", idiom);
                startActivity(intent);
                break;
            case R.id.IndustrialRevolutionBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String industrialrevolution = "";
                intent.putExtra("industrialrevolution", industrialrevolution);
                startActivity(intent);
                break;
            case R.id.NeologismBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String neologism = "";
                intent.putExtra("neologism", neologism);
                startActivity(intent);
                break;
            case R.id.PeripheralBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String peripheral = "";
                intent.putExtra("peripheral", peripheral);
                startActivity(intent);
                break;
            case R.id.PhilosophyBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String philosophy = "";
                intent.putExtra("philosophy", philosophy);
                startActivity(intent);
                break;
            case R.id.PsychologyBtn:
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String psychologhy = "";
                intent.putExtra("psychologhy", psychologhy);
                startActivity(intent);
                break;
            case R.id.ReligionBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String religion = "";
                intent.putExtra("religion", religion);
                startActivity(intent);
                break;
            case R.id.ScienceBtn :
                intent = new Intent(StudySelectActivity.this, SolutionActivity.class);
                String science = "";
                intent.putExtra("science", science);
                startActivity(intent);
                break;
        }
    }
}