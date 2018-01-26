package com.example.mama.expandablelistview;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mama on 2018/1/23.
 */

public class JobData2 {
    private static ArrayList<JobBean> options1Items ;
    private static List<ArrayList<Map<String,String>>> options2Items;
    private static List<ArrayList<ArrayList<Map<String,String>>>> options3Items;

    public static ArrayList<JobBean> initJsonData1(Context mcontext) {//解析数据
        options1Items = new ArrayList<>();
        options2Items = new ArrayList<>();
        options3Items = new ArrayList<>();

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         * */
        String JsonData = new GetJsonDataUtil().getJson(mcontext,"job2.json");//获取assets目录下的json文件数据
        ArrayList<JobBean> jsonBean = parseData(JsonData);//用Gson 转成实体
        options1Items = jsonBean;
        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<Map<String,String>> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<Map<String,String>>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
            if (jsonBean.get(i).getData() == null
                    ||jsonBean.get(i).getData().size()==0) {
                ArrayList<Map<String,String>> City_AreaList2 = new ArrayList<>();//该城市的所有地区列表
                Map<String,String> map = new HashMap<>();
                map.put("name","");
                map.put("code",jsonBean.get(i).getCode());
                City_AreaList2.add(map);
                Province_AreaList.add(City_AreaList2);

                ArrayList<String> City_AreaList2code = new ArrayList<>();//该城市的所有地区列表
                City_AreaList2code.add(jsonBean.get(i).getCode()+"");
            }else{
                for (int c=0; c<jsonBean.get(i).getData().size(); c++){//遍历该省份的所有城市
                    Map<String,String> mapsss = new HashMap<>();
                    String CityName = jsonBean.get(i).getData().get(c).getName();
                    String Citycode = jsonBean.get(i).getData().get(c).getCode();
                    mapsss.put("name",CityName);
                    mapsss.put("code",Citycode);
                    CityList.add(mapsss);//添加城市

                    ArrayList<Map<String,String>> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (jsonBean.get(i).getData().get(c).getData() == null
                            ||jsonBean.get(i).getData().get(c).getData().size()==0) {
                        Map<String,String> map = new HashMap<>();
                        map.put("name","");
                        map.put("code",jsonBean.get(i).getData().get(c).getCode());
                        City_AreaList.add(map);
                    }else {
                        for (int d=0; d < jsonBean.get(i).getData().get(c).getData().size(); d++) {//该城市对应地区所有数据
                            String AreaName = jsonBean.get(i).getData().get(c).getData().get(d).getName();
                            Map<String,String> map = new HashMap<>();
                            map.put("name",AreaName);
                            map.put("code",jsonBean.get(i).getData().get(c).getData().get(d).getCode());
                            City_AreaList.add(map);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
            }
            /**
             * 添加城市数据
             */
            options2Items.add(CityList);
            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
        String[] options = new String[]{options1Items.toString(),options2Items.toString(),options3Items.toString()};
        return options1Items;
    }

    public static List<ArrayList<Map<String,String>>> initJsonData2(Context mcontext) {//解析数据
        options1Items = new ArrayList<>();
        options2Items = new ArrayList<>();
        options3Items = new ArrayList<>();

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(mcontext,"job2.json");//获取assets目录下的json文件数据
        ArrayList<JobBean> jsonBean = parseData(JsonData);//用Gson 转成实体
        options1Items = jsonBean;
        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<Map<String,String>> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<Map<String,String>>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
            if (jsonBean.get(i).getData() == null
                    ||jsonBean.get(i).getData().size()==0) {
                ArrayList<Map<String,String>> City_AreaList2 = new ArrayList<>();//该城市的所有地区列表
                Map<String,String> map = new HashMap<>();
                map.put("name","");
                map.put("code",jsonBean.get(i).getCode());
                City_AreaList2.add(map);
                Province_AreaList.add(City_AreaList2);

                ArrayList<String> City_AreaList2code = new ArrayList<>();//该城市的所有地区列表
                City_AreaList2code.add(jsonBean.get(i).getCode()+"");
            }else{
                for (int c=0; c<jsonBean.get(i).getData().size(); c++){//遍历该省份的所有城市
                    Map<String,String> mapsss = new HashMap<>();
                    String CityName = jsonBean.get(i).getData().get(c).getName();
                    String Citycode = jsonBean.get(i).getData().get(c).getCode();
                    mapsss.put("name",CityName);
                    mapsss.put("code",Citycode);
                    CityList.add(mapsss);//添加城市
                    ArrayList<Map<String,String>> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (jsonBean.get(i).getData().get(c).getData() == null
                            ||jsonBean.get(i).getData().get(c).getData().size()==0) {
                        Map<String,String> map = new HashMap<>();
                        map.put("name","");
                        map.put("code",jsonBean.get(i).getData().get(c).getCode());
                        City_AreaList.add(map);
                    }else {
                        for (int d=0; d < jsonBean.get(i).getData().get(c).getData().size(); d++) {//该城市对应地区所有数据
                            String AreaName = jsonBean.get(i).getData().get(c).getData().get(d).getName();
                            Map<String,String> map = new HashMap<>();
                            map.put("name",AreaName);
                            map.put("code",jsonBean.get(i).getData().get(c).getData().get(d).getCode());
                            City_AreaList.add(map);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
            }
            /**
             * 添加城市数据
             */
            options2Items.add(CityList);
            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
        String[] options = new String[]{options1Items.toString(),options2Items.toString(),options3Items.toString()};
        return options2Items;
    }

    public static List<ArrayList<ArrayList<Map<String,String>>>> initJsonData3(Context mcontext) {//解析数据
        options1Items = new ArrayList<>();
        options2Items = new ArrayList<>();
        options3Items = new ArrayList<>();
        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(mcontext,"job2.json");//获取assets目录下的json文件数据

        ArrayList<JobBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        options1Items = jsonBean;

        for (int i=0;i<jsonBean.size();i++){//遍历省份
            ArrayList<Map<String,String>> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<Map<String,String>>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
            if (jsonBean.get(i).getData() == null
                    ||jsonBean.get(i).getData().size()==0) {
                ArrayList<Map<String,String>> City_AreaList2 = new ArrayList<>();//该城市的所有地区列表
                Map<String,String> map = new HashMap<>();
                map.put("name","");
                map.put("code",jsonBean.get(i).getCode());
                City_AreaList2.add(map);
                Province_AreaList.add(City_AreaList2);

                ArrayList<String> City_AreaList2code = new ArrayList<>();//该城市的所有地区列表
                City_AreaList2code.add(jsonBean.get(i).getCode()+"");
            }else{
                for (int c=0; c<jsonBean.get(i).getData().size(); c++){//遍历该省份的所有城市
                    Map<String,String> mapsss = new HashMap<>();
                    String CityName = jsonBean.get(i).getData().get(c).getName();
                    String Citycode = jsonBean.get(i).getData().get(c).getCode();
                    mapsss.put("name",CityName);
                    mapsss.put("code",Citycode);
                    CityList.add(mapsss);//添加城市
                    ArrayList<Map<String,String>> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (jsonBean.get(i).getData().get(c).getData() == null
                            ||jsonBean.get(i).getData().get(c).getData().size()==0) {
                        Map<String,String> map = new HashMap<>();
                        map.put("name","");
                        map.put("code",jsonBean.get(i).getData().get(c).getCode());
                        City_AreaList.add(map);
                    }else {
                        for (int d=0; d < jsonBean.get(i).getData().get(c).getData().size(); d++) {//该城市对应地区所有数据
                            String AreaName = jsonBean.get(i).getData().get(c).getData().get(d).getName();
                            Map<String,String> map = new HashMap<>();
                            map.put("name",AreaName);
                            map.put("code",jsonBean.get(i).getData().get(c).getData().get(d).getCode());
                            City_AreaList.add(map);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
            }
            /**
             * 添加城市数据
             */
            options2Items.add(CityList);
            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
        String[] options = new String[]{options1Items.toString(),options2Items.toString(),options3Items.toString()};
        return options3Items;
    }

    public static ArrayList<JobBean> parseData(String result) {//Gson 解析
        ArrayList<JobBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JobBean entity = gson.fromJson(data.optJSONObject(i).toString(), JobBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }
}
