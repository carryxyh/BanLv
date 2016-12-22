package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import Bean.tab2_itembean_3;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class MyAdapter_tab2_3 extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<tab2_itembean_3> mylist;

    public MyAdapter_tab2_3(Context context,List<tab2_itembean_3> list){
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
        View view = mInflater.inflate(R.layout.adaptercontenttab2_3,null);
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.adaptercontenttab2_3,null);
            viewHolder.imgview_3 = (ImageView) convertView.findViewById(R.id.scenerytab2_3);
            viewHolder.title_3 = (TextView) convertView.findViewById(R.id.titletab2_3);
            viewHolder.content_3 = (TextView) convertView.findViewById(R.id.contenttab2_3);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        tab2_itembean_3 bean = mylist.get(position);
        viewHolder.imgview_3.setImageResource(bean.imgidtab2_3);
        viewHolder.title_3.setText(bean.titletab2_3);
        viewHolder.content_3.setText(bean.contenttab2_3);
        return convertView;
    }

    private class ViewHolder{
        public ImageView imgview_3;
        public TextView title_3;
        public TextView content_3;
    }
}
