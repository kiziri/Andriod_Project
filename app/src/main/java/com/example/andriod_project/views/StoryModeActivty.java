package com.example.andriod_project.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.Adapter;

public class StoryModeActivty extends AppCompatActivity {

    Adapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView back, home;

        //이미지 뷰 지정
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);

        //뷰페이저 설정
        viewPager = (ViewPager) findViewById(R.id.view);
        adapter = new Adapter(this);
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
    }
}

