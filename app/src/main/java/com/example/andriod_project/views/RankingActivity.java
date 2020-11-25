package com.example.andriod_project.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;
import com.example.andriod_project.adapters.RankingAdapter;
import com.example.andriod_project.models.ItemData;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class RankingActivity extends AppCompatActivity {

    private ListView listview;
    // mySQL 접근용 변수 선언
    Retrofit retrofit;
    RemoteService remoteService;
    List<ItemData> ArrayRanker;
    Intent intent;
    RankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ImageView backbtn = (ImageView) findViewById(R.id.backBtn);
        ImageView homebtn = (ImageView) findViewById(R.id.homeBtn);


        listview = (ListView)findViewById(R.id.listView1);
        ArrayRanker = new ArrayList<>();
        adapter = new RankingAdapter();
        listview.setAdapter(adapter);


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);
        /*이동할 액티비티 삽입
        Intent intent = new Intent(getApplicationContext(), );
        */
        getRankerInfo();

    
        /*랭커 정보(등수, 닉네임, 점수) 차례대로 대입하는 부분
        ArrayList<ItemData> oData = new ArrayList<>();
        for(int i = 0;i<10;++i){
            ItemData oltem = new ItemData();
            oltem.strRanking = ""+(i+1); //순위는 고정 1~10 차례대로
            oltem.strNickame = "닉네임" + (i+1); //데이터베이스에서 가져온 닉네임 넣는 부분
            oltem.strRankpoint = ""+(i+100); //데이터베이스에서 가져온 랭킹점수 넣는 부분
            oData.add(oltem);
            if(nDatCnt >= putRanker.length) nDatCnt=0;
        }
        */

        //Listview, Adapter 생성 및 연결


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
        Call<List<ItemData>> call = remoteService.ranking("userrankpoint", "");
        call.enqueue(new Callback<List<ItemData>>() {
            @Override
            public void onResponse(Call<List<ItemData>> call, Response<List<ItemData>> response) {
                ArrayRanker = response.body();
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<ItemData>> call, Throwable t) { }
        });
    }
}