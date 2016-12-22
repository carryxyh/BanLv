package ImageAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by xiuyuhang on tab3_3/4/23.
 */
public class ImageAdapter extends BaseAdapter {

    private int[] res;
    private ImageView imgview;
    private Context context;

    public ImageAdapter(int[] res,Context context){
        this.res = res;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return res[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        imgview = new ImageView(context);
        imgview.setBackgroundResource(res[position%res.length]);
        imgview.setLayoutParams(new Gallery.LayoutParams(500, 400));
        imgview.setScaleType(ImageView.ScaleType.FIT_XY);
        return imgview;
    }
}
