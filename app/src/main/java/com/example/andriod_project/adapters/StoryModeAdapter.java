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
import com.example.andriod_project.models.QuestionVO;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;
import com.example.andriod_project.views.LoginActivity;
import com.example.andriod_project.views.MainHomeActivity;
import com.example.andriod_project.views.RankingActivity;
import com.example.andriod_project.views.SolutionActivity;
import com.example.andriod_project.views.StoryModeActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class StoryModeAdapter extends PagerAdapter{

    String userStoryModeLevel, userId, userName, userNickname;
    int userStoryModeStage, userRankPoint, userSolveProblem, userCorrectProblem;

    String easy = "easy", mid = "mid", hard = "hard";

    Intent intent;

    Retrofit retrofit;
    RemoteService remoteService;

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
    int[] clearimage = {R.drawable.clear};
    private LayoutInflater inflater;
    private Context context;

    public StoryModeAdapter(Context context, String userId, String userName, String userNickname,
                            int userRankPoint, int userSolveProblem, int userCorrectProblem){
        this.context = context;
        this.userId = userId;
        this.userName = userName;
        this.userNickname = userNickname;
        this.userRankPoint = userRankPoint;
        this.userSolveProblem = userSolveProblem;
        this.userCorrectProblem = userCorrectProblem;
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
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        remoteService = retrofit.create(RemoteService.class);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //레이아웃 뷰 지정.
        View v = inflater.inflate(R.layout.slide, container, false);

        getLoginUserInfo(userId, v, position);

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        //포지션에 해당하는 이미지뷰의 리소스를 가져옴.
        imageView.setImageResource(images[position]);

        //이미지뷰의 클릭리스너
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position + 1 < userStoryModeStage) {
                    Toast.makeText(v.getContext(), "클리어한 스테이지입니다.",
                            Toast.LENGTH_SHORT).show();
                }
                if(position + 1 == userStoryModeStage) {
                    intent = new Intent(v.getContext(), SolutionActivity.class);
                    intent.putExtra("userId", userId);
                    intent.putExtra("userName", userName);
                    intent.putExtra("userNickname", userNickname);
                    intent.putExtra("userRankPoint", userRankPoint);
                    intent.putExtra("userSolveProblem", userSolveProblem);
                    intent.putExtra("userCorrectProblem", userCorrectProblem);
                    intent.putExtra("userstorymodelevel", userStoryModeLevel);
                    intent.putExtra("userstorymodestage", userStoryModeStage);
                    ((StoryModeActivity)context).startActivity(intent);
                    ((StoryModeActivity)context).finish();

                }
                if(position + 1 > userStoryModeStage){
                    Toast.makeText(v.getContext(), "이전 스테이지를 먼저 클리어해주세요.",
                            Toast.LENGTH_SHORT).show();
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

    public void getLoginUserInfo(String userId, View v, int position) {
        Call<UserVO> call = remoteService.readSaveData(userId);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                UserVO userVO = response.body();

                userStoryModeLevel = userVO.getUserstorymodelevel();
                userStoryModeStage = userVO.getUserstorymodestage();

                if(position + 1 < userStoryModeStage){
                    ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
                    imageView.setImageResource(images[position] = clearimage[0]);
                }

                TextView T1 = (TextView) v.findViewById(R.id.leveltext);
                if(userStoryModeLevel.equals(easy)){
                    T1.setText("현재 난이도 : 하");}
                if(userStoryModeLevel.equals(mid)){
                    T1.setText("현재 난이도 : 중");}
                if(userStoryModeLevel.equals(hard)){
                    T1.setText("현재 난이도 : 상");}
            }
            @Override
            public void onFailure(Call<UserVO> call, Throwable t) { }
        });
    }
}
