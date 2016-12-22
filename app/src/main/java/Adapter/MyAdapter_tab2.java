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

import Bean.tab2_itembean;
import personal.example.xiuyuhang.banlv.R;
import personal.example.xiuyuhang.banlv.tab2_fx;

/**
 * Created by xiuyuhang on tab3_3/4/tab3_4.
 */
public class MyAdapter_tab2 extends BaseAdapter{

    private LayoutInflater mInflater2;

    private List<tab2_itembean> mylist2;
    private String ObjID;

    private Context context;

    public MyAdapter_tab2(Context context,List<tab2_itembean> list){
        this.mylist2 = list;
        this.context = context;
        mInflater2 = LayoutInflater.from(context);
    }

//    public void onDateChange(ArrayList<tab2_itembean> mylist2) {
//        this.mylist2 = mylist2;
//        this.notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return mylist2.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater2.inflate(R.layout.adaptercontenttab2_1,null);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater2.inflate(R.layout.adaptercontenttab2_1,null);
            viewHolder.imgview = (ImageView) convertView.findViewById(R.id.scenerytab2);
            viewHolder.title = (TextView) convertView.findViewById(R.id.titletab2);
            viewHolder.content = (TextView) convertView.findViewById(R.id.contenttab2);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        tab2_itembean bean = mylist2.get(position);
        ObjID = bean.getObjectId();
        viewHolder.imgview.setImageResource(bean.imgID);
        viewHolder.title.setText(bean.title);
        viewHolder.content.setText(bean.content);
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
        public ImageView imgview;
        public TextView title;
        public TextView content;
    }
}
