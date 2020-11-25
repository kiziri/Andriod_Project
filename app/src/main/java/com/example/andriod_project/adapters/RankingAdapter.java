package com.example.andriod_project.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andriod_project.models.ItemData;
import com.example.andriod_project.R;

import java.util.ArrayList;
import java.util.List;

public class RankingAdapter extends BaseAdapter {
    List<ItemData> arrayRanker = new ArrayList<>();
    LayoutInflater inflater = null;

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
        if (convertView == null) {
            final Context context = parent.getContext();
            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.item_rankinglist, parent, false);
        }

        TextView rankcount = (TextView) convertView.findViewById(R.id.rankingNum);
        TextView nickname = (TextView) convertView.findViewById(R.id.nickName);
        TextView rankingP = (TextView) convertView.findViewById(R.id.rankPoint);

        rankcount.setText(arrayRanker.get(position).getUseranking());
        nickname.setText(arrayRanker.get(position).getUsernickname());
        rankingP.setText(arrayRanker.get(position).getUserrankpoint());

        return convertView;
    }
}
