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
    LayoutInflater inflater = null;

    public RankingAdapter(List<RankingVO> arrayRanker) {
        this.arrayRanker = arrayRanker;
    }

    @Override
    public int getCount() {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rankinglist, parent, false);
        if (convertView == null) {
            final Context context = parent.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.item_rankinglist, parent, false);
        }

        TextView nickname = (TextView) view.findViewById(R.id.nickName);
        TextView rankingP = (TextView) view.findViewById(R.id.rankPoint);


        nickname.setText(arrayRanker.get(position).getUsernickname());
        rankingP.setText(""+arrayRanker.get(position).getUserrankpoint());

        return view;
    }
}
