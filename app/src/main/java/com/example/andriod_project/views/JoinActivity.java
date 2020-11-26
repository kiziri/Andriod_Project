package com.example.andriod_project.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

public class JoinActivity extends AppCompatActivity {

    EditText emailEdit, passEdit, nameEdit, nicknameEdit;
    Intent intent;

    // 파이어베이스 접속용 변수 선언
    FirebaseAuth mAuth;
    FirebaseUser user;

    // mySQL 접근용 변수 선언
    Retrofit retrofit;
    RemoteService remoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();
        emailEdit = findViewById(R.id.edtEmail);
        passEdit = findViewById(R.id.edtPassword);
        nameEdit = findViewById(R.id.edtName);
        nicknameEdit = findViewById(R.id.edtNickname);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);
    }

    public void userSystem(View view) {
        String getId = emailEdit.getText().toString();
        String getPw = passEdit.getText().toString();
        String getName = nameEdit.getText().toString();
        String getNickname = nicknameEdit.getText().toString();

        switch (view.getId()) {
            case R.id.btnRegister :
                if (getId.indexOf('@') < 0) {
                    Toast.makeText(JoinActivity.this, "Input type like Email", Toast.LENGTH_SHORT).show();
                }
                else if (getPw.length() < 8) {
                    Toast.makeText(JoinActivity.this, "Input least 8 letter", Toast.LENGTH_SHORT).show();
                }
                else if (getName.length() < 0) {
                    Toast.makeText(JoinActivity.this, "Input name", Toast.LENGTH_SHORT).show();
                }
                else if (getNickname.length() < 0) {
                    Toast.makeText(JoinActivity.this, "Input nickname", Toast.LENGTH_SHORT).show();
                }
                else {
                    userRegister(getId, getPw, getName, getNickname);
                }
                break;
            case R.id.btnCancel :
                System.out.println("------------추가 취소");
                finish();
                break;
        }

    }

    public void userRegister(String userEmail, String userPassword, String userName, String userNickname) {
        mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    user = mAuth.getCurrentUser();
                    userRegisterForMySQL(userEmail,userPassword,userName,userNickname);
                    setResult(RESULT_OK);
                    System.out.println("------------추가 성공");
                }
                else {
                    setResult(RESULT_CANCELED);
                    System.out.println("------------추가 실패");
                }
                finish();
            }
        });
    }

    public void userRegisterForMySQL(String userEmail, String userPassword, String userName, String userNickname) {

        UserVO userVO = new UserVO();
        int userRankPoint = 0;
        int userSolveProblem = 0;
        int userCorrectProblem = 0;
        String userStoryModeLevel = "easy";
        int userStoryModeStage = 1;
        userVO.setUserid(userEmail);
        userVO.setUserpw(userPassword);
        userVO.setUsername(userName);
        userVO.setUsernickname(userNickname);
        userVO.setUserrankpoint(userRankPoint);
        userVO.setUsersolveproblem(userSolveProblem);
        userVO.setUsercorrectproblem(userCorrectProblem);
        userVO.setUserstorymodelevel(userStoryModeLevel);
        userVO.setUserstorymodestage(userStoryModeStage);

        Call<Void> call = remoteService.insertUser(userVO.getUserid(), userVO.getUserpw(), userVO.getUsername(), userVO.getUsernickname(),
                userVO.getUserrankpoint(), userVO.getUsersolveproblem(), userVO.getUsercorrectproblem(), userVO.getUserstorymodelevel(), userVO.getUserstorymodestage());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("---------------DB 저장 성공\n");
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) { }
        });
    }
}