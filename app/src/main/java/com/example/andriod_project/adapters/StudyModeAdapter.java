package com.example.andriod_project.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.example.andriod_project.R;
import com.example.andriod_project.views.RecyclerSolutionActivity;

public class StudyModeAdapter extends PagerAdapter {

    //이미지가 들어가는 배열
    int[] images = {R.drawable.easy_btn, R.drawable.normal_btn, R.drawable.hard_btn};
    Intent intent;

    private LayoutInflater inflater;
    private Context context;
    private String userId;

    public StudyModeAdapter(Context context, String userId) {
        this.context = context;
        this.userId = userId;
    }

    //이미지 배열 총 갯수
    @Override
    public int getCount() {
        return images.length;
    }

    //뷰를 리니어레이아웃의 오브젝트로 지정
    @Override
    public boolean isViewFromObject( View view, Object object) {
        return view == ((LinearLayout) object);
    }

    //뷰페이저 설정 부분
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 뷰 지정
        View v = inflater.inflate(R.layout.chall_slide, container, false);
        //이미지 뷰 설정
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        //포지션에 해당하는 이미지뷰의 리소스를 가져옴.
        imageView.setImageResource(images[position]);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        //포지션에 따라 난이도 텍스트 출력.
        switch(position) {
            case 0: textView.setText("난이도 : 쉬움"); break;
            case 1: textView.setText("난이도 : 보통"); break;
            case 2: textView.setText("난이도 : 어려움"); break;
            default: textView.setText("잘못된 선택이다."); break;
        }
        //이미지 뷰의 클릭 리스너
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionCategory = null;
                //포지션에 따라 각 이미지뷰 내용 출력
                switch (position) {
                    case 0:
                        questionCategory = "easyquestion";
                        intent = new Intent(context, RecyclerSolutionActivity.class);
                        intent.putExtra("questionCategory", questionCategory);
                        intent.putExtra("userId", userId);
                        context.startActivity(intent);
                        break;
                    case 1:
                        questionCategory = "midquestion";
                        intent = new Intent(context, RecyclerSolutionActivity.class);
                        intent.putExtra("questionCategory", questionCategory);
                        intent.putExtra("userId", userId);
                        context.startActivity(intent);
                        break;
                    case 2:
                        questionCategory = "hardquestion";
                        intent = new Intent(context, RecyclerSolutionActivity.class);
                        intent.putExtra("questionCategory", questionCategory);
                        intent.putExtra("userId", userId);
                        context.startActivity(intent);
                        break;
                    default:
                        Toast.makeText(v.getContext(), " 잘못된 선택이다.", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        container.addView(v);
        return v;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

}
