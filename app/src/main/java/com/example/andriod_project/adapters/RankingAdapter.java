package com.example.andriod_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andriod_project.models.RankingVO;
import com.example.andriod_project.R;

import java.util.List;

public class RankingAdapter extends BaseAdapter {
    List<RankingVO> arrayRanker;
    LayoutInflater inflater;
    TextView nickname, rankingP;


    public RankingAdapter(List<RankingVO> arrayRanker, LayoutInflater inflater) {
        this.arrayRanker = arrayRanker;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return arrayRanker.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayRanker.get(i).getUsernickname();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_rankinglist, parent, false);

        nickname = convertView.findViewById(R.id.nickName);
        rankingP = convertView.findViewById(R.id.rankPoint);


        nickname.setText(arrayRanker.get(position).getUsernickname());
        rankingP.setText(""+arrayRanker.get(position).getUserrankpoint());
        System.out.println("-------------어댑터 셋팅\n");

        return convertView;
    }
}
