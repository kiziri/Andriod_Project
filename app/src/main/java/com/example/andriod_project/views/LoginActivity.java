package com.example.andriod_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class LoginActivity extends AppCompatActivity {

    EditText idEdtText, pwEdtText;
    Button loginButton;
    Intent intent;

    // 파이어베이스 접속용 변수 선언
    FirebaseAuth mAuth;

    // mySQL 접근용 변수 선언
    Retrofit retrofit;
    RemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        idEdtText = findViewById(R.id.idEdtTxt);
        pwEdtText = findViewById(R.id.pwEdtTxt);
        loginButton = findViewById(R.id.loginBtn);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getId = idEdtText.getText().toString();
                String getPw = pwEdtText.getText().toString();

                // 유저 회원 로그인 확인 메소드 호출
                userLogin(getId, getPw);
            }
        });
    }

    // 유저 로그인 확인 메소드
    public void userLogin(final String userEmail, String userPassword) {
        mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser fUser = mAuth.getCurrentUser();
                    Toast.makeText(LoginActivity.this, "User login Successful", Toast.LENGTH_SHORT).show();
                    getLoginUserInfo(userEmail);
                }
                else {
                    Toast.makeText(LoginActivity.this, "User login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // MySQL DB에서 회원 정보를 가져오는 메소드
    public void getLoginUserInfo(String userId) {
        Call<UserVO> call = remoteService.loginUser(userId);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                UserVO userVO = response.body();

                System.out.println("---------------\n");
                intent = new Intent(LoginActivity.this, MainHomeActivity.class);
                intent.putExtra("userId", userVO.getUserid());
                intent.putExtra("userName", userVO.getUsername());
                intent.putExtra("userNickname", userVO.getUsernickname());
                intent.putExtra("userRankPoint", userVO.getUserrankpoint());
                intent.putExtra("userSolveProblem", userVO.getUsersolveproblem());
                intent.putExtra("userCorrectProblem", userVO.getUsercorrectproblem());
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {

            }
        });
    }
}