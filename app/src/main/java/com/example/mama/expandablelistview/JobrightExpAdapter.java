package com.example.mama.expandablelistview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mama on 2018/1/26.
 */

public class JobrightExpAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ArrayList<Map<String,String>>> options2Item;
    private List<ArrayList<ArrayList<Map<String,String>>>> options3Item;
    private int currentindex=0;
    public JobrightExpAdapter(Context mcontext, List<ArrayList<Map<String,String>>> options2Items, List<ArrayList<ArrayList<Map<String,String>>>> options3Items){
        context = mcontext;
        options2Item=options2Items;
        options3Item=options3Items;
    }
    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return options2Item.get(currentindex).size();
    }
    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int groupPosition) {
        return options3Item.get(currentindex).get(groupPosition).size();
    }
    //  获得某个父项
    @Override
    public Object getGroup(int groupPosition) {
        return options2Item.get(currentindex).get(groupPosition);
    }
    //  获得某个父项的某个子项
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return options3Item.get(currentindex).get(groupPosition).get(childPosition);
    }
    //  获得某个父项的id
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }
    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }
    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }
    //  获得父项显示的view
    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.expandablelist_jobright_item,null);
        TextView tv_itemname = (TextView)convertView.findViewById(R.id.tv_itemname);
        ImageView iv_arrow = (ImageView)convertView.findViewById(R.id.iv_arrow);
        CheckBox cb_isselected = (CheckBox)convertView.findViewById(R.id.cb_isselected);
        cb_isselected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mOnCheckClickListener.OnGroudClickListener(currentindex,groupPosition,isChecked);
            }
        });
        try {
            if(options2Item.get(currentindex).get(groupPosition).get("checked").equals("1")){
                cb_isselected.setChecked(true);
                tv_itemname.setTextColor(Color.argb(255,156, 190, 245));
            }else {
                cb_isselected.setChecked(false);
                tv_itemname.setTextColor(Color.GRAY);
            }
        }catch (Exception e){
            cb_isselected.setChecked(false);
            tv_itemname.setTextColor(Color.GRAY);
        }
        tv_itemname.setText(options2Item.get(currentindex).get(groupPosition).get("name"));
        try {
            if(options2Item.get(currentindex).get(groupPosition).get("state").equals("1")){
                iv_arrow.setImageResource(R.mipmap.icon_xiala);
            }
        }catch (Exception e){}

        return convertView;
    }
    //  获得子项显示的view
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.expandablelist_jobright_item2,null);
        TextView tv_itemname = (TextView)convertView.findViewById(R.id.tv_itemname);
        CheckBox cb_isselected = (CheckBox)convertView.findViewById(R.id.cb_isselected);
        cb_isselected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mOnCheckClickListener.OnChildClickListener(currentindex,groupPosition,childPosition,isChecked);
            }
        });
        try {
            if(options3Item.get(currentindex).get(groupPosition).get(childPosition).get("checked").equals("1")){
                cb_isselected.setChecked(true);
                tv_itemname.setTextColor(Color.argb(255,156, 190, 245));
            }else {
                cb_isselected.setChecked(false);
                tv_itemname.setTextColor(Color.GRAY);
            }
        }catch (Exception e){
            cb_isselected.setChecked(false);
            tv_itemname.setTextColor(Color.GRAY);
        }


        Log.d("2222",childPosition+":::::::::"+options3Item.get(currentindex).get(groupPosition).get(childPosition).get("name"));
        tv_itemname.setText(options3Item.get(currentindex).get(groupPosition).get(childPosition).get("name"));
        return convertView;
    }
    // 子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private mOnCheckClickListener mOnCheckClickListener;
    public interface mOnCheckClickListener{
        void OnGroudClickListener(int currentposition, int groupPosition, boolean isChecked);
        void OnChildClickListener(int currentposition, int groupPosition, int childPosition, boolean isChecked);
    }
    public void setOnCheckClickListener(mOnCheckClickListener mOnCheckClickListeners){
        this.mOnCheckClickListener=mOnCheckClickListeners;
    }

    public void setCurrentindex(int index){
        currentindex=index;
    }
    public int getCurrentindex(){
        return currentindex;
    }
}
