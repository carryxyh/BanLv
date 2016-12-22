package Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Bean.tab2_itembean_2;
import personal.example.xiuyuhang.banlv.R;
import personal.example.xiuyuhang.banlv.tab2_fx;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class MyAdapter_tab2_2 extends BaseAdapter{

    private LayoutInflater mInflater3;

    private Context context;

    private int ObjID;

    private List<tab2_itembean_2> mylist;

    public MyAdapter_tab2_2(Context context,List<tab2_itembean_2> list){
        mylist = list;
        this.context = context;
        mInflater3 = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater3.inflate(R.layout.adaptercontenttab2_2,null);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null){
            convertView = mInflater3.inflate(R.layout.adaptercontenttab2_2,null);
            viewHolder.imgview_big = (ImageView) convertView.findViewById(R.id.scenerytab2_2);
            viewHolder.content_big = (TextView) convertView.findViewById(R.id.contenttab2_2);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        tab2_itembean_2 itembean_2 = mylist.get(position);
        viewHolder.imgview_big.setImageResource(itembean_2.imgid_tab2_2);
        viewHolder.content_big.setText(itembean_2.content_tab2_2);
//        convertView.setOnClickListener(this);
        return convertView;
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent();
//        intent.setClass(context,tab2_fx.class);
//        context.startActivity(intent);
//    }

    private class ViewHolder{
        public ImageView imgview_big;
        public TextView content_big;
    }
}
