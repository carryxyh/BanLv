package fragmentpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import personal.example.xiuyuhang.banlv.FutureWeatherReportActivity;
import personal.example.xiuyuhang.banlv.GPSLocationActivity;
import personal.example.xiuyuhang.banlv.GeoFenceActivity;
import personal.example.xiuyuhang.banlv.MultyLocationActivity;
import personal.example.xiuyuhang.banlv.PayActivity;
import personal.example.xiuyuhang.banlv.PoiAroundSearchActivity;
import personal.example.xiuyuhang.banlv.PoiKeywordSearchActivity;
import personal.example.xiuyuhang.banlv.R;
import personal.example.xiuyuhang.banlv.RouteActivity;

/**
 * Created by xiuyuhang on tab3_3/4/14.
 */
public class Fragment4 extends Fragment implements AdapterView.OnItemClickListener {

    private List<Map<String,Object>> dataList;
    private Intent intent;

    private int[] imgID = {R.mipmap.ditu,R.mipmap.sousuo,R.mipmap.tianqi,R.mipmap.zhoubian,R.mipmap.zoushi,
            R.mipmap.ditu,R.mipmap.yuyin,R.mipmap.yuding,R.mipmap.gerenzhongxin,R.mipmap.zutuan};

    private String[] name = {"附近美食","关键字搜索","天气预报","路线规划","防走失","定位功能","语音介绍","用户交易","我的图册","自定义组团"};

    private SimpleAdapter simpleAdapter;

    private View view;
    private GridView gridView;

    private void initView(){
        gridView = (GridView) view.findViewById(R.id.gridview_tab4);
        intent = new Intent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.tab4,null);
        initView();

        dataList = new ArrayList<Map<String,Object>>();
        simpleAdapter = new SimpleAdapter(getActivity(),getData(),R.layout.gridview_layout,new String[]{"image","name"},
                new int[]{R.id.gridview_imgage,R.id.gridview_text});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    private List<Map<String,Object>> getData(){

        for (int s=0;s<imgID.length;s++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",imgID[s]);
            map.put("name",name[s]);
            dataList.add(map);
        }

        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//          Toast.makeText(getActivity(),"我是"+name[position],Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                Intent intent = new Intent();
                intent.setClass(getActivity(), PoiAroundSearchActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), PoiKeywordSearchActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), FutureWeatherReportActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent();
                intent3.setClass(getActivity(), RouteActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent();
                intent4.setClass(getActivity(), GeoFenceActivity.class);
                startActivity(intent4);
                break;
            case 5:
                Intent intent5 = new Intent();
                intent5.setClass(getActivity(), MultyLocationActivity.class);
                startActivity(intent5);
                break;
            case 6:
                break;
            case 7:
                Intent intent6 = new Intent();
                intent6.setClass(getActivity(), PayActivity.class);
                startActivity(intent6);
                break;
            case 8:

                break;
            case 9:

                break;
        }
    }
}
