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
    TextView nickname, rankingP, ranking;


    public RankingAdapter(List<RankingVO> arrayRanker, LayoutInflater inflater) {
        this.arrayRanker = arrayRanker;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        System.out.println("getCount : "+arrayRanker.size());
        return arrayRanker.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_rankinglist, parent, false);

        ranking = convertView.findViewById(R.id.rankingNum);
        nickname = convertView.findViewById(R.id.nickName);
        rankingP = convertView.findViewById(R.id.rankPoint);

        ranking.setText(""+(position+1));
        nickname.setText(arrayRanker.get(position).getUsernickname());
        rankingP.setText(""+arrayRanker.get(position).getUserrankpoint());

        return convertView;
    }
}