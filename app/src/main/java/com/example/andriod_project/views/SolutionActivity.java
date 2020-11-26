package com.example.andriod_project.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andriod_project.R;

public class SolutionActivity extends AppCompatActivity {
    //변수 선언
    RadioGroup radioGroup; //선택지 라디오 그룹
    RadioButton selRadioBtn1,selRadioBtn2, selRadioBtn3, selRadioBtn4; //라디오 그룹 내부 선택지 4개 라디오 버튼
    TextView qTextView, exsumTextView, exdetTextView; //질문 텍스트 뷰, 요약과 자세한 설명 텍스트 뷰
    Button exsummary, exdetail; //요약 버튼, 자세히 버튼
    Intent intent;
    String computer, currentevens, idiom, industrialrevolution, neologism, peripheral, philosophy, psychologhy, religion, science;
    static boolean answerCorrect = false; //정답인지 아닌지 구분
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        //변수 대입
        exsummary = (Button)findViewById(R.id.exSummary); //요약 버튼
        exdetail = (Button)findViewById(R.id.exDetail); //자세히 버튼
        exsumTextView = (TextView)findViewById(R.id.summaryText); //요약 해설 텍스트 뷰
        exdetTextView = (TextView)findViewById(R.id.detailText); //자세한 해설 텍스트 뷰
        radioGroup = (RadioGroup)findViewById(R.id.selectionRadioG); //선택지 4개를 담은 라디오 그룹
        selRadioBtn1 = (RadioButton)findViewById(R.id.selectionRadio1); //선택지 4개
        selRadioBtn2 = (RadioButton)findViewById(R.id.selectionRadio2);
        selRadioBtn3 = (RadioButton)findViewById(R.id.selectionRadio3);
        selRadioBtn4 = (RadioButton)findViewById(R.id.selectionRadio4);
        qTextView = (TextView)findViewById(R.id.qeustionTextView); //문제 출력하는 텍스트

        //이 부분에서 데이터베이스 연동
        //문제 정보, 선택지, 해설, 답 가져와야 됨


        //처음에 해설 버튼 안 보이게 함과 동시에 칸 안 차지하게 GONE으로 변경
        exsummary.setVisibility(View.GONE);
        exdetail.setVisibility(View.GONE);

        //처음에는 해설 텍스트 뷰 안 보이게 함과 동시에 칸 안 차지하게 GONE으로 변경
        exsumTextView.setVisibility(View.GONE);
        exdetTextView.setVisibility(View.GONE);

        //분야선택 값 받음
        intent = getIntent();
        computer = intent.getStringExtra("computer");
        currentevens = intent.getStringExtra("currentevens");
        idiom = intent.getStringExtra("idiom");
        industrialrevolution = intent.getStringExtra("industrialrevolution");
        neologism = intent.getStringExtra("neologism");
        peripheral = intent.getStringExtra("peripheral");
        philosophy = intent.getStringExtra("philosophy");
        psychologhy = intent.getStringExtra("psychologhy");
        religion = intent.getStringExtra("religion");
        science = intent.getStringExtra("science");


        //해설 화면은 이미 선택하고 정답 체크가 된 상태이기 때문에 라디오 버튼에 리스너 없음
        //사용자가 선택한 선택지로 정답 체크 후 오답이면 선택지 빨간색 정답은 초록색. 정답을 선택했을 경우 선택지=정답 초록색
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //정답 체크(정답이면 글자 색깔 초록색으로 변경, 오답이면 빨강으로 변경)

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.selectionRadio1:
                        exsummary.setVisibility(View.VISIBLE);
                        exdetail.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);

                        //여기서 정답 체크해서 answerCorrect 변수 true로 바꿔줘야 함

                        if(answerCorrect){
                            selRadioBtn1.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn1.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio2:
                        exsummary.setVisibility(View.VISIBLE);
                        exdetail.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);

                        //여기서 정답 체크해서 answerCorrect 변수 true로 바꿔줘야 함

                        if(answerCorrect){
                            selRadioBtn2.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn2.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio3:
                        exsummary.setVisibility(View.VISIBLE);
                        exdetail.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);

                        //여기서 정답 체크해서 answerCorrect 변수 true로 바꿔줘야 함

                        if(answerCorrect){
                            selRadioBtn3.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn3.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio4:
                        exsummary.setVisibility(View.VISIBLE);
                        exdetail.setVisibility(View.VISIBLE);
                        selRadioBtn1.setEnabled(false);
                        selRadioBtn2.setEnabled(false);
                        selRadioBtn3.setEnabled(false);
                        selRadioBtn4.setEnabled(false);

                        //여기서 정답 체크해서 answerCorrect 변수 true로 바꿔줘야 함

                        if(answerCorrect){
                            selRadioBtn4.setTextColor(Color.GREEN);
                        }else{
                            selRadioBtn4.setTextColor(Color.RED);
                        }
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "에러", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //요약 버튼 리스너(요약 텍스트 뷰가 VISIBLE 상태이면 GONE으로, GONE 상태이면 VISIBLE 상태로 변경)
        exsummary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (exsumTextView.getVisibility() == View.VISIBLE) {
                    exsumTextView.setVisibility(View.GONE);
                } else {
                    exsumTextView.setVisibility(View.VISIBLE);
                }
            }});

        //자세히 버튼 리스너(자세히 텍스트 뷰가 VISIBLE 상태이면 GONE으로, GONE 상태이면 VISIBLE 상태로 변경)
        exdetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (exdetTextView.getVisibility() == View.VISIBLE) {
                    exdetTextView.setVisibility(View.GONE);
                } else {
                    exdetTextView.setVisibility(View.VISIBLE);
                }
            }});

    }

}
