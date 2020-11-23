package com.example.andriod_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andriod_project.models.ItemData;
import com.example.andriod_project.R;

import java.util.ArrayList;

public class RankingAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<ItemData> m_oData = null;
    private int nListCnt = 0;

    public RankingAdapter(ArrayList<ItemData> _oData){
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount() {
        return nListCnt;
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
        if(convertView == null){
            final Context context = parent.getContext();
            if(inflater == null){
                inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        TextView rankcount = (TextView) convertView.findViewById(R.id.rankingNum);
        TextView nickname = (TextView) convertView.findViewById(R.id.nickName);
        TextView rankingP = (TextView) convertView.findViewById(R.id.rankPoint);

        rankcount.setText(m_oData.get(position).strRanking);
        nickname.setText(m_oData.get(position).strNickame);
        rankingP.setText(m_oData.get(position).strRankpoint);

        return convertView;
    }
}
