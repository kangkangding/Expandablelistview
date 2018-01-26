package com.example.mama.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<JobBean> options1Items ;
    private static List<ArrayList<Map<String,String>>> options2Items;
    private static List<ArrayList<ArrayList<Map<String,String>>>> options3Items;
    private ListView side_menu_left;
    private ExpandableListView menu_lvmenu_right;
    private JobLeftAdapter leftAdapter;
    private JobrightExpAdapter rightAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        options1Items = JobData2.initJsonData1(this);
        options2Items = JobData2.initJsonData2(this);
        options3Items = JobData2.initJsonData3(this);


        leftAdapter = new JobLeftAdapter(this,options1Items);
        side_menu_left.setAdapter(leftAdapter);
        rightAdapter = new JobrightExpAdapter(this,options2Items,options3Items);
        menu_lvmenu_right.setGroupIndicator(null);
        menu_lvmenu_right.setAdapter(rightAdapter);
        side_menu_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftAdapter.setleftItemColor(position);
                rightAdapter.setCurrentindex(position);
                rightAdapter.notifyDataSetChanged();
            }
        });
        rightAdapter.setOnCheckClickListener(new JobrightExpAdapter.mOnCheckClickListener() {
            @Override
            public void OnGroudClickListener(int currentposition,int groupPosition, boolean isChecked) {
                if(isChecked){
                    options2Items.get(currentposition).get(groupPosition).put("checked","1");
                    for(int i=0;i<options3Items.get(currentposition).get(groupPosition).size();i++){
                        options3Items.get(currentposition).get(groupPosition).get(i).put("checked","0");
                    }
                }else {
                    options2Items.get(currentposition).get(groupPosition).put("checked","0");
                }
                rightAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnChildClickListener(int currentposition,int groupPosition, int childPosition, boolean isChecked) {
                if(isChecked){
                    options3Items.get(currentposition).get(groupPosition).get(childPosition).put("checked","1");
                    options2Items.get(currentposition).get(groupPosition).put("checked","0");
                }else {
                    options3Items.get(currentposition).get(groupPosition).get(childPosition).put("checked","0");
                }
                rightAdapter.notifyDataSetChanged();
            }
        });

        menu_lvmenu_right.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                int currentindex = rightAdapter.getCurrentindex();
                try {
                    if (options2Items.get(currentindex).get(groupPosition).get("state").equals("1")){
                        options2Items.get(currentindex).get(groupPosition).put("state","0");
                    }else{
                        options2Items.get(currentindex).get(groupPosition).put("state","1");
                    }
                }catch (Exception e){
                    options2Items.get(currentindex).get(groupPosition).put("state","1");
                }
                return false;
            }
        });

    }

    private void initView() {
        side_menu_left = (ListView) findViewById(R.id.side_menu_lv);
        menu_lvmenu_right = (ExpandableListView) findViewById(R.id.menu_lvmenu);
    }
}
