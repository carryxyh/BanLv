package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import Bean.tab1_itembean;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/tab3_3.
 */
public class MyAdapter_tab1 extends BaseAdapter {

    private LayoutInflater mInflater;

    public List<tab1_itembean> mylist;

    public MyAdapter_tab1(Context context,List<tab1_itembean> list){
           mylist = list;
           mInflater = LayoutInflater.from(context);
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
        View view = mInflater.inflate(R.layout.adaptercontenttab1_2,null);
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adaptercontenttab1_2,null);
            viewHolder.imgview = (ImageView) convertView.findViewById(R.id.scenery_tab1);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title_tab1);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content_tab1);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        tab1_itembean bean = mylist.get(position);
        viewHolder.imgview.setImageResource(bean.imgId);
        viewHolder.title.setText(bean.Title);
        viewHolder.content.setText(bean.Content);
        return convertView;
    }

    private class ViewHolder{
        public ImageView imgview;
        public TextView title;
        public TextView content;
    }

}
