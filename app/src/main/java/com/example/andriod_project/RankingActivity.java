package com.example.andriod_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rankingactivity.R;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private ListView listview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView backbtn = (ImageView) findViewById(R.id.backBtn);
        ImageView homebtn = (ImageView) findViewById(R.id.homeBtn);
        int nDatCnt = 0;
        /*이동할 액티비티 삽입
        Intent intent = new Intent(getApplicationContext(), );
        */

        //추후 랭킹 인원 확대할 수 있으므로 배열로 구현
        String[] ranker = new String[10]; //데이터베이스에서 가져온 상위 10명 정보
        Integer [] rankpoint = new Integer[10]; //데이터베이스에서 가져온 상위 10명의 랭킹점수 정보
        //데이터베이스에서 데이터 가져와서 ranker 배열에 넣는 부분

        /*
       //가져온 랭커 데이터 리스트뷰에 삽입
       final String[] putRanker={ranker[0], ranker[1], ranker[2], ranker[3], ranker[4], ranker[5], ranker[6], ranker[7],
            ranker[8], ranker[9]};
       */
        //시험용 데이터 삽입
        final String[] putRanker={"오덕왕", "오덕왕 부하1", "오덕왕 부하2", "오덕왕 부하3", "오덕왕 부하4", "오덕왕 부하5",
                "오덕왕 부하6", "오덕왕 부하7", "오덕왕 부하8", "오덕왕 부하9"};
    
        //랭커 정보(등수, 닉네임, 점수) 차례대로 대입하는 부분
        ArrayList<com.example.andriod_project.ItemData> oData = new ArrayList<>();
        for(int i = 0;i<10;++i){
            com.example.andriod_project.ItemData oltem = new com.example.andriod_project.ItemData();
            oltem.strRanking = ""+(i+1); //순위는 고정 1~10 차례대로
            oltem.strNickame = "닉네임" + (i+1); //데이터베이스에서 가져온 닉네임 넣는 부분
            oltem.strRankpoint = ""+(i+100); //데이터베이스에서 가져온 랭킹점수 넣는 부분
            oData.add(oltem);
            if(nDatCnt >= putRanker.length) nDatCnt=0;
        }

        //Listview, Adapter 생성 및 연결
        listview = (ListView)findViewById(R.id.listView1);
        ListAdapter adapter = new ListAdapter(oData);
        listview.setAdapter(adapter);

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
}