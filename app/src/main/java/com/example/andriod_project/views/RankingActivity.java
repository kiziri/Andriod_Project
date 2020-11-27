package com.example.andriod_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.RankingAdapter;
import com.example.andriod_project.models.RankingVO;
import com.example.andriod_project.models.RemoteService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class RankingActivity extends AppCompatActivity {

    ListView listview;

    // mySQL 접근용 변수 선언
    Retrofit retrofit;
    RemoteService remoteService;
    List<RankingVO> arrayRanker;
    LayoutInflater inflater;
    RankingAdapter adapter;

    TextView userNicknameTxtView;
    Intent intent;

    String userNickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ImageView backbtn = (ImageView) findViewById(R.id.backBtn);
        ImageView homebtn = (ImageView) findViewById(R.id.homeBtn);
        userNicknameTxtView = findViewById(R.id.userNicknameTxtView);   // 화면 상단 회원 닉네임 텍스트뷰 아이디

        intent = getIntent();
        userNickname = intent.getStringExtra("userNickname");

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

        // 로그인한 유저의 닉네임을 메인 화면의 닉네임 부분에 세팅
        userNicknameTxtView.setText(userNickname);

        //Listview, Adapter 생성 및 연결
        listview = (ListView)findViewById(R.id.listView1);
        arrayRanker = new ArrayList<>();
        inflater = getLayoutInflater();
        adapter = new RankingAdapter(arrayRanker, inflater);  // 어댑터 클래스가 외부에 선언되어 있으므로, 이를 무엇이 가져가는지 확인하기 위해
        listview.setAdapter(adapter);
        
        // 리스트 갱신을 위한 어댑터 호출
        getRankerInfo();


        
        //back버튼 누르면 다른 화면으로 전환
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        //home버튼 누르면 다른 화면으로 전환
        homebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                finish();
            }
        });
    }

    // MySQL DB에서 회원 정보를 가져오는 메소드
    public void getRankerInfo() {
        arrayRanker.clear();    // ArrayList 초기화 함수
        Call<List<RankingVO>> call = remoteService.ranking();
        call.enqueue(new Callback<List<RankingVO>>() {
            @Override
            public void onResponse(Call<List<RankingVO>> call, Response<List<RankingVO>> response) {
                arrayRanker = response.body();
                System.out.println(arrayRanker.size());
                adapter.notifyDataSetChanged();
                System.out.println("------------랭킹");
            }
            @Override
            public void onFailure(Call<List<RankingVO>> call, Throwable t) { }
        });
    }
}