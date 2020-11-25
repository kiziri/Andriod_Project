package com.example.andriod_project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.ChallengeAdapter;

public class ChallengeModeActivity extends AppCompatActivity {

    ChallengeAdapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode);

        ImageView back, home, category;

        //이미지뷰 지정
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);
        category = (ImageView) findViewById(R.id.category);

        //뷰페이저 설정
        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new ChallengeAdapter(this);
        viewPager.setAdapter(adapter);

        //각 이미지 뷰에 대한 클릭 리스너
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로 가기 버튼 클릭",
                        Toast.LENGTH_SHORT).show();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "홈으로 가기 버튼 클릭",
                        Toast.LENGTH_SHORT).show();
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "분야선택 버튼 클릭",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}