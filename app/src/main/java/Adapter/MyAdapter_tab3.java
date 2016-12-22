package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Bean.tab3_itembean_1;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class MyAdapter_tab3 extends BaseAdapter{

    private List<tab3_itembean_1> mylist;

    private LayoutInflater mInflater;

    public MyAdapter_tab3(Context context,List<tab3_itembean_1> list){
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
        View view = mInflater.inflate(R.layout.adaptercontenttab3,null);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.adaptercontenttab3,null);
            viewHolder.imgview_tab3 = (ImageView) convertView.findViewById(R.id.scenerytab3_1);
            viewHolder.title_tab3 = (TextView) convertView.findViewById(R.id.titletab3_1);
            viewHolder.content_tab3 = (TextView) convertView.findViewById(R.id.contenttab3_1);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        tab3_itembean_1 bean = mylist.get(position);
        viewHolder.imgview_tab3.setImageResource(bean.imgid_tab3);
        viewHolder.title_tab3.setText(bean.title_tab3);
        viewHolder.content_tab3.setText(bean.content_tab3);
        return convertView;
    }

    private class ViewHolder{
        public ImageView imgview_tab3;
        public TextView title_tab3;
        public TextView content_tab3;
    }
}
