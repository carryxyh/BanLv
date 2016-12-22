package fragmentpackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter_tab2;
import Bean.tab2_itembean;
import Utils.ReFlashListView;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import personal.example.xiuyuhang.banlv.R;
import personal.example.xiuyuhang.banlv.tab2_fx;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class Fragment2_1 extends Fragment implements ReFlashListView.IReflashListener,AdapterView.OnItemClickListener{

    private ReFlashListView listView1;

    private List<tab2_itembean> itembeanList1 = new ArrayList<tab2_itembean>();

    private BmobQuery<tab2_itembean> bmobQuery = new BmobQuery<tab2_itembean>();
    private BmobQuery<tab2_itembean> bmobQuery1 = new BmobQuery<tab2_itembean>();

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        view = View.inflate(getActivity(),R.layout.includetab2_2,null);
        Bmob.initialize(getActivity(), "5a9f501831fac63a6825cbc7a3badfce");
        listView1 = (ReFlashListView) view.findViewById(R.id.tab2_listview1);
        listView1.setInterface(this);
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        itembeanList1.add(new tab2_itembean(2130903053,"aaa","bbb"));
//        listView1.setAdapter(new MyAdapter_tab2(getActivity(),itembeanList1));
        bmobQuery.findObjects(getActivity(), new FindListener<tab2_itembean>() {
            @Override
            public void onSuccess(List<tab2_itembean> tab2_itembeans) {
                for (tab2_itembean tab2_itembean : tab2_itembeans) {
                    tab2_itembean bean = new tab2_itembean(tab2_itembean.getImgID(), tab2_itembean.getTitle(), tab2_itembean.getContent());
                    bean.setObjectId(tab2_itembean.getObjectId());
                    itembeanList1.add(bean);
                }
                listView1.setAdapter(new MyAdapter_tab2(getActivity(), itembeanList1));
            }

            @Override
            public void onError(int i, String s) {

            }
        });

        listView1.setOnItemClickListener(this);

        return view;
    }

    private void setReflashData(){
        itembeanList1.clear();
        bmobQuery1.findObjects(getActivity(),new FindListener<tab2_itembean>() {
            @Override
            public void onSuccess(List<tab2_itembean> tab2_itembeans) {
                for (tab2_itembean tab2_itembean:tab2_itembeans){
                    tab2_itembean bean = new tab2_itembean(tab2_itembean.getImgID(),tab2_itembean.getTitle(),tab2_itembean.getContent());
                    bean.setObjectId(tab2_itembean.getObjectId());
                    itembeanList1.add(bean);
                }
                listView1.setAdapter(new MyAdapter_tab2(getActivity(),itembeanList1));
            }

            @Override
            public void onError(int i, String s) {
                Log.e("hello","fail");
            }
        });
    }

    @Override
    public void onReflash() {
                setReflashData();
                listView1.reflashComplete();
            }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tab2_itembean testBean = (tab2_itembean) parent.getAdapter().getItem(position);
        Intent intent = new Intent();
        intent.setClass(getActivity(), tab2_fx.class);
        intent.putExtra("imgId",testBean.getImgID());
        intent.putExtra("title",testBean.getTitle());
        intent.putExtra("content",testBean.getContent());
        startActivity(intent);
    }
}

