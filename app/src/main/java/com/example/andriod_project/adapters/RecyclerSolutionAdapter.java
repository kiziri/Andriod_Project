package com.example.andriod_project.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.QuestionVO;
import com.example.andriod_project.models.RemoteService;
import com.example.andriod_project.models.UserVO;
import com.example.andriod_project.views.RecyclerSolutionActivity;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.andriod_project.models.RemoteService.BASE_URL;

public class RecyclerSolutionAdapter extends RecyclerView.Adapter<RecyclerSolutionAdapter.ViewHolder> {
    Context context;
    ArrayList<QuestionVO> arrayQuestionList = null;
    String getUserId;
    int userRankPoint = 0;
    int userSolveProblem = 0;
    int userCorrectProblem = 0;
    View view;
    private OnItemClickListener onItemClickListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    RemoteService remoteService = retrofit.create(RemoteService.class);

    public RecyclerSolutionAdapter() {
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public RecyclerSolutionAdapter(Context context, ArrayList<QuestionVO> arrayQuestionList, String getUserId, int userRankPoint, int userSolveProblem, int userCorrectProblem) {
        this.context = context;
        this.arrayQuestionList = arrayQuestionList;
        this.getUserId = getUserId;
        this.userRankPoint = userRankPoint;
        this.userSolveProblem = userSolveProblem;
        this.userCorrectProblem = userCorrectProblem;
        System.out.println(getUserId + " / " + this.getUserId + " / " + userRankPoint + " / " + this.userRankPoint + " / " + userSolveProblem + " / " + this.userSolveProblem + " / "
                            + userCorrectProblem + " / " + this.userCorrectProblem);
    }

    @Override
    public int getItemCount() {
        System.out.println(arrayQuestionList.size());
        return arrayQuestionList.size();
    }

    @Override
    public RecyclerSolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_solution, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSolutionAdapter.ViewHolder holder, int position) {
        System.out.println("---------------문제 출력\n");
        holder.questionTextView.setText(arrayQuestionList.get(position).getContent());
        holder.summaryText.setText(arrayQuestionList.get(position).getExsummary());
        holder.detailText.setText(arrayQuestionList.get(position).getExdetail());
        holder.selectionRadio1.setText(arrayQuestionList.get(position).getSelection1());
        holder.selectionRadio2.setText(arrayQuestionList.get(position).getSelection2());
        holder.selectionRadio3.setText(arrayQuestionList.get(position).getSelection3());
        holder.selectionRadio4.setText(arrayQuestionList.get(position).getSelection4());
        int questionAnswer = arrayQuestionList.get(position).getAnswer();

        
        // 해설 버튼과 설명의 초기 상태 설정
        holder.exSummary.setVisibility(View.GONE);
        holder.exDetail.setVisibility(View.GONE);
        holder.summaryText.setVisibility(View.GONE);
        holder.detailText.setVisibility(View.GONE);
        holder.nextQuestion.setVisibility(View.GONE);
        holder.backToModeBtn.setVisibility(View.GONE);


        holder.selectionRadioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int getPosition = holder.getAdapterPosition();
                view.setNestedScrollingEnabled(false);
                holder.exSummary.setVisibility(View.VISIBLE);
                holder.exDetail.setVisibility(View.VISIBLE);
                holder.selectionRadio1.setEnabled(false);
                holder.selectionRadio2.setEnabled(false);
                holder.selectionRadio3.setEnabled(false);
                holder.selectionRadio4.setEnabled(false);
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.selectionRadio1 :
                        if (questionAnswer == 1) {
                            holder.selectionRadio1.setTextColor(Color.GREEN);
                            userRankPoint++;
                            userSolveProblem++;
                            userCorrectProblem++;

                            if (checkFinalQuestion(getPosition) != true) {
                                holder.nextQuestion.setVisibility(View.VISIBLE);
                            }
                            else {
                                holder.backToModeBtn.setVisibility(View.VISIBLE);
                            }
                        }
                        else {
                            holder.selectionRadio1.setTextColor(Color.RED);
                            holder.backToModeBtn.setVisibility(View.VISIBLE);
                            userSolveProblem++;
                        }
                        break;
                    case R.id.selectionRadio2 :
                        if (questionAnswer == 2) {
                            holder.selectionRadio2.setTextColor(Color.GREEN);
                            userRankPoint++;
                            userSolveProblem++;
                            userCorrectProblem++;

                            if (checkFinalQuestion(getPosition) != true) {
                                holder.nextQuestion.setVisibility(View.VISIBLE);
                            }
                            else {
                                holder.backToModeBtn.setVisibility(View.VISIBLE);
                            }
                        }
                        else {
                            holder.selectionRadio2.setTextColor(Color.RED);
                            holder.backToModeBtn.setVisibility(View.VISIBLE);
                            userSolveProblem++;
                        }
                        break;
                    case R.id.selectionRadio3 :
                        if (questionAnswer == 3) {
                            holder.selectionRadio3.setTextColor(Color.GREEN);
                            userRankPoint++;
                            userSolveProblem++;
                            userCorrectProblem++;

                            if (checkFinalQuestion(getPosition) != true) {
                                holder.nextQuestion.setVisibility(View.VISIBLE);
                            }
                            else {
                                holder.backToModeBtn.setVisibility(View.VISIBLE);
                            }
                        }
                        else {
                            holder.selectionRadio3.setTextColor(Color.RED);
                            holder.backToModeBtn.setVisibility(View.VISIBLE);
                            userSolveProblem++;
                        }
                        break;
                    case R.id.selectionRadio4 :
                        if (questionAnswer == 4) {
                            holder.selectionRadio4.setTextColor(Color.GREEN);
                            userRankPoint++;
                            userSolveProblem++;
                            userCorrectProblem++;

                            if (checkFinalQuestion(getPosition) != true) {
                                holder.nextQuestion.setVisibility(View.VISIBLE);
                            }
                            else {
                                holder.backToModeBtn.setVisibility(View.VISIBLE);
                            }
                        }
                        else {
                            holder.selectionRadio4.setTextColor(Color.RED);
                            holder.backToModeBtn.setVisibility(View.VISIBLE);
                            userSolveProblem++;
                        }
                        break;
                }
            }
        });

        holder.exSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.summaryText.getVisibility() == View.VISIBLE) {
                    holder.summaryText.setVisibility(View.GONE);
                }
                else {
                    holder.summaryText.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.exDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.detailText.getVisibility() == View.VISIBLE) {
                    holder.detailText.setVisibility(View.GONE);
                }
                else {
                    holder.detailText.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getPosition = holder.getAdapterPosition();

                holder.selectionRadioG.clearCheck();
                holder.selectionRadio1.setEnabled(true);
                holder.selectionRadio2.setEnabled(true);
                holder.selectionRadio3.setEnabled(true);
                holder.selectionRadio4.setEnabled(true);
                holder.selectionRadio1.setTextColor(Color.WHITE);
                holder.selectionRadio2.setTextColor(Color.WHITE);
                holder.selectionRadio3.setTextColor(Color.WHITE);
                holder.selectionRadio4.setTextColor(Color.WHITE);
                onItemClickListener.onItemClick(v, getPosition);
            }
        });

        holder.backToModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserVO userVO = new UserVO();
                userVO.setUserrankpoint(userRankPoint);
                userVO.setUsersolveproblem(userSolveProblem);
                userVO.setUsercorrectproblem(userCorrectProblem);
                userVO.setUserid(getUserId);

                System.out.println(userRankPoint + " / " + userSolveProblem + " / " + userCorrectProblem + " / " + getUserId);
                Call<UserVO> call = remoteService.saveChallengeMode(userVO.getUserrankpoint(), userVO.getUsersolveproblem(), userVO.getUsercorrectproblem(), userVO.getUserid());
                call.enqueue(new Callback<UserVO>() {
                    @Override
                    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                        System.out.println(response.code());
                        Log.d("Test", response.body().toString());
                        System.out.println("-------------도전 모드 데이터 저장 완료\n");
                        System.out.println(userRankPoint + " / " + userSolveProblem + " / " + userCorrectProblem + " / " + getUserId);
                    }
                    @Override
                    public void onFailure(Call<UserVO> call, Throwable t) { }
                });
                ((Activity)context).finish();
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView questionTextView, summaryText, detailText;
        Button exSummary, exDetail;
        RadioGroup selectionRadioG;
        RadioButton selectionRadio1, selectionRadio2, selectionRadio3, selectionRadio4;
        ImageButton nextQuestion, backToModeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            summaryText = itemView.findViewById(R.id.summaryText);
            detailText = itemView.findViewById(R.id.detailText);
            exSummary = itemView.findViewById(R.id.exSummary);
            exDetail = itemView.findViewById(R.id.exDetail);
            selectionRadioG = itemView.findViewById(R.id.selectionRadioG);
            selectionRadio1 = itemView.findViewById(R.id.selectionRadio1);
            selectionRadio2 = itemView.findViewById(R.id.selectionRadio2);
            selectionRadio3 = itemView.findViewById(R.id.selectionRadio3);
            selectionRadio4 = itemView.findViewById(R.id.selectionRadio4);
            nextQuestion = itemView.findViewById(R.id.nextQuestionBtn);
            backToModeBtn = itemView.findViewById(R.id.backToModeBtn);
        }
    }

    public boolean checkFinalQuestion(int getPosition) {
        int getCount = getItemCount();

        if (getPosition != getCount) {
            return false;
        }
        else {
            return true;
        }
    }
}
