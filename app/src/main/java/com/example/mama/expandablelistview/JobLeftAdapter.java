package com.example.mama.expandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mama on 2018/1/26.
 */

public class JobLeftAdapter extends BaseAdapter {

    private Context context;
    ArrayList<JobBean> options1Item;
    private int selectedindex=0;

    public JobLeftAdapter(Context mcontext, ArrayList<JobBean> options1Items){
        context = mcontext;
        options1Item = options1Items;
    }
    @Override
    public int getCount() {
        return options1Item.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_jobleft_item,null);
            holder.tv_itemname = (TextView)convertView.findViewById(R.id.tv_itemname);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_itemname.setText(options1Item.get(position).getName());
        if(position==selectedindex){
            //设置选中颜色为白色
            convertView.setBackgroundColor(Color.argb(255,255,255,255));
        }else {
            //getResources().getColor(R.color.frament_tab_color2)
            convertView.setBackgroundColor(Color.argb(100,255,255,255));
        }
        return convertView;
    }

    class ViewHolder{
        TextView tv_itemname;
    }
    public void setleftItemColor(int index){
        this.selectedindex = index;
        notifyDataSetChanged();
    }
    public int getleftItemColor(){
        return selectedindex;
    }
}
