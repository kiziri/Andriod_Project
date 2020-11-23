package com.example.andriod_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import com.example.andriod_project.R;

public class Adapter extends PagerAdapter{

    //이미지 배열 선언
    int[] images = {R.drawable.lvbtn1, R.drawable.lvbtn2, R.drawable.lvbtn3, R.drawable.lvbtn4, R.drawable.lvbtn5,
            R.drawable.lvbtn6, R.drawable.lvbtn7, R.drawable.lvbtn8, R.drawable.lvbtn9, R.drawable.lvbtn10,
            R.drawable.lvbtn11, R.drawable.lvbtn12, R.drawable.lvbtn13, R.drawable.lvbtn14, R.drawable.lvbtn15,
            R.drawable.lvbtn16, R.drawable.lvbtn17, R.drawable.lvbtn18, R.drawable.lvbtn19, R.drawable.lvbtn20,
            R.drawable.lvbtn21, R.drawable.lvbtn22, R.drawable.lvbtn23, R.drawable.lvbtn24, R.drawable.lvbtn25,
            R.drawable.lvbtn26, R.drawable.lvbtn27, R.drawable.lvbtn28, R.drawable.lvbtn29, R.drawable.lvbtn30,
            R.drawable.lvbtn31, R.drawable.lvbtn32, R.drawable.lvbtn33, R.drawable.lvbtn34, R.drawable.lvbtn35,
            R.drawable.lvbtn36, R.drawable.lvbtn37, R.drawable.lvbtn38, R.drawable.lvbtn39, R.drawable.lvbtn40,
            R.drawable.lvbtn41, R.drawable.lvbtn42, R.drawable.lvbtn43, R.drawable.lvbtn44, R.drawable.lvbtn45,
            R.drawable.lvbtn46, R.drawable.lvbtn47, R.drawable.lvbtn48, R.drawable.lvbtn49, R.drawable.lvbtn50,};
    private LayoutInflater inflater;
    private Context context;

    public Adapter(Context context){
        this.context = context;
    }

    //이미지 배열의 총 갯수
    @Override
    public int getCount() {
        return images.length;
    }

    //뷰를 리니어레이아웃의 오브젝트로 지정.
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    //뷰페이저 설정 부분
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 뷰 지정.
        View v = inflater.inflate(R.layout.slide, container, false);
        //이미지 뷰 설정
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        //포지션에 해당하는 이미지뷰의 리소스를 가져옴.
        imageView.setImageResource(images[position]);
        //이미지뷰의 클릭리스너
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),  position + 1 +" 스테이지가 클릭되었습니다.",
                        Toast.LENGTH_SHORT).show();
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
