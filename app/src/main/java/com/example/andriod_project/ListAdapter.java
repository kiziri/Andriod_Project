package com.example.andriod_project;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rankingactivity.ItemData;
import com.example.rankingactivity.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    LayoutInflater inflater = null;
    private ArrayList<ItemData> m_oData = null;
    private int nListCnt = 0;

    public ListAdapter(ArrayList<ItemData> _oData){
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
