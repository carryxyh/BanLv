package fragmentpackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter_tab2_2;
import Bean.tab2_itembean;
import Bean.tab2_itembean_2;
import Utils.ReFlashListView;
import personal.example.xiuyuhang.banlv.R;

/**
 * Created by xiuyuhang on tab3_3/4/17.
 */
public class Fragment2_2 extends Fragment {

    private ReFlashListView listView2;

    private List<tab2_itembean_2> itembeanList2;

    private int[] imgids;

    private void initItemBean2(){
        imgids = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};

        itembeanList2 = new ArrayList<>();

        for (int i=0;i<imgids.length;i++){
            itembeanList2.add(new tab2_itembean_2(
                    imgids[i],
                    "我是标题"+i
            ));
        }
    }

    private void initView(){
        listView2 = (ReFlashListView) view.findViewById(R.id.tab2_listview2);
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.includetab2_3,null);

        initView();
        listView2.setInterface(new ReFlashListView.IReflashListener() {
            @Override
            public void onReflash() {
                listView2.reflashComplete();
            }
        });
        initItemBean2();

        listView2.setAdapter(new MyAdapter_tab2_2(getActivity(),itembeanList2));

        return view;
    }
}
