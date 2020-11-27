package com.example.andriod_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andriod_project.R;
import com.example.andriod_project.models.QuestionVO;

import java.util.ArrayList;

public class RecyclerSolutionAdapter extends RecyclerView.Adapter<RecyclerSolutionAdapter.ViewHolder> {
    ArrayList<QuestionVO> arrayQuestionList;
    Context context;

    public RecyclerSolutionAdapter(ArrayList<QuestionVO> arrayQuestionList, Context context) {
        this.arrayQuestionList = arrayQuestionList;
        this.context = context;
    }

    @NonNull
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

    }

    @Override
    public int getItemCount() {
        return arrayQuestionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView questionTextView, summaryText, detailText;
        Button exSummary, exDetail;
        RadioGroup selectionRadioG;
        RadioButton selectionRadio1, selectionRadio2, selectionRadio3, selectionRadio4;

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
        }
    }
}
