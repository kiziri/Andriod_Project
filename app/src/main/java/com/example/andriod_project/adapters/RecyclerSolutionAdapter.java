package com.example.andriod_project.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.QuestionVO;

import java.util.ArrayList;

public class RecyclerSolutionAdapter extends RecyclerView.Adapter<RecyclerSolutionAdapter.ViewHolder> {
    Context context;
    ArrayList<QuestionVO> arrayQuestionList = null;

    public RecyclerSolutionAdapter(Context context, ArrayList<QuestionVO> arrayQuestionList) {
        this.context = context;
        this.arrayQuestionList = arrayQuestionList;
    }

    @Override
    public int getItemCount() {
        System.out.println(arrayQuestionList.size());
        return arrayQuestionList.size();
    }

    @Override
    public RecyclerSolutionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_solution, parent, false);
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

        holder.selectionRadioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                holder.nextQuestion.setVisibility(View.VISIBLE);
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
                        }
                        else {
                            holder.selectionRadio1.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio2 :
                        if (questionAnswer == 2) {
                            holder.selectionRadio2.setTextColor(Color.GREEN);
                        }
                        else {
                            holder.selectionRadio2.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio3 :
                        if (questionAnswer == 3) {
                            holder.selectionRadio3.setTextColor(Color.GREEN);
                        }
                        else {
                            holder.selectionRadio3.setTextColor(Color.RED);
                        }
                        break;
                    case R.id.selectionRadio4 :
                        if (questionAnswer == 4) {
                            holder.selectionRadio4.setTextColor(Color.GREEN);
                        }
                        else {
                            holder.selectionRadio4.setTextColor(Color.RED);
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


            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView questionTextView, summaryText, detailText;
        Button exSummary, exDetail;
        RadioGroup selectionRadioG;
        RadioButton selectionRadio1, selectionRadio2, selectionRadio3, selectionRadio4;
        ImageButton nextQuestion;

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
        }
    }
}
