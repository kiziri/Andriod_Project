package com.example.team_braintraining;

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

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        ImageView backbtn = (ImageView) findViewById(R.id.backBtn);
        ImageView homebtn = (ImageView) findViewById(R.id.homeBtn);
        /*이동할 액티비티 삽입
        Intent intent = new Intent(getApplicationContext(), );
        */

        //추후 랭킹 인원 확대할 수 있으므로 배열로 구현
        String[] ranker = new String[10]; //데이터베이스에서 가져온 상위 10명 정보

        //데이터베이스에서 데이터 가져와서 ranker 배열에 넣는 부분

        /*
       //가져온 랭커 데이터 리스트뷰에 삽입
       final String[] putRanker={ranker[0], ranker[1], ranker[2], ranker[3], ranker[4], ranker[5], ranker[6], ranker[7],
            ranker[8], ranker[9]};
       */
        //시험용 데이터 삽입
        final String[] putRanker={"오덕왕", "오덕왕 부하1", "오덕왕 부하2", "오덕왕 부하3", "오덕왕 부하4", "오덕왕 부하5",
                "오덕왕 부하6", "오덕왕 부하7", "오덕왕 부하8", "오덕왕 부하9"};

        ListView list = (ListView)findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, putRanker);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),putRanker[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
        
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